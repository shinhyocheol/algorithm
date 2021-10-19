package programmers;

import java.util.*;

public class ListLotation {

    public static void main(String[] args) {

        int rows = 6;
        int cols = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        ListLotation a = new ListLotation();

        int[] result = a.solution(rows, cols, queries);

        System.out.println();
        for (int i=0; i<result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();

    }

    public int[] solution(int rows, int cols, int[][] queries) {
        int[] result = new int[queries.length];
        int[][] board = new int[rows][cols];
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                board[i][j] = (i * cols) + j+1;
            }
        }

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        // 오름차순
        for (int i=0; i<queries.length; i++) {
            Queue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);

            // 왼쪽 위 꼭지점
            int leftTopX = queries[i][0]-1;
            int leftTopY = queries[i][1]-1;

            // 오른쪽 위 꼭지점
            int rightTopX = queries[i][0]-1;
            int rightTopY = queries[i][3]-1;

            // 왼쪽 아래 꼭지점
            int leftBotX = queries[i][2]-1;
            int leftBotY = queries[i][1]-1;

            // 오른쪽 아래 꼭지점
            int rightBotX = queries[i][2]-1;
            int rightBotY = queries[i][3]-1;


            int prev = board[leftTopX][leftTopY];   // 이전요소
            int next = 0;                           // 다음요소

            // 왼쪽 위 -> 오른쪽 위 한칸씩 이동
            for (int j=0; j<rightTopY-leftTopY; j++) {
                // 다음순번의 값을 next에 저장
                next = board[leftTopX][leftTopY+j+1];

                // 다음순번에 prev 저장
                board[leftTopX][leftTopY+j+1] = prev;
                queue.add(prev);

                // 다음순번인 next가 prev로 다시 이동
                prev = next;
            }

            // 오른쪽 위 -> 오른쪽 아래 한칸씩 이동
            for (int j=0; j<rightBotX - rightTopX; j++) {
                next = board[rightTopX + j + 1][rightTopY];

                board[rightTopX + j + 1][rightTopY] = prev;
                queue.add(prev);

                prev = next;
            }

            // 오른쪽 아래 -> 왼쪽 아래 한칸씩 이동
            for (int j=0; j<rightBotY - leftBotY; j++) {
                next = board[rightBotX][rightBotY-(j + 1)];

                board[rightBotX][rightBotY-(j + 1)] = prev;
                queue.offer(prev);

                prev = next;
            }

            // 왼쪽 아래 -> 왼쪽 위 한칸씩 이동
            for (int j=0; j<leftBotX - leftTopX; j++) {
                next = board[leftBotX - (j+1)][leftBotY];

                board[leftBotX - (j+1)][leftBotY] = prev;
                queue.offer(prev);

                prev = next;
            }

            result[i] = queue.peek();
        }

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        return result;
    }
}

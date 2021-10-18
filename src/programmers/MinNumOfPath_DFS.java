package programmers;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinNumOfPath_DFS {

    public static void main(String[] args) {
        int[][] board = {{1, 2, 3}, {4, 5, 6}};
        MinNumOfPath_DFS a = new MinNumOfPath_DFS();
        int result = a.solution(board);

        System.out.println("result : " + result);
    }

    public int solution(int[][] board) {

        // 예외처리
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0)
            return 0;

        // 우선순위 큐(각 경로의 점수합계를 저장한다. 오름차순으로)
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
        // 방문저장
        boolean[][] visited = new boolean[board.length][board[0].length];

        // 첫번째를 기점으로 보드 탐색 시작
        dfs(board, visited, queue, board[0][0], 0, 0);

        // 탐색이 완료된 후 저장된 합계중 가장 첫번째 요소를 리턴(오름차순이므로 첫번째가 가장 작은 점수)
        return queue.poll();
    }

    public void dfs(int[][] board, boolean[][] visited, Queue<Integer> queue, int sum, int x, int y) {

        // 행의 길이
        int rows = board.length;
        // 열의 길이
        int cols = board[0].length;

        // 가장 끝 지점에 도착하면 합산 점수 큐에 넣고 탐색 끝
        if (x == (rows-1) && y == (cols-1)) {
            queue.offer(sum);
            return;
        }

        // 이미 방문했다면 탐색 중지
        if (visited[x][y])
            return;

        // 방문처리하고 숫자 집계
        visited[x][y] = true;

        // 상하좌우 좌표(여기서 상에 대한 좌표를 제외 시킬 수 있는 경우가 존재함)
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // 현재 위치에서 상하좌우 좌표 체크
        for (int[] dir : dirs) {
            int x1 = x + dir[0];
            int y1 = y + dir[1];

            // 탐색 범위를 벗어난다면 탐색 X
            if (x1>=0 && y1>=0 && x1<rows && y1<cols) {
                dfs(board, visited, queue, (sum + board[x1][y1]), x1, y1);
            }
        }

        // 다른 경로가 이 정점을 사용할 수 있음
        visited[x][y] = false;
    }

}

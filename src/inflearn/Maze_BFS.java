package inflearn;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @문제설명 : m * n 크기의 미로(이차원 배열)가 주어집니다.
 *      미로에서 각 셀은 빈 공간(0)과 벽(1)으로 구성되어있습니다. 빈 공간에는 공이 있습니다.
 *      1. 공은 위, 아래, 왼쪽 또는 오른쪽으로 굴러 빈 공간을 통과 할 수 있지만 벽에 부딪 힐 때까지
 *          굴러가는 것을 멈추지 않습니다. 공이 멈추면 다음 방향을 선택할 수 있습니다.
 *      2. 공의 start destination 위치는 start [start , start], destination = [destication, destination]
 *      3. 공이 목적지에서 멈출 수 있으면 true, 그렇지 않다면 false를 리턴합니다.
 *      4. 미로의 경계는 모두 벽이라고 가정합니다.
 *
 * @input :
 *          int[][] maze = {
 *                 {0, 0, 1, 0, 0},
 *                 {0, 0, 0, 0, 0},
 *                 {0, 0, 0, 1, 0},
 *                 {1, 1, 0, 1, 1},
 *                 {0, 0, 0, 0, 0}
 *         };
 *         int[] start = {0, 4}; // 시작점 좌표
 *         int[] destication = {4, 4}; // 목적지 좌표
 *
 * @ouput : true
 *
 * @문제분석 :
 *      1. 공은 굴러가는 방향으로 빈공간이면 멈추지 않는다.
 *      2. 벽(1)을 만나야만 멈출 수 있는 조건을 가진다.
 *      3. 따라서 주변에 가까운 경로가 보인다하더라도 경로를 스스로 바꿀 수 없다.
 *
 * @시간복잡도 : O(rows*cols)
 *  대상 : maze[][]
 *  이유 : rows 만큼 cols 길이를 반복실행
 *
 * @공간복잡도 : O(rows*cols)
 *  대상 : boolean[][] visited
 *  이유 : rows 만큼 cols 길이의 visited를 저장
 */
public class Maze_BFS {

    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        int[] start = {0, 4}; // 시작점 좌표
        int[] destication = {4, 4}; // 목적지 좌표

        Maze_BFS a = new Maze_BFS();
        boolean result = a.solution(maze, start, destication);
        System.out.println("is Result ?? : " + result);
    }

    public boolean solution(int[][] maze, int[] start, int[] destication) {
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0) {
            return  false;
        }
        int rows = maze.length;
        int cols = maze[0].length;
        int[][] dirs = { {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        if (start[0] == destication[0] && start[1] == destication[1])
            return true;

        // 방문저장배열
        boolean[][] visited = new boolean[rows][cols];
        visited[start[0]][start[1]] = true; // 시작점은 true 처리

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start[0], start[1]});

        while (!queue.isEmpty()) {
            // 현재 위치 꺼내오기(현재 위치부터 탐색시작)
            int[] cur = queue.poll();
            // 4 방향 탐색(상하좌우)
            for (int[] dir : dirs) {
                int x = cur[0];
                int y = cur[1];
                // 탐색 범위 이내여야 하고, 탐색하는 곳이 벽이 아니면 현재 dir 에 해당되는 방향으로 한칸이동
                // 다시 탐색 범위 이내여야 하고, 탐색하는 곳이 벽이 아닌지 확인하고 dir에 해당되는 방향으로 한칸이동
                // 해당 조건이 계속 성립될때까지 같은 방향으로 계속 이동
                while (x>=0 && x<maze.length && y>=0 && y<maze[x].length && maze[x][y]==0) {
                    // 현재 방이 벽이 아닌 빈공간이면 벽을 만날떄까지 계속 반복실행함.
                    x += dir[0];
                    y += dir[1];
                }

                // 벽을 만나서 더이상 나아갈 수 없으므로 반복문 빠져나옴(현재 x와 y는 벽에 위치한 상태)
                // 이전 벽을 마주하기 전 공간으로 다시 복귀하고, 해당 좌표 방문처리
                x -= dir[0];
                y -= dir[1];
                System.out.println("벽전 x : " + x + ", 벽전 y : " + y);

                if (visited[x][y]) // 이미 방문한 공간이면 더이상 진행하지 않고 다음 dir로 넘어감
                    continue;

                visited[x][y] = true;   // 방문처리
                print(visited); // 방문처리 출력해보기

                // 현재 좌표를 목적지 좌표와 비교해서 도착했으면 나머지 수행할 필요없이 true 리턴하고 종료
                if (x == destication[0] && y == destication[1])
                    return true;

                // 목적지와 같지 않다면 현재 좌표 큐에 저장
                queue.offer(new int[] {x, y});

            }
        }

        // 큐가 비는동안 목적지에 도착하지 못했다면 여기까지 옴
        return false;
    }

    public void print(boolean[][] visited) {
        System.out.println();
        for (int i=0; i<visited.length; i++) {
            for (int j=0; j<visited[i].length; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }
}

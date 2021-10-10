package inflearn;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @문제설명 : m X n binary grid가 주어집니다. 각 셀의 값 중에 '1'은 땅이고 '0'은 물입니다.
 *      섬은 물에 의해 둘러싸입니다. 섬은 수직 또는 수평으로 인접하는 땅(1)을 연결함으로써 형성됩니다.
 *      섬은 grid의 네 모서리가 모두 물로 쌓여있다고 가정 할 수 있습니다.
 *      섬의 개수를 리턴하세요. BFS 알고리즘을 적용하여 풀어보세요.
 *
 * @input :
 *      grid1 = {
 *          {"1", "1", "1", "1", "0"},
 *          {"1", "1", "1", "1", "0"},
 *          {"1", "1", "0", "0", "0"},
 *          {"0", "0", "0", "0", "0"}
 *      }
 *      grid2 = {
 *          {"1", "1", "0", "0", "0"},
 *          {"1", "1", "0", "0", "0"},
 *          {"1", "1", "0", "0", "0"},
 *          {"0", "0", "0", "1", "1"}
 *      }
 *
 * @ouput : grid = 1, grid2 = 2
 *
 * @문제분석 :
 *      1. 진입시점이 몇개가 존재하느냐가 섬의 갯수가 된다.
 *      2. DFS 검색과 달리 수직방향으로 검색하는 것이 아닌 근처부분을 먼저 탐색하는 수평방향으로 검색한다.
 *      3. 따라서 DFS는 stack을 사용했다면 BFS는 queue를 사용해 인접 노드를 먼저 큐에 저장한다.
 *      4. 저장된 순으로 노드를 꺼내와 방문하고 방문표시를 한다.
 *      5. 방문표시를 하면서 근처에 방문해야 할 노드가 있다면 큐에 저장한다.
 *      6. 위 작업을 반복한다. 큐에 더이상 저장된 노드가 없다면 반복문을 빠져나온다.
 *      7. 노드 탐색 -> 탐색중인 노드 방문표시(더이상 방문 필요 없다는 것을 표시) -> 인접 노드 중 방문할 곳이 있다면 큐에 저장 -> 큐에 저장된 순서대로 하나씩 꺼내와서 앞 작업 반복 -> 큐에 노드가 없을때까지!!
 *      8. DFS 와 결과는 같다. 다만 탐색 방식이 다르다.
 *
 * @시간복잡도 : O(rowSize*colSize)
 *  대상 : char[][] grid
 *  이유 : m은 rows, n은 columns
 *
 * @공간복잡도 : O(min(rowSize, colSize))
 *  대상 : Queue<Integer> queue = new LinkedList<>()
 *  이유 : 큐에 좌표값 저장 계산 O(max(rowSize, colSize)) or O(min(rowSize, colSize)) 중 하나
 *
 */
public class NumberOfIsland_BFS {

    char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '1', '1'}
    };

    // 탐색방향설정
    // row * col 만큼의 배경판이 설정된다.
    // 대각위치의 방향은 검색하지 않으므로 자신의 위치를 기준으로
    // 위쪽, 아래쪽, 오른쪽, 왼쪽 총 4 방향의 탐색 좌표를 리스트로 선언
    // 위쪽 : 현재 위치에서 row -1, col 0 만큼 이동
    // 아래쪽 : 현재 위치에서 row 1, col 0 만큼 이동
    // 오른쪽 : 현재 위치에서 row 0, col 1 만큼 이동
    // 왼쪽 : 현재 위치에서 row 0, col -1 만큼 이동
    int[][] dirs = { {-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    int rowSize; // 행
    int colSize; // 열

    public static void main(String[] args) {

        NumberOfIsland_BFS a = new NumberOfIsland_BFS();

        int result = a.solve();

        System.out.println("================================");
        System.out.println("BFS result : " + result);
        System.out.println("================================");

    }

    public int solve() {
        int result = 0;

        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return result;

        rowSize = grid.length;          // 로우 길이
        colSize = grid[0].length;       // 컬럼 길이

        // 로우의 길이만큼 반복
        for (int i=0; i<rowSize; i++) {
            // 컬럼의 길이만큼 반복
            for (int j=0; j<colSize; j++) {
                // '1'을 만나면 땅에 진입한 것이므로 우선 카운트
                if (grid[i][j] == '1') {
                    result++;
                    // 인접요소가 '1'이라면 연결된 땅이므로 카운트가 되지 않아야 한다.
                    // 재귀함수를 통해 탐색
                    bfs(grid, i, j);
                }
            }
        }
        return result;
    }
    public void bfs(char[][] grid, int x, int y) {
        grid[x][y] = 'X'; // 방문 표시를 해놓음.
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {x, y}); // 0, 0

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            // 4 방향 탐색 시작
            for (int[] dir : dirs) {

                int x1 = cur[0] + dir[0]; // 0 + x
                int y1 = cur[1] + dir[1]; // 0 + y

                // 이 부분을 잘 기억해야 함
                // 탐색 범위에서 벗어난다면 방문 X (예를 들어 마이너스 좌표)
                // 이미 탐색한 위치이거나 조건에 맞지 않는 위치라면 방문 X
                // 탐색한 곳은 반드시 방문을 했다는 것을 표시할 것
                // 탐색하면서 인접요소에 대한 좌표를 큐에저장
                // 큐에 저장된 순서대로 꺼내와서 탐색한다는 것을 기억할 것
                // 큐에 비어있다면 방문해야할 인접요소가 없다는 뜻이므로 반복문 종료
                if (x1 >= 0 && y1 >= 0 && x1 < rowSize && y1 < colSize && grid[x1][y1] == '1') {
                    grid[x1][y1] = 'X'; // 탐색했으니 방문표시
                    queue.offer(new int[] {x1, y1}); // 탐색한 곳이 땅이라면 탐색한 요소의 인접요소를 검사해야하니 해당 요소 좌표 큐에 저장
                }
            }

        }

    }
}

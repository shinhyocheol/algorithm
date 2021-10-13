package inflearn;

/**
 *
 * @문제설명 : m X n binary grid가 주어집니다. 각 셀의 값 중에 '1'은 땅이고 '0'은 물입니다.
 *      섬은 물에 의해 둘러싸입니다. 섬은 수직 또는 수평으로 인접하는 땅(1)을 연결함으로써 형성됩니다.
 *      섬은 grid의 네 모서리가 모두 물로 쌓여있다고 가정 할 수 있습니다.
 *      섬의 개수를 리턴하세요. DFS 알고리즘을 적용하여 풀어보세요.
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
 *
 * @시간복잡도 : O(M*N)
 *  대상 : char[][] grid
 *  이유 : m은 rows, n은 cols
 *
 * @공간복잡도 : O(M*N) worst case
 *  대상 : 내부 stack 생성
 *  이유 :
 *
 */
public class NumberOfIsland_DFS {

    char[][] grid2 = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
    };
    char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '1', '1'}
    };
    int m = grid.length; // 행
    int n = grid[0].length; // 열
    int[][] dirs = { {-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int count = 0;

    public static void main(String[] args) {

        NumberOfIsland_DFS a = new NumberOfIsland_DFS();

        int result = a.solve();

        System.out.println("================================");
        System.out.println("grid 1 result : " + result);
        System.out.println("================================");

    }

    public int solve() {
        int result = 0;

        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return result;
        }
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }
    public void dfs(char[][] grid, int i, int j) {

        // error check
        // i 가 m 의 영역에 포함되지 않는 경우
        // j 가 n 의 영역에 포함되지 않는 경우
        // i의 j번째 요소가 '1'이 아닌 경우
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') {
            return;
        } else {
            System.out.println("[i]: " + i + ", [j] : " + j);
        }

        grid[i][j] = 'X'; // 방문처리 (이렇게 해야 이후에 같은 지점을 방문하더라도 재검사 하는 일이 발생하지 않는다.)

        // 인접노드 탐색
        for (int[] dir : dirs) {
            dfs(grid, i+dir[0], j+dir[1]);
        }
    }

}

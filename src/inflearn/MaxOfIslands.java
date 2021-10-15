package inflearn;

import java.util.Map;

/**
 *
 * @문제설명 : rows * cols 크기의 이차원 배열이 주어집니다. 육지는 1, 물은 0으로 표시합니다.
 *          육지는 수평, 수직방향으로 연결될 수 있습니다.(대각선은 연결되지 않습니다)
 *          이때 가장 크기가 큰 땅의 수를 반환하세요.
 *
 * @input :
 *      grid = {
 *          {"1", "1", "", "1", "1"},
 *          {"0", "1", "1", "0", "0"},
 *          {"0", "0", "0", "0", "0"},
 *          {"1", "1", "0", "1", "1"},
 *          {"1", "0", "1", "1", "1"},
 *          {"1", "0", "1", "1", "1"}
 *      }
 *
 * @ouput : grid = 8
 *
 * @문제분석 :
 *      1. Number Of island 섬의 개수를 구한다.
 *      2. count 변수를 두고 4, 2, 5, 8 중 가장 큰 8을 반환하면 된다.
 *
 * @시간복잡도 :
 *  대상 :
 *  이유 :
 *
 * @공간복잡도 :
 *  대상 :
 *  이유 :
 *
 */
public class MaxOfIslands {

    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '0','1', '1'},
                {'0', '1', '1', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'1', '1', '0', '1', '1'},
                {'1', '0', '1', '1', '1'},
                {'1', '0', '1', '1', '1'}
        };
        int[][] dirs = { {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        MaxOfIslands a = new MaxOfIslands();
        int result = a.solve(grid, dirs);

        System.out.println(result);
    }

    public int solve(char[][] grid, int[][] dirs) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int max = 0;

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (grid[i][j] == '1') {
                   int area = dfs(grid, dirs, i, j, 0);
                   max = Math.max(max, area);
                }
            }
        }

        return max;
    }

    public int dfs(char[][] grid, int[][] dirs, int x, int y, int area) {

        // 1. 탐색범위 체크
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] == '0') {
            return area;
        }
        // 탐색이 끝난경우 방문표시
        grid[x][y] = '0';
        // 땅의 수 증가
        area++;

        // 주변에 땅이 있는지 확인
        for (int i=0; i<dirs.length; i++) {
            area = dfs(grid, dirs, x+dirs[i][0], y+dirs[i][1], area);
        }

        return area;
    }
}

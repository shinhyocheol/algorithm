package inflearn;

/**
 *
 * @문제설명 : 문자들이 저장된 이차원 배열형식의 보드, 문자가 주어집니다.
 *          보드에서 주어진 문자내용과(문자순) 일치하는 경로가 있는지를 확인합니다.
 *
 * @input : word = "ABCCED"
 * board = {
 *     {"A", "B", "C", "E"},
 *     {"S", "F", "C", "S"},
 *     {"A", "D", "E", "E"},
 * }
 *
 * @ouput : true
 *
 * @문제분석 :
 *  1. DFS 탐색을 이용한다.
 *  2. 아직 문자열의 내용이 모두 사용될때까지 탐색을 한다.
 *  3. 문자열의 내용이 모두 사용될때까지 탐색이 진행되면 존재한다는 뜻이다.
 *  4. 문자열의 내용이 모두 사용되지 않았는데 탐색이 끝난다면 존재하지 않는 것이다.
 *
 * @시간복잡도 :
 *  대상 :
 *  이유 :
 *
 * @공간복잡도 :
 *  대상 :
 *  이유 :
 */
public class WordSearch {

    public static void main(String[] args) {

        WordSearch a = new WordSearch();

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";

        for(int i=0; i<board.length; i++) {
            for (int j=0; j<board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("is Word ?? : " + a.solve(board, word));

    }

    public boolean solve(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (dfs(board, visited, dirs, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] borad, boolean[][] visited, int[][] dirs, int x, int y, int start, String word) {

        // 현재까지 누적된 start가 검색 글자의 수와 같다면 아래 과정을 통과하고 계속 누적된것이므로 탐색을 멈추고 검색글자는 존재하는 것으로 판단
        if (start == word.length())
            return true;

        // x와 y의 좌표가 보드의 범위를 벗어난다면 탐색 X
        if (x < 0 || x >= borad.length || y < 0 || y >= borad[x].length)
            return false;

        // 해당정점을 이미 방문했다면 탐색 X
        if (visited[x][y]) return false;
        
        if (borad[x][y] != word.charAt(start)) return false;

        visited[x][y] = true;
        for (int[] dir : dirs) {

            int x1 = x+dir[0];
            int y1 = y+dir[1];

            if (dfs(borad, visited, dirs, x1, y1, (start+1), word)) {
                return true;
            }
        }

        visited[x][y] = false;
        return false;
    }
}

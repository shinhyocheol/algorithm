package codility;

public class ShipBoard {

    public static void main(String[] args) {
        String[] B = {".##.#", "#.#..", "#...#", "#.##."};

        // 주어진 문자 배열 탐색을 쉽게 하기 위해 2차 배열로 생성한다.
        char[][] board = new char[B.length][B[0].length()];
        for (int i=0; i<B.length; i++) {
            for (int j=0; j<B[i].length(); j++) {
                board[i][j] = B[i].charAt(j);
            }
        }

        ShipBoard a = new ShipBoard();
        int[] result = a.solution(board);

        for (int i=0; i<result.length; i++) {
            System.out.println("result[" + i + "] : " + result[i]);
        }
    }

    public int[] solution(char[][] board) {
        int[] result = new int[3];
        if (board == null || board.length == 0) return result;

        int rows = board.length;        // 행의 수
        int cols = board[0].length;     // 열의 수
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 탐색(상하좌우 순) 좌표

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (board[i][j] == '#') {
                    int area = dfs(board, dirs, i, j, 0);
                    if (area == 3) result[0]++;
                    else if (area == 2) result[1]++;
                    else if (area == 1) result[2]++;
                }
            }
        }

        return result;
    }

    public int dfs(char[][] board, int[][] dirs, int x, int y, int area) {
        // 탐색범위를 벗어나거나
        // . 인경우(이 경우는 애초에 땅이 아니거나 이미 방문해서 더이상 방문하지 않기위해 .으로 바꾼경우다.
        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length || board[x][y] == '.'){
            return area;
        }

        board[x][y] = '.';  // 해당 위치 탐색완료 저장
        area++; // 배 크기 증가

        // 주변 탐색
        for (int i=0; i<dirs.length; i++) {
            // area가 계속 파라미터로 전달되기때문에 주변에 #이 확인 될때마다 1씩 증가하며 전달되고,
            // 탐색이 끝난 경우 위 조건에 걸려 탐색동안 누적된 area를 반환한다.
            area = dfs(board, dirs, x+dirs[i][0], y+dirs[i][1], area);
        }

        return area;
    }

}

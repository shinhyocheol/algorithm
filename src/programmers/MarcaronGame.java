package programmers;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 문제 설명
 * 마카롱 게임은 6 x 6 크기 게임 보드에 위에서 아래 방향으로 마카롱을 하나씩 떨어뜨려 같은 색 마카롱이 상, 하, 좌, 우 방향으로 3개 이상 연결되면 터지는 게임입니다. 마카롱은 항상 빈칸 없이 가장 아래부터 차곡차곡 쌓입니다. 또, 마카롱이 터져서 없어지면 위 칸의 마카롱이 차례대로 아래 칸으로 떨어집니다. 만약, 떨어진 마카롱이 다시 3개 이상 연결된다면 연결된 마카롱도 연쇄적으로 터지며, 더 터지는 마카롱이 없을 때까지 게임 보드 위의 마카롱이 아래 방향으로 떨어집니다. 단, 현재 게임보드에 3개 이상 연결된 마카롱이 여러 개라면 한꺼번에 터진다고 가정합니다.
 *
 * 아래는 게임이 진행되는 예시입니다. 처음에 게임 보드 각 칸은 전부 빈 상태입니다.
 *
 * 1.
 * 1번 → 2번 → 1번 → 3번 → 6번 → 3번 위치 순서로 각 색상의 마카롱을 떨어트린 후 보드 상태는 아래 그림과 같습니다.
 *
 * macaron_11.png
 *
 * 2.
 * 3번 → 3번 → 3번 위치 순서로 마카롱을 떨어트리면 아래 그림과 같습니다.
 *
 * macaron_12.png
 *
 * 3.
 * 2번 위치에서 분홍색 마카롱을 떨어뜨리면 아래 그림과 같이 'X' 표시된 마카롱 4개가 연결되어 없어집니다.
 *
 * macaron_13.png
 *
 * 4.
 * 분홍색 마카롱이 없어진 후, 남은 마카롱이 모두 아래 방향으로 떨어집니다. 다시 'X' 표시된 보라색 마카롱 3개가 연결되어 없어집니다.
 *
 * macaron_14.png
 *
 * 5.
 * 남은 마카롱이 모두 아래로 떨어진 후 게임 보드 상태는 아래 그림과 같습니다.
 *
 * maracon_15.png
 *
 * 어떤 위치에 무슨 색 마카롱을 떨어뜨렸는지에 대한 정보를 담은 2차원 배열 macaron이 매개변수로 주어질 때, 게임이 모두 진행된 후 게임 보드의 상태를 문자열 형태로 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * macaron의 세로(행) 길이는 1 이상 100 이하이며, 가로(열) 길이는 2입니다.
 * macaron의 각 행에는 마카롱을 떨어뜨린 정보가 [떨어뜨린 위치, 마카롱의 색] 형태로 담겨있습니다.
 * 마카롱을 떨어뜨린 위치는 1 이상 6 이하인 자연수입니다.
 * 마카롱의 색은 1 이상 9 이하인 자연수 형태로 표현하며, 같은 색상의 마카롱은 같은 숫자로 표현합니다.
 * 마카롱이 보드 밖으로 나가도록 하거나, 마카롱이 최대 높이까지 쌓인 줄에 다시 마카롱을 떨어뜨리는 경우는 없습니다.
 * 정답은 길이가 6인 문자열 6개를 return 해주세요.
 * return 하는 배열의 첫 번째 원소는 게임 보드의 가장 윗 열을 나타내며, 이후 가장 아래 열까지 순서대로 넣으면 됩니다.
 * 게임 보드에서 빈칸은 0, 마카롱이 채워진 칸은 해당 마카롱의 색을 나타내는 자연수를 채우면 됩니다.
 * 입출력 예
 * macaron	result
 * [[1,1],[2,1],[1,2],[3,3],[6,4],[3,1],[3,3],[3,3],[3,4],[2,1]]	["000000","000000","000000","000000","000000","204004"]
 * [[1,1],[1,2],[1,4],[2,1],[2,2],[2,3],[3,4],[3,1],[3,2],[3,3],[3,4],[4,4],[4,3],[5,4],[6,1]]	["000000","000000","000000","000000","000000","404001"]
 * 입출력 예 설명
 * 입출력 예 #1
 *
 */
public class MarcaronGame {

    public static void main(String[] args) {
        MarcaronGame a = new MarcaronGame();
        int[][] input = {
                {1, 1},
                {2, 1},
                {1, 2},
                {3, 3},
                {6, 4},
                {3, 1},
                {3, 3},
                {3, 3},
                {3, 4},
                {2, 1}
        };

        String[] result = a.solution(input);
        for (int i=0; i<result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public String[] solution(int[][] input) {

        String[] result = new String[6];

        // 방문표시용 초기화
        boolean[][] visited = new boolean[6][6];

        // 연속된 컬러가 탐색될 시 해당 좌표를 저장할 map
        List<Map<Integer, Integer>> listMap = new ArrayList<>();

        // 보드 초기화
        char[][] board = new char[6][6];
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board.length; j++) {
                board[i][j] = '0';
            }
        }

        for (int i=0; i<input.length; i++) {
            for (int j=0; j<board.length; j++) {
                int boardX = 5-j;
                int boardY = input[i][0] - 1;
                if (board[boardX][boardY] == '0') {
                    board[boardX][boardY] = (char)(input[i][1] + '0');

                    // 마카롱이 떨어지는 순간 보드탐색 시작
//                    dfs(board, visited, 0, 0, 0, board[0][0], map);
                    break;
                }
            }
        }

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                if (board[j][i] != '0') {
                    visited = new boolean[6][6];
                    listMap = new ArrayList<>();
                    System.out.println("===============================================================================");
                    dfs(board, visited, j, i, 0, board[j][i], listMap);
                    System.out.println("===============================================================================");
                }
            }
        }

        for (int i=0; i<board.length; i++) {
//            for (int j=0; j<board.length; j++) {
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
            result[i] = new String(board[i]);
        }

        return result;
    }

    public void dfs(char[][] board, boolean[][] visited, int x, int y, int point, char searchColor, List<Map<Integer, Integer>> listMap) {

        // 탐색범위가 마카롱보드 범위에서 벗어난다면 탐색 X
        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length)
            return;

        // 이미 탐색한 곳이라면 탐색 X
        if (visited[x][y])
            return;

        // 현재의 마카롱과 넘겨받은 마카롱이 다르다면 더이상 탐색 X
        // 누적포인트 체크
        if (board[x][y] != searchColor) {
            point = 0;
            return;
        }

        System.out.print("visited : " + visited[x][y] + ", x : " + x + ", y : " + y);
        System.out.print(", point : " + point + ", macaronColor : " + board[x][y]);
        System.out.println(", searchColor : " + searchColor + ", map : " + listMap);

        // 누적포인트 확인해서 3을 넘어가면 해당구역 터뜨리기
        if (point >= 3) {
            board[x][y] = '0';
            for (int i=0; i<listMap.size(); i++) {
                for (int key : listMap.get(i).keySet()) {
                    int val = listMap.get(i).get(key);
                    board[key][val] = '0';
                }
                listMap.remove(i);
            }
        }

        // 현 탐색좌표 방문저장하고, map에 좌표 저장
        visited[x][y] = true;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(x, y);
        listMap.add(map);

        // 여기까지 왔다는 것은 넘겨받은 마카롱의 색상과 현재 좌표의 마카롱 색상이 같다는 뜻
        searchColor = board[x][y];

        // 인접 마카롱 탐색
        int[][] dirs = { {-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : dirs) {
            int x1 = x + dir[0];
            int y1 = y + dir[1];

            dfs(board, visited, x1, y1, (point + 1), searchColor, listMap);

        }
    }


}

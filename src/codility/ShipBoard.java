package codility;

public class ShipBoard {

    int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    int[] result;

    public static void main(String[] args) {
        String[] B = {".##.#", "#.#..", "#...#", "#.##."};
        ShipBoard a = new ShipBoard();
        int[] result = a.solution(B);
    }

    public int[] solution(String[] B) {
        result = new int[3];

        for (int i=0; i<B.length; i++) {
            for (int j=0; j<B[i].length(); j++) {
                if (B[i].charAt(j) == '#') {
                    dfs(B, i, j, 0);
                }
            }
        }

        return result;
    }

    public void dfs(String[] B, int i, int j, int cnt) {

        if (i < 0 || i >= B.length || j < 0 || j >= B[i].length()) {
            return;
        }

        if (B[i].charAt(j) != '#') {
            if (cnt == 3) {
                result[2]++;
            } else if (cnt == 2) {
                result[1]++;
            } else if (cnt == 1) {
                result[0]++;
            }
            return;
        }

        B[i].replace(B[i].charAt(j), 'X');
        System.out.println(B[i]);
        cnt++;

        for (int[] dir : dirs) {
            dfs(B, i+dir[0], j+dir[1], cnt);
        }

    }

}

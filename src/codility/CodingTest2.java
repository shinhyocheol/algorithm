package codility;

public class CodingTest2 {

    int[][] dirs = {{0, -1}, {0, +1}, {-1, 0}, {+1, 0}};
    int[] result;

    public static void main(String[] args) {
        String[] B = {".##.#", "#.#..", "#...#", "#.##."};
        CodingTest2 a = new CodingTest2();
        int[] result = a.solution(B);
    }

    public int[] solution(String[] B) {
        result = new int[3];

        for (int i=0; i<B.length; i++) {
            for (int j=0; j<B[i].length(); j++) {
                if (B[i].charAt(j) == '#') {
                    search(B, i, j, 0);
                }
            }
        }

        return result;
    }

    public void search(String[] B, int i, int j, int cnt) {

        if (i < 0 || i >= B.length || j < 0 || j >= B[i].length() || B[i].charAt(j) != '#') {
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
        cnt++;

        for (int[] dir : dirs) {
            search(B, i+dir[0], j+dir[1], cnt);
        }

    }

}

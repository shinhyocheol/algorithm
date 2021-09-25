package basic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @문제설명 : 나선형 매트릭스
 *  Given a matrix of m x n elements (m rows, n columns),
 *  return all elements of the matrix in spiral order
 *  번역 : m x n 요소(m 행, n 열)의 행렬이 주어지면, 행렬의 모든 요소를 나선형 순서로 반환하세요.
 *
 * @제한사항 :
 *      m == matrix.legnth
 *      n == matrix[i].length
 *      1 <= m, n <= 10
 *      -100 <= matrix[i][j] <= 100
 *
 * @input : int[][] matirix =
 *          [0]int[] = {1, 2, 3, 4};
 *          [1]int[] = {5, 6, 7, 8};
 *          [2]int[] = {9, 10, 11, 12};
 * @ouput : [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
 *
 * @문제분석 :
 *          1. 2차원 배열 좌표값 이해
 *          2. 행과 열의 위치 파악
 *          3. 상하좌우 위치 좌표값 변경
 *
 * @시간복잡도 :
 *
 * @공간복잡도 :
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        SpiralMatrix a = new SpiralMatrix();
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        List<Integer> result = a.slove(matrix);
        System.out.println("==========================");
        System.out.println("result: " + result);
//        for (int i=0; i<result.size(); i++) {
//            System.out.println("result[" + i + "] : " + result[i]);
//        }
        System.out.println("==========================");

    }

    public List<Integer> slove(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int rowStart = 0;
        int rowEnd = matrix.length - 1;

        int colStart = 0;
        int colEnd = matrix[0].length - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // right
            for (int i=colStart; i<=colEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
            rowStart++;
            // down
            for (int i=rowStart; i<=rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            // left
            if (rowStart <= rowEnd) {
                for (int i=colEnd; i>= colStart; i--) {
                    result.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            // up
            if (colStart <= colEnd) {
                for (int i=rowEnd; i>=rowStart; i--) {
                    result.add(matrix[i][colStart]);
                }
            }
            colStart++;

        }

        return result;
    }

}

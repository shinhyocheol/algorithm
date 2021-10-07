package inflearn;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @문제 : 원점에 가장 가까운 지점
 * @설명 : XY 평면의 한 점과 정수를 나타내는 배열이 주어지면 원점에 가장 가까운 점을
 * 반환합니다. XY 폋면에서 두 점 사이의 거리 구하는 공식을 이용하세요
 * @공식 : root( ((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)) )
 * 원점에서 제일 가까운 좌표를 K개의 갯수만큼 리턴하세요.
 *
 *
 * @input : points = [[1,3], [-2,2]], K = 1
 * @output: [[-2,2]]
 * @explanation:
 *  1. 원점에서 좌표 (1,3)은 두 점사이 거리구하는 공식을 이용하면 10
 *  2. 원점에서 좌표 (-2,2)은 두 점사이 거리구하는 공식을 이용하면 8
 *
 *  따라서 더 가까운 좌표는 (-2,2)가 되며, K(1)개만큼 리턴하라고 하였으니
 *  정답은 [[-2,2]]가 된다.
 *
 */
public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        KClosestPointsToOrigin  a = new KClosestPointsToOrigin();

        int[][] points = {{1, 3}, {-2, 2}, {4, 1}, {1, 1}};
        int k = 3;

        int[][] result = solution(points, k);
        for (int[] res : result) {
            for (int r : res) {
                System.out.println("r : " + r);
            }
        }
    }

    public static int[][] solution(int[][] points, int k) {
        int result[][] = new int[k][2];


        /**
         * PriorityQueue는 기본적으로 오름차순임.
         * 따라서 규칙을 변칙적으로 설정하지 않는 한 오름차순을 기반으로 데이터가 형성됨
         */

        Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            // 생성자 선언시 규칙에 compare를 활용하는 경우 두개이상의 요소가 저장되어야 해당 메소드가 활용된다.
            // 하나만 입력될 시 비교할 대상자가 없고 우선순위를 정할필요도 없어서 실행되지 않는듯??
            @Override
            public int compare(int[] a, int[] b) {

                int tmpA = a[0] * a[0] + a[1] * a[1]; // 현재 들어온 요소 거리 계산
                int tmpB = b[0] * b[0] + b[1] * b[1]; // 사전에 저장된 요소 거리 계산

                return tmpA - tmpB;
            }
        });

        for (int[] p : points) {
            pq.offer(p);
        }

        int index = 0;
        while (index < k) {
            result[index] = pq.poll();
            index++;
        }
        return result;
    }

}

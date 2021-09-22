package basic;

import java.util.Arrays;

/**
 * @문제 : 미팅룸
 * @설명 : 미팅 시간 배열이 주어집니다. intervals[i] = [start, end]
 * intervals 배열을 이용하여 사람들이 모든 회의에 참석할 수 있는지 boolean으로 리턴하세요
 *
 * @input1 : intervals = [ [5, 10], [16,20], [0,30] ]
 * @ounput1: false
 * @분석:
 *  1. 우선 회의실은 0분부터 30분까지 할 수 있다.
 *  2. 회의시작시간 순서로 정렬한다.
 *  3. 전 미팅의 종료시간과 현재 미팅의 시작시간을 비교하여 전 미팅의 시간이 더 크다면 회의실이 하나 더 필요하므로
 *      그 순간 반복문을 종료하고 false 리턴하고, 끝까지 잘 수행이 된다면 true 리턴
 *
 *
 * @input2 : intervals = [ [6, 10], [1, 3]]
 * @ounput2: true
 *
 * @시간복잡도 : N -> intervals
 *  1. intervals Sorting 하는데에 N이라는 시간이 소요
 *  2. Sorting된 Intervals를 통해 for문을 실행
 *  3. 따라서 시간복잡도는 O(NlogN)
 *
 * @공간복잡도 : N -> intervals
 *  1. 추가적인 공간을 사용한 것은 없음
 *  2. 따라서 공간복잡도는 O(1)
 */
public class MettingRoom {

    public static void main(String[] args) {
        MettingRoom a = new MettingRoom();

//        int[][] intervals = {{5, 10}, {16, 20}, {0, 30}};
        int[][] intervals = {{7, 10}, {2, 4}};

        System.out.println(a.slove(intervals));

    }

    public boolean slove(int[][] intervals) {

        if (intervals == null || intervals.length == 0)
            return true;

        // 1. sorting
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);  // 오름차순
        // 2. for
        int end = intervals[0][1];
        for (int i=1; i< intervals.length; i++) {
            if (intervals[i][0] < end) {
                return false;
            }
            end = intervals[i][1];
        }
        return true;
    }

}

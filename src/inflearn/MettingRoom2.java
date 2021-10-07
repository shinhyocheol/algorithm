package inflearn;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @문제 : 미팅룸
 * @설명 : 미팅 시간 배열이 주어집니다. intervals[i] = [start, end]
 * intervals 배열을 이용하여 사람들이 회의에 참석하려면 몇 개의 회의실이 필요한지 리턴하세요.
 *
 * @input1 : intervals = [ [5, 10], [16,20], [0,30] ]
 * @ounput1: false
 * @분석:
 *  1. 우선 회의실은 0분부터 30분까지 할 수 있다.
 *  2. 회의시작시간 순서로 정렬한다.
 *  3. 전 미팅의 종료시간과 현재 미팅의 시작시간을 비교하여 전 미팅의 시간이 더 크다면 회의실이 더 필요한 경우가 된다.
 *
 * @문제분석
 *  1. 아이디어
 *      우선순위 큐를 이용해서 회의시간이 제일 긴것을 관리한다.
 *      앞.end 뒷.start 시간을 비교
 *      회의실 추가가 필요없는 것은 하나로 합치고, 추가가 필요한 것은 큐에 넣는다.
 *
 * @시간복잡도 : N -> intervals
 *  1. intervals Sorting 하는데에 N이라는 시간이 소요
 *  2. Sorting된 Intervals를 통해 for문을 실행
 *  3. 따라서 시간복잡도는 O(NlogN)
 *
 * @공간복잡도 : N -> intervals
 *  1. 추가적인 공간 : Queue
 *  2. Queue에 배열의 개수만큼 저장이 됨.
 *  3. 따라서 공간복잡도는 O(N)
 */
public class MettingRoom2 {

    public static void main(String[] args) {

        MettingRoom2 a = new MettingRoom2();

//        int[][] intervals = {{5, 10}, {16, 20}, {0, 30}};
         int[][] intervals = {{7, 10}, {2, 4}};

        System.out.println("필요한 회의실 수 : " + a.slove(intervals));
    }

    public int slove(int[][] intervals) {
        // 1
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]); // 오름차순
        Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // 2. for pq
        for (int[] arr : intervals) {
            if (q.isEmpty()) q.offer(arr); // 0,30  5,10
            else {
                if (q.peek()[1] <= arr[0]) { // 10 vs 16
                    // 10 =< 16
                    // 이전시간의 회의 종료시간보다 현재 회의시간이 큰 경우이므로
                    // 이전 회의타임과 현재 회의타임은 하나의 회의실로 합칠 수 있다.
                    // 따라서 이전 회의타임에 할애된 회의실 사용정보를 꺼내고 현재 회의타임을 넣어준다.
                    q.poll();
                }
                q.offer(arr);
            }
        }
        return q.size();
    }

}

package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ## 문제 설명 :
 *      하드디스크는 한 번에 하나의 작업만 수행할 수 있습니다.
 *      디스크 컨트롤러를 구현하는 방법은 여러 가지가 있습니다.
 *      가장 일반적인 방법은 요청이 들어온 순서대로 처리하는 것입니다.
 *      예를들어
 *          - 0ms 시점에 3ms가 소요되는 A작업 요청
 *          - 1ms 시점에 9ms가 소요되는 B작업 요청
 *          - 2ms 시점에 6ms가 소요되는 C작업 요청
 *      와 같은 요청이 들어왔습니다.
 *
 *      한 번에 하나의 요청만을 수행할 수 있기 때문에 각각의 작업을 요청받은 순서대로 처리하면 다음과 같이 처리 됩니다.
 *          - A: 3ms 시점에 작업 완료 (요청에서 종료까지 : 3ms)
 *          - B: 1ms부터 대기하다가, 3ms 시점에 작업을 시작해서 12ms 시점에 작업 완료(요청에서 종료까지 : 11ms)
 *          - C: 2ms부터 대기하다가, 12ms 시점에 작업을 시작해서 18ms 시점에 작업 완료(요청에서 종료까지 : 16ms)
 *
 *      이 때 각 작업의 요청부터 종료까지 걸린 시간의 평균은 10ms(= (3 + 11 + 16) / 3)가 됩니다.
 *
 *      하지만 A → C → B 순서대로 처리하면
 *          - A: 3ms 시점에 작업 완료(요청에서 종료까지 : 3ms)
 *          - C: 2ms부터 대기하다가, 3ms 시점에 작업을 시작해서 9ms 시점에 작업 완료(요청에서 종료까지 : 7ms)
 *          - B: 1ms부터 대기하다가, 9ms 시점에 작업을 시작해서 18ms 시점에 작업 완료(요청에서 종료까지 : 17ms)
 *
 *      이렇게 A → C → B의 순서로 처리하면 각 작업의 요청부터 종료까지 걸린 시간의 평균은 9ms(= (3 + 7 + 17) / 3)가 됩니다.
 *
 *      각 작업에 대해 [작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 배열 jobs가 매개변수로 주어질 때,
 *      작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면 평균이 얼마가 되는지
 *      return 하도록 solution 함수를 작성해주세요. (단, 소수점 이하의 수는 버립니다)
 *
 * ## 제한 사항
 *      * jobs의 길이는 1 이상 500 이하입니다.
 *      * jobs의 각 행은 하나의 작업에 대한 [작업이 요청되는 시점, 작업의 소요시간] 입니다.
 *      * 각 작업에 대해 작업이 요청되는 시간은 0 이상 1,000 이하입니다.
 *      * 각 작업에 대해 작업의 소요시간은 1 이상 1,000 이하입니다.
 *      * 하드디스크가 작업을 수행하고 있지 않을 때에는 먼저 요청이 들어온 작업부터 처리합니다.
 *
 * ## 입출력 예
 *  input : jobs = [[0, 3], [1, 9], [2, 6]]
 *  output : result = 9
 *
 */
public class DiskController {

    public static void main(String[] args) {
        DiskController a = new DiskController();
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};

        int result = a.solution(jobs);

//        System.out.println("Result :" + result);
    }

    public int solution(int[][] jobs) {
        int result = 0;

        /**
         * 1. 앞순서가 완료될때까지 뒷순서는 작업을 시작할 수 없다(계산이 이루어지면 안된다)
         * 2. 들어온 순서가 아닌 각 작업이 완료되는데에 최소치 순서로 진행이 되어야 평균치를 낮출 수 있다.
         */
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> (a[1] - a[0]) - (b[1]) - b[0]);
        List<Integer> success = new ArrayList<>();
        for (int i=0; i<jobs.length; i++) {
            queue.offer(jobs[i]);
        }

        int cnt = 0;
        int cur = 0;


        while (!queue.isEmpty()) {
            int[] job = queue.poll();

            // 0 + (cur(0) - 0) : 0 < 3 + sum(0) - 0) : 3
            // 0 + (cur(1) - 0) : 1 < 3 + sum(0) - 0) : 3
            // 0 + (cur(2) - 0) : 2 < 3 + sum(0) - 0) : 3
            // 0 + (cur(3) - 0) : 3 < 3 + sum(0) - 0) : 3

            // 작업완료했으니 큐에서 제거하고, 다음순서
            // 2 + (cur(3) - 2) : 3 < 9 (8 + (sum(3) - 2))
            // 2 + (cur(4) - 2) : 4 < 9 (8 + (sum(3) - 2))
            // 2 + (cur(5) - 2) : 5 < 9 (8 + (sum(3) - 2))
            // 2 + (cur(6) - 2) : 6 < 9 (8 + (sum(3) - 2))
            // 2 + (cur(7) - 2) : 7 < 9 (8 + (sum(3) - 2))
            // 2 + (cur(8) - 2) : 8 < 9 (8 + (sum(3) - 2))
            // 2 + (cur(9) - 2) : 9 < 9 (8 + (sum(3) - 2))

            // 작업완료했으니 큐에서 제거하고, 다음순서로
            // 1 + (cur(9) - 1) : 9 < 18 (10 + (sum(9) - 1))
            // 1 + (cur(10) - 1) : 10 < 18 (10 + (sum(9) - 1))
            // 1 + (cur(11) - 1) : 11 < 18 (10 + (sum(9) - 1))
            // 1 + (cur(12) - 1) : 12 < 18 (10 + (sum(9) - 1))
            // 1 + (cur(13) - 1) : 13 < 18 (10 + (sum(9) - 1))
            // 1 + (cur(14) - 1) : 14 < 18 (10 + (sum(9) - 1))
            // 1 + (cur(15) - 1) : 15 < 18 (10 + (sum(9) - 1))
            // 1 + (cur(16) - 1) : 16 < 18 (10 + (sum(9) - 1))
            // 1 + (cur(17) - 1) : 17 < 18 (10 + (sum(9) - 1))
            // 1 + (cur(18) - 1) : 18 < 18 (10 + (sum(9) - 1))

            if ( (job[0] + (cnt - job[0])) < ((job[0] + job[1]) + (cur - job[0])) ) {
                cnt++;
                queue.offer(job);
            } else {
                cur = cnt;
                success.add((cnt - job[0]));
            }
        }
        success.forEach((val) -> System.out.println("작업 소요 시간 : " + val));
        int sum = 0;
        for (int val : success) {
            sum += val;
        }
        System.out.println("총 소요시간 : " + sum);
        int avg = sum / success.size();

        return avg;
    }

}

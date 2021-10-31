package programmers;

import java.util.*;

public class FeatureDevelopment {

    public static void main(String[] args) {

        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        FeatureDevelopment a = new FeatureDevelopment();
        int[] result = a.solution(progresses, speeds);

        System.out.print("result : ");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }

    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> jobs = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        int success = 100;

        for (int i=0; i<progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            int workingTime = 0;

            while (progress < success) {
                progress += speed;
                workingTime++;
            }

            jobs.add(workingTime);
        }

        while (!jobs.isEmpty()) {

            int cnt = 1;
            int workingTime = jobs.poll();

            while (!jobs.isEmpty() && workingTime >= jobs.peek()) {
                jobs.poll();
                cnt++;
            }

            if (cnt > 0)
                result.add(cnt);
        }


        int[] answer = result
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();

        return answer;
    }
}

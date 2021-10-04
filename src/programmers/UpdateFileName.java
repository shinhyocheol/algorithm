package programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class UpdateFileName {

    public static void main(String[] args) {

        String[] before = {"A", "B", "C"};
        String[] after = {"B", "C", "A"};

        UpdateFileName a = new UpdateFileName();

        int result = a.solution(before, after);

        System.out.println("result : " + result);

    }

    public int solution(String[] before, String[] after) {
        int result = -1;
        int answer = 0;
        int pos = 0;
        int cnt = 0;
        Map<String, Integer> map = new HashMap<>();

        while (cnt < before.length) {
            String str = after[pos];
            for (int j=0; j<before.length; j++) {
                String a = after[pos];
                if (before[j].equals(a)) {
                    before[pos] = "temp";
                    answer++;

                    pos = j;
                } else {
                    before[pos] = a;
                    answer++;
                }
            }
        }

        return answer;
    }

}

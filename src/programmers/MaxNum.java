package programmers;

import java.util.Arrays;

public class MaxNum {
    public static void main(String[] args) {
        int[] numbers = {6, 10, 10};

        String answer = "";

        String[] result = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            result[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(result, (before, after) -> (after + before).compareTo(before + after));

        if (result[0].equals("0")) {
            answer = "0";
        }

        for (int i = 0; i<result.length; i++) {
            answer += result[i];
        }

        System.out.println(answer);
    }
}

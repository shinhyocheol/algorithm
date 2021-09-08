package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 배열 내 순서를 최소이동만으로 인접 원소간의 차이를 특정수"K" 이하인 경우로 맞추어 배열을 변경한다.
 * 예를 들어 {3, 7, 2, 8, 6, 4, 5, 1} 가 주어지고 K가 3일경우
 * 3 <-> 4, 2 <-> 5 두번의 이동을 통해 {4, 7, 5, 8, 6, 4, 2, 1} 로 바꾸면
 * 인접원소간의 차는 K(3) 이하로 맞추어진다.
 *
 */
public class NumberSwap {

    public static void main(String[] args) {
        int answer = 0;
        int k = 3;
        int[] numbers = {3, 7, 2, 8, 6, 4, 5, 1};
        List<Map<Integer, Integer>> differences = new ArrayList<>();

        for (int i = 1; i<numbers.length; i++) {
            int difference = 0;
            if (numbers[i-1] > numbers[i]) {
                difference = numbers[i-1] - numbers[i];
            } else {
                difference = numbers[i] - numbers[i-1];
            }
            if (difference > 30) {
                differences.add(new HashMap<>(difference, numbers[i-1]));
                differences.add(new HashMap<>(difference, numbers[i]));
            }
        }

    }

}

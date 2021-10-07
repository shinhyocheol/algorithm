package inflearn;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @문제설명 : 모든 요소를 포함하는 범위(lower, upper)와 정렬된 고유한 정수 배열 nums가 주어집니다.
 *          만약 x라는 number가 범위[lower, upper]가 존재하고 nums배열에 없다면
 *          누락된 값으로 간주합니다.
 *          누락된 모든 숫자를 정확히 포함하는 가장 작은 정렬된 범위를 리턴합니다.
 *          표현형식은 아래와 걑습니다.
 *
 *          [a, b]목록의 각 범위는 다음과 같이 출력되어야 합니다.
 *          if a!=b : "a->b"
 *          if a==b : "a"
 *
 * @input :
 *          int[] nums = {2, 3, 5, 50, 75};
 *          int lower = 0;
 *          int upper = 99;
 * @ouput : [0->1, 4, 6->49, 51->74, 76->99]
 *
 * @문제분석 :
 *      1. 0->1
 *          lower < nums[0]
 *      2. 3-5와 5-50
 *          nums[i] + 1 < nums[i+1]
 *      3. 75-99
 *          nums[nums.length-1] < upper
 *
 * @시간복잡도 : O(N)
 *  대상 : int[] nums
 *  이유 : nums 배열의 크기 n만큼 for문 실행
 *
 * @공간복잡도 : O(N)
 *  대상 : List<String> result = new ArrayList<String>();
 *  이유 : for문 실행
 */
public class MissingRanges {

    public static void main(String[] args) {

        MissingRanges a = new MissingRanges();

        int[] nums = {2, 3, 5, 50, 75};
        int lower = 0;
        int upper = 99;

        List<String> result = a.slove(nums, lower, upper);
        System.out.println("result : " + result);

    }

    public List<String> slove(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        // 1.
        if (lower < nums[0]) {
            result.add(makeRange(lower, nums[0] - 1)); // 0->1
        }

        // 2.
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i] + 1 < nums[i+1] && nums[i] != nums[i+1]) {
                // 6->49
                result.add(makeRange(nums[i]+1, nums[i+1] - 1)); // 0->1
            }
        }
        // 3.
        if (upper > nums[nums.length-1]) {
            result.add(makeRange(nums[nums.length-1], upper)); // 76->99
        }

        return result;
    }

    private String makeRange(int lower, int high) {
        return lower == high ? String.valueOf(lower) : (lower + "->" + high);
    }

}

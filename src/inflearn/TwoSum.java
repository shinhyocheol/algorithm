package inflearn;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @문제설명 : 정수의 배열 nums와 정수 target이 주어집니다. 배열 nums에서 두 숫자의 값을 더하여 target이 주어집니다.
 *      배열 nums에서 두 숫자의 값을 더하여 target 값과 동일할 경우 두 숫자의 인덱스를 리턴합니다. 각 입력에 정확히 하나의 솔루션이 있다고 가정하며,
 *      동일한 요소를 두 번 사용할 수 없습니다.
 * @문제조건 : 시간복잡도 O(n)으로 수행하세요.
 * @풀이설명 :
 * @문제분석 :
 *       1. for문을 돌려서 target과 비교
 *       2. 16-2=11
 *       3. Map(숫자, 방번호)
 *       4. 방번호만 리턴한다 int[]
 *
 *
 * @시간복잡도 : O(N) -> 문제 조건자체가 O(N)으로 수행해야 하는 문제임
 *  대상 : int[] nums
 *  이유 : for문 실행 0 -> len까지
 *
 * @공간복잡도 : O(n)
 *  대상 : Map<Integer, Integer> map = new HashMap<>();
 *  이유 : for 문을 실행하면서 map.put
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum a = new TwoSum();
        int[] nums = {2, 6, 11, 14};
        int target = 16;

        int[] result = a.slove_2(nums, target);

        System.out.print("result : ");
        for (int i=0; i<result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();

    }

    // O(N^2)
    public int[] slove(int[] nums, int target) {
        int len = nums.length;

        for (int i=0; i<len; i++) {
            for (int j=i+1; j<len; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[] {i+1, j+1};
                }
            }
        }

        return new int[] {0, 0};
    }

    // O(N)
    public int[] slove_2(int[] nums, int target) {
        // 1.ds
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        // 2.for
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int val = map.get(nums[i]); // 14
                result[0] = val + 1;
                result[1] = i + 1;
            } else {
                map.put(target-nums[i], i);
            }
        }
        return result;
    }

}

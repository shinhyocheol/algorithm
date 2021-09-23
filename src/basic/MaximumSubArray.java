package basic;

/**
 *
 * @문제설명 : 정수 배열 nums가 주어지면 합계가 가장 큰 연속 하위배열(최소한 하나의 숫자 포함)을 찾아서 합계를 리턴합니다.
 * @문제조건 : 시간복잡도 O(n)으로 구현하세요.
 * @풀이설명 : 현재의 구간과 현재의 구간 + 이전 구간의 합을 비교해 더 큰것을 선택하고, 선택한 것을 가지고 다음 구간으로 넘어가 같은 계산을 반복한다.
 * @문제분석 :
 *
 *
 * @시간복잡도 : O(N)
 *  대상 : int[] nums
 *  이유 : for문 한번 실행
 *
 * @공간복잡도 : O(1)
 *  대상 : curMax, allMax
 *  이유 : 다른 저장공간을 사용안함
 */
public class MaximumSubArray {

    public static void main(String[] args) {
        MaximumSubArray a = new MaximumSubArray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int result = a.slove(nums);
        System.out.println("========================================");
        System.out.println("result : " + result);
        System.out.println("========================================");
    }

    public int slove(int[] nums) {
        int[] result = new int[nums.length];

        // 1.
        int curMax = nums[0];
        int allMax = nums[0];

        // 2.
        for (int i=1; i<nums.length; i++) {
            curMax = Math.max(nums[i], nums[i] + curMax);
            allMax = Math.max(allMax, curMax);
            System.out.println("curMax : " + curMax + ", allMax : " + allMax);
            System.out.println();
        }

        return allMax;
    }

}

package inflearn;

/**
 *
 * @문제설명 : elevation map(양의 정수)은 아래그림에서 검은 네모모양이며 너비는 1이다.
 *          비가 내린 후 가둘 수 있는 물의 양을 계산하세요.
 * @input : height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
 * @ouput : result = 6
 *
 * @문제분석 : 물이 차는 영역 결정하는 부분
 *          물이 찬다는 것은 왼쪽벽과 오른쪽 벽의 값의 차이가 존재해야된다.
 *          밑에 높이만큼 빼야된다.
 *
 *          왼쪽벽 1 오른쪽벽 2일때 = 1
 *          왼쪽벽 2 오른쪽벽 3일때 = 2
 *
 *
 * @시간복잡도 : O(N)
 *  대상 : int[] height
 *  이유 : height 배열의 크기 n만큼 for문 실행
 *
 * @공간복잡도 : O(N)
 *  대상 : int[] left, int[] right
 *  이유 : for문 실행
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater a = new TrappingRainWater();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = a.slove(height);

        System.out.println("result :" + result);
    }


    public int slove(int[] height) {
        int result = 0;
        if (height == null || height.length == 0) {
            return result;
        }

        int len = height.length;

        // 1. leftMax[]
        int[] left = new int[len];

        // 2. rightMax[]
        int[] right = new int[len];

        int max = height[0];

        left[0] = height[0];
        for(int i=1; i<len; i++) {
            if (height[i] > max) {
                max = height[i];
            }
            left[i] = max;
        }

        max = height[len-1];
        right[len - 1] = height[len-1];
        for(int i=len-2; i>-0; i--) {
            if (height[i] > max) {
                max = height[i];
            }
            right[i] = max;
        }

        // 3. min - height
        for (int i=0; i<len; i++) {
            result += Math.min(left[i], right[i]) - height[i];
        }

        return result;
    }

}

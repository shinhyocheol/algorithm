package inflearn;

import java.util.Stack;

/**
 *
 * @문제설명 : 일일온도를 나타내는 int 배열 temperatures {73, 74, 75, 71, 69, 72, 76, 73} 가 주어집니다.
 *          더 따뜻한 날씨의 날을 얻기위해 해당날짜 이후에 기다려야하는 날짜의 수를 배열로 리턴하세요.
 *
 * @문제조건 : 더 따뜻한 날이 오지 않는다면 0을 리턴할 것
 * @문제분석 :
 *      1. 73에서는 1일 후 74
 *      2. 74에서는 1일 후 75
 *      3. 75에서는 4일 후 76
 *      4. 71에서는 2일 후 72
 *      5. 69에서는 1일 후 72
 *      6. 72에서는 1일 후 76
 *      7. 76에서는 더 따뜻해 질 날이 오지 않으므로 0
 *      8. 73에서는 더 따뜻해 질 날이 오지 않으므로 0
 *
 * @시간복잡도 : O(N)
 *  대상 : int[] temperatures
 *  이유 : for문 실행 0 -> len까지, while문에서는 스택에 있는 값과 바로 찾을 수도 있습니다. 최악의 경우는 인덱스 끝까지 경우도 발생하지만 이 경우는 O(n+n)의 값 그래서 결론은 O(n) 입니다.
 *
 * @공간복잡도 : O(n)
 *  대상 : int[] result = new int[len]
 *  이유 : for문 실행
 */
public class DailyTemperature {

    public static void main(String[] args) {

        DailyTemperature a = new DailyTemperature();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

        int[] result = a.slove(temperatures);

        System.out.println();
        for (int i=0; i<result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    public int[] slove(int[] temperatures) {

        int len = temperatures.length;
        int[] result = new int[len];
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<len; i++) {

            // result에 순서대로 저장되는 것이 아니라 각 순서를 stack 저장해 기억해두고, 조건에 맞는동안 저장된 순서들을 꺼내와
            // 그 순서에 해당되는 일자에 답을 구하여 result[순서]에 저장한다.
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                result[index] = i - index;
            }

            stack.push(i);
        }

        return result;
    }

}

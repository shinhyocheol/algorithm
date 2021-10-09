package inflearn;

import java.util.Stack;

/**
 *
 * @문제설명 :
 *
 * @input : ["5", "-2", "4", "C", "D", "9", "+", "+"]
 * @ouput : 27
 *      1. The sum is : 5
 *      2. -2 points. The sum is : 3
 *      3. 4 points. The sum is : 7
 *      C. 3번 데이터 삭제. The sum is : 3
 *      4. 2번의 -2 값 더블 -4 를 얻는다. -4 + 3 = -1, The sum is : -1
 *      5. 9 Points. The sum is : 8
 *      6. -4 + 9 = 5 points. The sum is : 13
 *      7. 9 + 5 = 14 points. The sum is : 27
 *
 * @문제분석 :
 *
 * @시간복잡도 :
 *  대상 :
 *  이유 :
 *
 * @공간복잡도 :
 *  대상 :
 *  이유 :
 *
 */
public class BaseballGame {

    public static void main(String[] args) {

        String[] strs = {"5", "-2", "4", "C", "D", "9", "+", "+"};

        BaseballGame a = new BaseballGame();
        int res = a.solve(strs);

        System.out.println("result : " + res);

    }

    public int solve(String[] strs) {
        int result = 0;

        // 1. ds
        Stack<Integer> stack = new Stack<>();

        // 2. for while
        for (String str : strs) {
            switch (str) {
                case "C" :
                    stack.pop();
                    break;
                case "D" :
                    stack.push(stack.peek() * 2);
                    break;
                case "+" :

                    int x = stack.pop();
                    int y = stack.pop();

                    // 꺼냈던 순서 반대로 다시 스택에 저장
                    // 그래야 기존 순서와 바뀌지 않음.
                    stack.push(y);
                    stack.push(x);

                    stack.push(x + y);

                    break;
                default:
                    stack.push(Integer.valueOf(str));
                    break;
            }
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }


}

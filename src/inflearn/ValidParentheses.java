package inflearn;

import java.util.Stack;

/**
 *
 * @문제설명 : String s 가 주어집니다. s는 '(', ')', '{', '}', '[', ']' 로 이루어집니다.
 *  유효한 괄호인지 체크하여 boolean 값으로 리턴하세요.
 *  입력 문자열은 다음과 같은 경우에 유효합니다.
 *  1. 열린 괄호는 동일한 유형의 괄호로 닫아야 합니다.
 *  2. 열린 괄호는 올바른 순서로 닫아야 합니다.
 *
 * @input : 1. "()", 2. "()[]{}", 3. "([)]", 4. "{[]}"
 * @ouput : 1. true, 2. true, 3. false, 4. true
 *
 * @문제분석 :
 *      1. Stack을 사용해 문제를 푼다.
 *      2. 여는 괄호가 괄호면 스택에 우선 값을 저장
 *      3. 닫는 괄호가 나오면 스택에서 자신과 동일한 유형의 여는 괄호가 존재하는지 확인
 *      4. 존재한다면 여는 괄호를 스택에서 삭제처리
 *      5. 반복작업을 통해 스택은 동일한 유형끼리 존재하는 괄호로만 채워진 문자열인 경우 빈 스택으로 존재
 *      6. 빈 스택이라면 유효한 괄호 문자열이고 그렇지 않다면 유효하지 않은 괄호 문자열이다.
 *
 * @시간복잡도 : O(N)
 *  대상 : String s
 *  이유 : for문 한번 실행
 *
 * @공간복잡도 : O(N)
 *  대상 : Stack<Character> stack = new Stack<>();
 *  이유 : 스택에 s의 길이만큼 push, pop
 *
 */
public class ValidParentheses {

    public static void main(String[] args) {

        String s = "([]{})";

        ValidParentheses a = new ValidParentheses();
        boolean isValid = a.solve(s);
        System.out.println("is valid : " + isValid);
    }

    public boolean solve(String s) {

        boolean result = false;

        // 1. ds
        Stack<Character> stack = new Stack<>();

        // 2. for while
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')' && !stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else if (s.charAt(i) == ']' && !stack.empty() && stack.peek() == '[') {
                stack.pop();
            } else if (s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{') {
                stack.pop();
            }

        }

        if (stack.isEmpty())
            result = true;

        return  result;
    }

}

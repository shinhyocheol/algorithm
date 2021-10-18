package inflearn;

import java.util.*;

/**
 *
 * @문제설명 : 문자열을 받으면 하나의 요소를 삭제하여 쌍으로 존재하는 경우를 모두 리턴하세요.
 *
 * @input : "(a)())()"
 *
 * @ouput : [(a())(), (a)()()]
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
 */
public class RemoveInvalidParentheses {

    public static void main(String[] args) {

        RemoveInvalidParentheses a = new RemoveInvalidParentheses();
        String s = "(a)())()";

        List<String> result = a.solve(s);

        System.out.println(result);
    }

    public List<String> solve(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) {
            return result;
        }
        // 탐색할 곳을 저장할 큐
        Queue<String> queue = new LinkedList<>();
        // 방문한 문자를 저장할 셋
        Set<String> visited = new HashSet<>();

        // 첫번째 탐색 시작용
        queue.offer(s);
        visited.add(s);
        boolean flag = false;

        // 탐색시작
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                String str = queue.poll();
                if (isValid(str)) {
                    result.add(str);
                    flag = true;
                }
                if (flag)
                    continue;

                // 자릿수 별로 탐색을 시작
                // 0-7 -> 0-6
                for (int j=0; j<str.length(); j++) {

                    // 1. 문자는 탐색대상에 포함되지 않는다
                    if ((str.charAt(j) != ')' && str.charAt(j) != '('))
                        continue;

                    // 2.
                    String newStr = str.substring(0, j) + str.substring(j+1);
                    if (!visited.contains(newStr)) {
                        queue.offer(newStr);
                        visited.add(newStr);
                    }
                }
            }
        }
        return result;
    }

    // 브레이스 체크(쌍이 되는지)
    public boolean isValid(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')'){
                count--;
                if (count < 0) return false;
            }
        }

        // 카운트가 0 이면 쌍이 존재하는 것
        // 카운트가 1 이면 짝짝이임
        return count == 0;
    }

}

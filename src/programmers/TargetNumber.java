package programmers;

import java.util.Stack;

public class TargetNumber {

    int answer;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    public void dfs(int[] numbers, int target, int sum, int i) {

        if(i == numbers.length) {
            if(sum == target) {
                answer++;
            }
            return;
        }
        System.out.println("idx : " + i + ", sum : " + sum);

        // idx 0 : 0 sum : 0
        // idx 1 : +1 sum : 1
        // idx 2 : +1 sum : 2
        // idx 3 : +1 sum : 3
        // idx 4 : +1 sum : 4
        // idx 5 : +1 sum : 5

        // idx 5 -> i == numbers.lengh
        // 조건에 부합하므로 탐색이 끝나고 누적된 sum과  target을 비교한다.
        // 타겟넘버와 일치하지 않으므로 해당 경우는 집계에 포함되지 않는다.
        dfs(numbers, target, sum + numbers[i], i+1);

        // idx가 마지막 +1의 마지막 방까지 탐색이 완료되면 위 재귀함수는 더이상 실행되지 않는다.
        // 따라서 이 함수가 실행이된다.

        // idx 4 : -1 sum : 4
        // idx 5 : -1 sum : 3
        // idx 5 -> i == numbers.lengh
        // 조건에 부합하므로 탐색이 끝나고 누적된 sum과 target을 비교한다.
        // 타겟넘버와 일치하므로 해당 경우는 집계에 포함된다.
        dfs(numbers, target, sum - numbers[i], i+1);
    }


    // 실행
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        TargetNumber targetNumber = new TargetNumber();
        int result = targetNumber.solution(numbers, target);

        System.out.println("TargetNumber Result : " + result);
    }

}

package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class H_Index {

    public static void main(String[] args) {
        H_Index a = new H_Index();
        int[] citations = {3, 0, 6, 1, 5};
        int result = a.solution(citations);

        System.out.println("result : " + result);
    }

    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for(int i=0; i<citations.length; i++){

            // n편 중 h번 이상 인용된 논문이 h편 이상 일때 h의 최댓값을 찾아야 함.
            // i일때 가장 큰 h값(논문 편수)
            int h = citations.length-i;
            // 5, 4, 3, 2, 1

            // 논문 인용횟수가 h 이상인지 확인
            if(citations[i] >= h){
                // 0, 1, 3, 5, 6
                // 0 >= 5   // h-index X
                // 1 >= 4   // h-index X
                // 3 >= 3   // h-index O    // 이 구간부터 h-index의 조건 성립됨. 동시에 h-index는 점점 작아지므로 이게 h-index의 최대값이 된다. 이후는 안봐도 됨.
                // 4 >= 2   // h-index O
                // 5 >= 1   // h-index O
                answer = h;
                break;
            }
        }

        return answer;

    }

}

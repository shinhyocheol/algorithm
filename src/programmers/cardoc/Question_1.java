package programmers.cardoc;

import java.util.Arrays;

public class Question_1 {

    public static void main(String[] args) {

        Question_1 a = new Question_1();
        int[] arrA = {7, 8, 10};
        int[] arrB = {10, 7, 8};

        System.out.println("result : " + a.solution(arrA, arrB));
    }

    public boolean solution(int[] arrA, int[] arrB) {
        if (arrA == null || arrA.length == 0 || arrB == null || arrB.length == 0 || arrA.length != arrB.length)
            return false;

        // 시작부터 같은지 확인
        if (Arrays.equals(arrA, arrB))
            return true;

        // A 배열길이
        int len = arrA.length;

        // 배열 길이 - 1 만큼 회전 반복
        for (int i=1; i<len; i++) {
            // 배열의 첫번째 항상 고정으로 가져오기
            int tmp = arrA[0];

            // 배열 길이 -1 만큼 회전시작
            for (int j=1; j<len; j++) {
                // 이전요소 저장
                int a = tmp;

                // tmp에 현재 값 저장
                tmp = arrA[j];

                // 이전 요소를 현재 순서에 넣어주면서 이동한다.
                // 만약 현재 순서가 마지막이라면
                // 현재 요소를 첫번째로 넣어준다.
                arrA[j] = a;
                if (j == (len - 1))
                    arrA[0] = tmp;
            }
            if (Arrays.equals(arrA, arrB))
                return true;
        }

        return false;

    }
}

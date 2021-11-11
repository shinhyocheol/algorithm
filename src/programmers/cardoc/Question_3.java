package programmers.cardoc;

import java.math.BigDecimal;

/**
 * 코딩테스트 문제였는데 접근을 너무 단순하게 해서 아쉬웠던 문제....
 * 차라리 검색이라 똑바로 했다면 효율성 100점 나왔을꺼다.
 *
 * 숫자 이어붙이기는 규칙이 있다.
 *  1. 자리수가 1개인 수를 모두 썼을때는 길이가 9인 문자열이 생성된다.
 *  2. 자리수가 2개인 수를 모두 썼을때는 길이가 90*2 = 180인 문자열이 생성된다.
 *  3. 자리수가 3개인 수를 모두 썼을때는 길이가 900*3 = 2700인 문자열이 생성된다.
 *
 *
 */
public class Question_3 {


    public static void main(String[] args) {

        Question_3 a = new Question_3();
        int n = 99;
        int result = a.solution(n);

        System.out.println("result : " + result);

    }

    public int solution(int n) {
        int result = 0;
        System.out.println("=============== Algorithm ===============");
        int base = 0;
        int acc = 0;
        int idx = 0;

        for (; n>acc && idx<8; idx++) {
            base = acc;
            acc += (idx+1) * 9 * (int)Math.pow(10, idx);
            System.out.println(base + " ~ " + acc);
        }
        if (n>acc && idx==8) {
            base = acc;
            idx = 9;
        }

        // n번째에 들어가는 수 구하기
        // if n = 9 : 8 / 1 = 8 -> 0부터 시작
        System.out.println("n : " + n + ", base : " + base + ", idx : " + idx + ", pow() : " + (int)Math.pow(10, idx-1));
        System.out.println("tmp : " + (n-(base+1)) / idx);
        System.out.println("tmp2 : " + (int)Math.pow(10, idx-1));

        int tmp = (n-(base+1)) / idx;
        int tmp2 = (int)Math.pow(10, idx-1);
        System.out.println("tmp / tmp2 : " + tmp/tmp2);

        int num = ((n-(base+1)) / idx) + (int)Math.pow(10, idx-1);

        // n에서 base+1을 뺀 수에 i를 나눈 나머지를 구해서 n번째로 들어간 수의 몇번째 요소를 가져올지 구한다.
        int digit = (n-(base+1)) % idx;
        System.out.println("digit : " + digit);

        // 출력
        System.out.println("num : " + num);
        System.out.println("result : " + String.valueOf(num).charAt(digit));
        System.out.println("=========================================");

        System.out.println();

        System.out.println("============== String Add ==============");
        StringBuilder sb = new StringBuilder();
        int num2 = 0;
        for (int i=1; i<=n; i++) {
            sb.append(i);
            num2 = i;
            if (sb.toString().length() >= n)
                break;
        }
        System.out.println("num : " + num2);
        System.out.println("result : " + String.valueOf(sb.toString().charAt(n-1)));
        System.out.println("========================================");


        return result;
    }
}

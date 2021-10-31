package programmers.cardoc;

import java.math.BigDecimal;

public class Question_3 {

    public static void main(String[] args) {

        Question_3 a = new Question_3();
        int n = 100;
        System.out.println(a.solution(n));

    }

    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=n; i++) {
            sb.append(i);
            if (sb.toString().length() >= n)
                break;
        }
        String res = String.valueOf(sb.toString().charAt(n-1));

        return Integer.parseInt(res);
    }
}

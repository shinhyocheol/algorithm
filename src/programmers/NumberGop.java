package programmers;

import java.math.BigDecimal;

public class NumberGop {


    public static void main(String[] args) {
        int n = 22;
        int k = 9;

        NumberGop a = new NumberGop();
        int result = a.solution(n, k);
        System.out.println(result);
    }


    public int solution(int n , int k) {
        int result = 1;

        if (n % k == 0)
            return result;

        StringBuilder sb = new StringBuilder();
        sb.append(n);

        BigDecimal opponent = new BigDecimal(k);
        for (int i=1; i<k; i++) {
            result++;
            sb.append(n);
            BigDecimal big = new BigDecimal(sb.toString());
            if (Integer.parseInt(String.valueOf(big.remainder(opponent))) == 0)
                return result;
        }
        return -1;
    }
}

package programmers.cardoc;

import java.math.BigDecimal;

public class Question_2 {

    public static void main(String[] args) {

        Question_2 a = new Question_2();
        long n = 1;

        long[] res = a.solution(n);
        for (long val : res) {
            System.out.print(val + " ");
        }
        System.out.println();

    }

    public long[] solution(long n) {

        if (n < 7)
            return new long[]{1, 2};

        BigDecimal holiday = new BigDecimal(n);
        BigDecimal oneWeek = new BigDecimal(7);

        long div = holiday.divide(oneWeek, BigDecimal.ROUND_DOWN).longValue();
        long remainder = holiday.remainder(oneWeek).longValue();
        if (remainder == 0) {
            return new long[]{(2 * div), (2 * div)};
        }
        else {
            if (remainder > 1)
                return new long[]{(2 * div), ((2 * div) + 2)};
            else
                return new long[]{(2 * div), ((2 * div) + 1)};
        }

    }

}

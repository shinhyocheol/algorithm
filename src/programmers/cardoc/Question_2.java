package programmers.cardoc;

import java.math.BigDecimal;

public class Question_2 {

    public static void main(String[] args) {
        /**
         * 시간복잡도 : O(1) -> 반목분이 없고 필요한 값을 구한 후 바로 그에 맞는 결과를 리턴한다.
         */
        Question_2 a = new Question_2();
        long n = 1;

        long[] res = a.solution(n);
        for (long val : res) {
            System.out.print(val + " ");
        }
        System.out.println();

    }

    public long[] solution(long n) {
        if (n < 7) {
            if (n == 0) return new long[]{0, 0};
            else if(n == 1) return new long[]{0, 1};
            else return new long[]{1, 2};
        }

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

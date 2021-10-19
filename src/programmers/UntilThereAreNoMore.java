package programmers;

import java.math.BigDecimal;

public class UntilThereAreNoMore {


    public static void main(String[] args) {
        int n = 22;
        int k = 9;

        UntilThereAreNoMore a = new UntilThereAreNoMore();
        int result = a.solution(n, k);
        System.out.println(result);
    }


    public int solution(int n , int k) {

        if (n % k == 0)
            return 1;

        // 큰 수를 담아야한다. 근데 double도 한계가 존재하고, 나머지를 구할때 정확하지 않는 경우가 존재하므로 BigDecimal 사용
        BigDecimal kBig = new BigDecimal(k);
        // 반복문을 돌때마다 n = n + n(연산이 아닌 단순 문자 붙히기)가 반복되는데 String보단 StringBuilder가 메모리면에서 효율적이다.
        StringBuilder sb = new StringBuilder();
        sb.append(n);

        int result = 1; // 결과
        for (int i=0; i<k; i++) {

            sb.append(n);
            result++;

            // BigDecimal 타입으로 변환
            BigDecimal big = new BigDecimal(sb.toString());

            // BigDecimal에서 remainder 메소드는 나머지값을 구하는 기능을 담당한다.
            // 나머지 값 구하고 int형으로 변환해서 나머지가 0인지 확인
            // 끝날때까지 나머지가 계속 존재한다면 n은 아무리 붙혀도 k로 나눈 나머지가 계속 남는다.
            if (Integer.parseInt(String.valueOf(big.remainder(kBig))) == 0)
                return result;
        }
        // 반복문이 끝날때까지 나머지가 존재했으므로 -1 리턴
        return -1;
    }
}

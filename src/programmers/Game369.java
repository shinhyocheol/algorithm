package programmers;

public class Game369 {

    public static void main(String[] args) {
        Game369 a = new Game369();
        int param = 334;
        int result = a.solution(param);
        System.out.println("result : " + result);
    }

    public int solution(int param) {
        int result = 0;
        // N(param) 이전까지 집계
        for (int i=0; i<param; i++) {
            // 현재 수를 문자열로 변환
            String str = String.valueOf(i);
            // 문자열 길이만큼 반복
            for (int j=0; j<str.length(); j++) {
                // 해당 순번의 문자를 다시 숫자로 변환하여 3,6,9 확인
                int n = Integer.parseInt(String.valueOf(str.charAt(j)));
                if ( n % 3 == 0 && n > 0) {
                    result++;
                }
            }
        }
        return result;
    }
}

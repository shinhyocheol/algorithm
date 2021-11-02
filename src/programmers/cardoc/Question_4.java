package programmers.cardoc;

public class Question_4 {

    public static void main(String[] args) {
        /**
         *
         * 시간복잡도 : O(n*m) -> n : 1년 개월 수 * m : 해당월의 일수 만큼 반복문을 실행하여 달력을 세팅함
         */
        Question_4 a = new Question_4();
        int day = 6;
        int k = 1;

        int[] result = a.solution(day, k);
        for (int i=0; i<result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();

    }

    public int[] solution(int day, int k) {
        int[] result = new int[12];

        // 평일 true, 주말 false
        boolean[] week = {true, true, true, true, true, false, false};

        // 월별 일수
        int[] monthList = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // 반복문을 통해 각 월의 시작요일을 업데이트
        int monthStart = day;

        // 달력부터 세팅
        for (int i=0; i<monthList.length; i++) {

            // 해당월의 길이 결정
            int[] month = new int[monthList[i]];

            for (int j=0; j<month.length; j++) {

                // 현재 monthStart의 해당되는 요일이 주말인지 아닌지 확인 후 1 or 0을 배치
                if (!week[monthStart])
                    month[j] = 1;
                else
                    month[j] = 0;

                // monthStart가 6이라면 더이상 다시 0으로 돌려놓고
                // 아니면 1씩 증가(monthStart는 최대 6까지 증가할 수 있음)
                if (monthStart == 6) monthStart = 0;
                else monthStart++;

            }

            // 해당 월 세팅이 완료될때마다 k번째(여기선 0부터 시작하므로 -1함) 일자의 값을 가져옴
            result[i] = month[k-1];
        }

        return result;

    }

}

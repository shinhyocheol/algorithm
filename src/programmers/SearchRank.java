package programmers;

import sun.lwawt.macosx.CSystemTray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ## 문제 : 카카오 블라인드 채용 - 코딩테스트 기출문제(순위검색)
 * ## 설명 : 지원자의 정보를 담은 info 배열과, 검색조건을 담은 query 배열이 주어진다.
 *          query 배열의 각 요소에 명시된 조건에 해당되는 지원자는 몇명인지를 구해서 리턴할것
 */
public class SearchRank {

    public static void main(String[] args) {

        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        SearchRank a = new SearchRank();
        int[] result = a.solution(info, query);

        System.out.println();
        for (int i=0; i< result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public int[] solution(String[] info, String[] query) {
        int[] result = new int[query.length];

        // 1. 응시자 정보 분리
        String[][] info_arr = new String[info.length][info[0].split(" ").length];
        for (int i=0; i<info.length; i++) {
            String[] arr = info[i].split(" ");
            for (int j=0; j<arr.length; j++) {
                info_arr[i][j] = arr[j];
            }
        }
        // 2. 검색 정보 분리
        String[][] query_arr = new String[query.length][query[0].split(" and | ").length];
        for (int i=0; i<query.length; i++) {
            String[] arr = query[i].split(" and | ");
            for (int j=0; j<arr.length; j++) {
                query_arr[i][j] = arr[j];
            }
        }

        // 검색문자 배열 반복시작
        for (int i=0; i<query_arr.length; i++) {
            // 검색 시작 문자
            String str = query_arr[i][0];

            // 검색 시작문자 받아서 응시자 정보 검색
            for (int j=0; j<info_arr.length; j++) {
                result[i] += search(info_arr, query_arr, str, i, j, 0);
            }
        }

        return result;
    }

    public int search(String[][] info_arr, String[][] query_arr, String str, int x, int y, int n) {

        // 응시자 정보의 배열 길이와 검색순번의 수가 같은순간 마지막 순번으로 간주하고 점수확인
        // 응시자의 점수가 검색하고자 하는 점수 이상이라면 카운트 하고 리턴
        if (n >= info_arr[y][n].length()) {

            int search_grade = Integer.parseInt(str);
            int info_grade = Integer.parseInt(info_arr[y][n]);

            if (search_grade <= info_grade)
                return 1;
            else
                return 0;
        }

        // 검색하고자 하는 정보가 "-" or 일치하는 문자 둘 중 어느것과도 일치하지 않는다면 더이상 진행 X
        if (!str.equals("-") && !str.equals(info_arr[y][n]))
            return 0;

        // 검색하려는 문자 다음조건으로 변경한 후 같은 방식으로 검색
        n++;
        str = query_arr[x][n];

        return Math.max(search(info_arr, query_arr, str, x, y, n), 0);
    }
}

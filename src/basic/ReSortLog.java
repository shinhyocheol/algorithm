package basic;

import java.util.Arrays;

/**
 *
 * @문제설명 : 배열로 logs가 주어집니다. 각 로그는 공백으로 구분 된 단어 문자열이며 첫 번째 단어는 식별자입니다.
 * @풀이설명 :
 *      input : logs = [
 *          "dig1 8 2 3 1",
 *          "let1 abc cat",
 *          "dig1 2 5",
 *          "let2 good dog book",
 *          "let3 abc zoo"
 *      ] // dig1, dig2와 같은 앞단어들이 idenfier가 된다.
 *      ouput : [
 *          "let1 abc cat",
 *          "let3 abc zoo",
 *          "let2 good dog book",
 *          "dig1 8 2 3 1",
 *          "dig1 2 5"
 *      ]
 * @문제분석 : idenfier와 나누기
 * @문제의 요지 : 소팅의 과정 잘 이해하고 있는가?? Java라면 Comparotor 메소드 기능 활용 능력의 정도를 보는 부분이 크다고 함.
 *
 * @시간복잡도 :
 *  대상 :
 *  이유 :
 *
 * @공간복잡도 :
 *  대상 :
 *  이유 :
 */
public class ReSortLog {

    public static void main(String[] args) {

        ReSortLog a = new ReSortLog();
        String[] logs = {
           "dig1 8 2 3 1",
           "let1 abc cat",
           "dig1 2 5",
           "let2 good dog book",
           "let3 abc zoo"};

        String[] res = a.slove(logs);

        System.out.println("========================================");
        for (int i=0; i<res.length; i++) {
            System.out.println("Result["+i+"] : " + res[i]);
        }
        System.out.println("========================================");

    }

    public String[] slove(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s2.split(" ", 2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            if (!isDigit1 && !isDigit2) {
                // 모두 문자인경우
                int comp = split1[1].compareTo(split2[1]); // 오름차순 마 -1
                if (comp == 0) return split1[0].compareTo(split2[0]);
                else  return comp;
            } else if(isDigit1 && isDigit2) {
                // 모두 숫자인경우
                return 0;
            } else if(isDigit1 && !isDigit2) {
                // 첫번째는 숫자, 두번째는 문자인경우
                return 1;
            } else {
                // 가장 먼저 분류해야함. 문자와 숫자를 갈라야 함.
                // 첫번째는 문자, 두번째는 숫자인경우
                return -1;
            }
        });
        return logs;
    }

}

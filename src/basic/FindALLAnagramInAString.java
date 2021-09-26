package basic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @문제설명 : 두개의 문자열이 주어집니다. String str, String p
 *      p의 문자열이 str의 문자열에 특정인덱스에서부터 모든 아나그램을 찾고, 그에 해당되는 인덱스를 리턴합니다.
 *
 * @제한사항 :
 *
 * @input : String str = "bacdgabcda", p = "abcd"
 * @ouput : [0, 5, 6]
 *      p= abcd를 s에 특정 인덱스에 대입했을때, 아나그램(순서는 상관없이 단어일치)되는 시점을 반환하면 됩니다.
 *
 * @문제분석 :
 *      1. abcd가 소스 문자열에서 나오는 부분을 검색한다.
 *      2. 나오는 시점부터 모든문자가 있는지 체크한다.
 *
 *
 * @시간복잡도 : O(N*M)
 *      대상 : String str
 *      이유 : str의 길이만큼 for문을 탐색하는데 탐색하는 요소를 p 길이만큼 for문을 안에서 실행한다.
 *
 * @공간복잡도 : O(1)
 *      대상 : int pArr = new int[26]
 *      이유 : 알파벳 26개에서 변동 없음
 */
public class FindALLAnagramInAString {

    public static void main(String[] args) {
        FindALLAnagramInAString a = new FindALLAnagramInAString();
        String str = "bacdgabcda";
        String p = "abcd";

        List<Integer> result = a.slove(str, p);
        System.out.println(result);
    }

    public List<Integer> slove(String str, String p) {
        // 1
        List<Integer> result = new ArrayList<>();
        if (str == null || str.length() == 0 || p == null || p.length() == 0)
            return result;

        int[] pArr = new int[26];           // [0, 0, 0, 0, 0, 0, 0......]
        for (int i=0; i<p.length(); i++) {
            pArr[p.charAt(i) - 'a']++;      // [1, 1, 1, 1, 0, 0, 0......]
        }

        for (int i=0; i<(str.length() - p.length() + 1); i ++)  {
            int[] sArr = new int[26];
            for (int j=0; j<p.length(); j++) {
                sArr[str.charAt(i+j) - 'a']++;
            }
            if (check(pArr, sArr)) {
                result.add(i);
            }
        }


        return result;
    }

    private boolean check(int[] pArr, int[] sArr) {

        for (int i=0; i<pArr.length; i++) {
            if (pArr[i] != sArr[i]) {
                return false;
            }
        }

        return true;
    }

}

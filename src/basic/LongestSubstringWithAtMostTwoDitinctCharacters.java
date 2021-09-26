package basic;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @문제설명 : 최대 2개의 고유 문자가 있는 가장 긴 부분 문자열
 *      String str이 주어집니다. 최대 두 개의 고유 문자를 포함하는 가장 긴 부분 문자열의 길이를 리턴합니다.
 *
 *
 * @제한사항 :
 *
 * @input : String str = "ecebba"
 * @ouput : 3 ("ece")
 *
 * @문제분석 :
 *      1. 첫번째 포인터(right)가 0번방부터 시작한다.
 *      2. 단어 2개까지 허용
 *      3. 단어가 3개가 되는 시점 중지
 *      4. max = 3 (right-left) 갱신한다.
 *      5. 이후부터 다시 카운트 한다.
 *
 * @시간복잡도 : O(N)
 *      대상 : String str
 *      이유 : str의 길이만큼 while 반복 실행
 *
 * @공간복잡도 : O(1)
 *      대상 : Map(Character, Integer> map = new HashMap<>()
 *      이유 : 키를 2개 이상 저장하지 않는다.
 */
public class LongestSubstringWithAtMostTwoDitinctCharacters {

    public static void main(String[] args) {

        LongestSubstringWithAtMostTwoDitinctCharacters a = new LongestSubstringWithAtMostTwoDitinctCharacters();

        String str = "ccaabbb";
        int result = a.slove(str);

        System.out.println("result : " + result);


    }

    public int slove(String str) {
        int result = 0;

        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int cnt = 0;
        while (right < str.length()) {
            char c = str.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1); // c = 2, a = 2, b = 1
            if (map.get(c) == 1) {
                cnt++;
            }
            right++;

            while (cnt > 2) {
                char c2 = str.charAt(left);
                map.put(c2, map.get(c2) - 1);
                if (map.get(c2) == 0) {
                    cnt--; // 2
                }
                left++;
            }
            System.out.println("right : " + right + ", left : " + left);
            result = Math.max(result, right - left);
        }

        return result;
    }

}

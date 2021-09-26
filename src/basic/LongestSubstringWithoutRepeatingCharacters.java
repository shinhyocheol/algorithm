package basic;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @문제설명 : 단어 중복이 없는 가장 긴 문자열
 *
 * ## 투포인터
 *  1. 같은 방향
 *      start 포인트가 시작, end 포인트를 저장했다가 이용
 *      문제 ) MoveZero
 *  2. 반대 방향
 *      while문에서 간격이 좁아지는 형태
 *      문제 ) Trapping rain Water
 *  3. 슬라이딩 윈도우(일정 크기 간격을 유지)
 *      문제 ) Longest Substring Without Repeating Characters
 *  4. Preix Sum
 *      문제 ) Subarray sum
 *  5. Cycle Finding
 *      문제 ) Linked List Cycle
 *
 * @제한사항 :
 *
 * @input : str = "abcabcd"
 * @ouput : result = 4 (abcd)
 *
 * @문제분석 :
 *      1. 첫번째 포인터(right)가 0번방부터 시작한다.
 *      2. 중복되는 문자 발생시 다시 시작한다.
 *      3. 중복 발생전 max = 3 (right-left) 갱신한다.
 *      4. 중복 발생 이후 부터 카운트 한다.
 *      ## 이 문제의 핵심은 중복되는 부분을 어떤식으로 저장할 것인지??
 *
 * @시간복잡도 : O(N)
 *      대상 : String str
 *      이유 : str의 길이만큼 반복문 실행
 *
 * @공간복잡도 : O(n)
 *      대상 : Map(Character, Integer> map = new HashMap();
 *      이유 : s의 단어를 한개씩 키로 저장
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters a = new LongestSubstringWithoutRepeatingCharacters();
        String str = "abcabcd";
        int result = a.slove(str);

        System.out.println("result : " + result);
    }

    public int slove(String str) {
        int result = 0;
        // 1. ds
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int cnt = 0;

        //2
        while (right < str.length()) {
            char c = str.charAt(right);
            // map에 해당 요소가 존재한다면 2가 저장 될 것이고, 그렇지 않다면 1이 저장된다.
            map.put(c, map.getOrDefault(c, 0) + 1);

            // 해당 요소가 2이상이라면 중복이므로 중복 카운트를 증가시키고, 아래서 사용된다.
            if (map.get(c) > 1) {
                cnt++;
            }
            right++;

            // 이전에 저장된 값들을 초기화
            while (cnt > 0) {
                char c2 = str.charAt(left); // p
                // 중복 카운트를 감소시킬때에는 무조건 감소시키는 것이 아니라
                // 중복이 되는 구간을 만나게 되는 시점에서 감소시켜야 함.
                // 중복이 되는 요소의 앞 요소들은 중복이 되는 요소가 아니다.
                // 따라서 여기서 바로 중복 카운트를 감소시키면 중복이 되는 요소를 확인하기전에
                // 중복카운트가 감소되어 해당 요소가 0으로 초기화되기전에 while문이 끝나버릴 수 있다.
                if (map.get(c2) > 1) {
                    cnt--;
                }

                // 앞 요소들의 카운트를 초기화 시킨다.
                // 1 -> 0
                // 2 -> 1, 1 -> 0
                map.put(c2, map.get(c2) - 1);
                left++;
            }
            result = Math.max(result, right - left);
        }
        return result;
    }

}

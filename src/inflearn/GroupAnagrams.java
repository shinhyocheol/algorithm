package inflearn;

import java.util.*;

/**
 *
 * @문제설명 : String 배열이 주어집니다. 주어진 String은 배열안에서 다른 String과 아나그램 관계입니다.
 *          String 순서 상관없이 같은 아나그램을 리턴하세요. 아나그램이란 문자의 단어를 재배열하여
 *          새로운 문자를 혈성하는 것. 즉, 같은 알파벳으로 구성된 단어끼리 묶어 출력하는 문제입니다.
 * @문제분석 :
 *      1. 각 String의 구성 알파벳들을 파악하여야한다.
 *      2. 순서와 상관 없다고 했으니 같은 순서로 정렬을 해서 같은 문자로 만들어볼 수 있다.
 *
 *
 * @시간복잡도 : O(NKlogK)
 *  대상 : String[] strs
 *  이유 : strs배열의 크기 n개, str의 length() K개, 소팅 실행 logK
 *
 * @공간복잡도 : O(NK)
 *  대상 : Map<String, List<String>> map = new HashMap<>();
 *  이유 : strs배열의 크기 n개, str의 length() K개
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams a = new GroupAnagrams();

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result = a.slove2(strs);
        for (List<String> list : result) {
            System.out.println("result : " + list);
        }
    }

    // 아스키 코드로 찾는 방법
    public List<List<String>> slove2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (String str : strs) {
            int[] count = new int[26]; // a-z
            for (int k=0; k<str.length(); k++) {
                count[str.charAt(k) - 'a']++;
            }
            String key = Arrays.toString(count);

            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        result.addAll(map.values());

        return result;
    }

    // 정렬로 찾는법
    public List<List<String>> slove(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        // 1.
        if (strs == null || strs.length == 0) {
            return result;
        }
        Map<String, List<String>> map = new HashMap<>();

        // 2. for
        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);

            String key = String.valueOf(charArr);

            // 방법 1
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }

            // 방법 2
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);

        }
        result.addAll(map.values());

        return result;
    }

}

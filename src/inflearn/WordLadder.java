package inflearn;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.*;

/**
 *
 * @문제설명 : 단어 사다리 문제입니다.
 *         1. 시작단어와 목표단어, 단어사전이 주어집니다.
 *         2. 시작단어는 목표단어와 같은 단어가 되기까지 임의로 한글자씩 바꿀 수 있습니다.
 *         3. 단, 임의로 한글자씩 바꿨을때 그 바꾼 단어는 사전에 포함된 단어이여야 합니다.
 *         4. 바꾼 단어가 사전에 포함되었을때 해당 단어를 인정합니다.
 *         5. 한글자씩 단어를 바꾸며 사전에 포함되어 변경이 인정되는 과정을 거쳐 목표단어까지 도달합니다.
 *         6. 그렇다면 시작단어는 사전에 포함된 단어로 바뀌며, 목표단어까지 도달하기까지 가장 짧은 경로를 찾습니다.
 *         7. 이때 가장 짧은 경로를 찾았다고 가정하고, 이 경로에서 시작단어가 목표단어까지 거쳐간 단어 수를 리턴합니다.
 *
 * @input : biginWord = "hit" , endWord = "cog", dict = ["hot", "dot", "dog", "log", "log"]
 *
 * @ouput : result = 5
 *
 * @문제분석 :
 *      1. 일단 기본적으로 한번의 과정을 거칠때 biginWord의 한글자씩 바꿀 수 있다.
 *      2. 한글자씩 바꿔서 endWord와 비교한다.
 *      3. biginWord를 배열화 한다.
 *      4. 예를 들어 biginWord의 배열로 바꾼다음 첫번째 글자를 변경한다고 가정해보자.
 *      5. 첫번째 요소는 "h"가 된다. 이 요소를 변경했을때 나올 수 있는 글자는
 *      6. 첫번째 요소 : "ait" ~ "zit" 까지의 글자가 될 수 있다. 다른 요소들도 마찬가지다.
 *      7. 두번째 요소 : "hat" ~ "hzt"
 *      8. 세번째 요소 : "hia" ~ "hiz"
 *      9. 위와 같이 나올 수 있는 경우의 문자리스트를 받고, 받은 만큼 다시 위 과정을 반복한다.
 *      10. 언제까지?? 문자리스트 안에 endWord가 나올때까지!
 *      11. 문자리스트에 endWord가 포함될때까지 몇번의 과정을 반복했는지를 리턴하는 문제이다.
 *
 * @시간복잡도 :
 *  대상 :
 *  이유 :
 *
 * @공간복잡도 :
 *  대상 :
 *  이유 :
 */
public class WordLadder {

    public static void main(String[] args) {

        WordLadder a = new WordLadder();
        // 시작단어
        String biginWord = "hit";
        // 목표단어
        String endWord = "cog";
        // 단어사전 배열
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println("result : " + a.solve(words, biginWord, endWord));

    }

    public int solve(String[] words, String biginWord, String endWord) {
        if (words == null || words.length == 0)
            return 0;

        // 중복없는 사전을 위해 Set 사용
        Set<String> dict = new HashSet<>(Arrays.asList(words));

        // 큐 생성
        Queue<String> queue = new LinkedList<>();

        // 시작단어가 주어졌으니 시작단어부터 시작하기 위해 큐에 저장
        queue.offer(biginWord);

        // 시작은 1
        int level = 1;

        // 큐에 더이상 탐색할 단어가 없을때까지
        while (!queue.isEmpty()) {
            // 현재 큐에 저장된 단어 수의 길이
            int size = queue.size();

            // 큐 길이만큼 반복문
            for (int i=0; i<size; i++) {

                // 큐에 저장된 순으로 단어를 꺼내와서
                String str = queue.poll();

                // 꺼내온 단어가 목표단어와 같다면 반복문 종료
                if (str.equals(endWord)) return level;

                // 그렇지 않다면 큐에서 뽑아낸 단어를 임의로 변경했을때
                // 사전에 포함된 단어들을 리스트로 받아놓는다.
                List<String> neighbors = getNeighbors(str, dict);

                // 리스트 반복문 시작
                for (String neighbor : neighbors) {
                    // 큐에 저장
                    queue.offer(neighbor);
                }
            }

            // 반복문 끝나면 레벨 증가
            level++;
        }
        // 여기까지 온다는 것은 목표 단어와 일치하는 경우가 나오지 않았으므로
        // 0 반환
        return 0;
    }

    public List<String> getNeighbors (String s, Set<String> dict) {

        List<String> res = new LinkedList<>();
        // 받은 문자열의 길이만큼 반복문 시작
        for (int i=0; i<s.length(); i++) {
            // 받은 문자열을 char[]로 만들어서
            char[] chars = s.toCharArray();

            // char[] 반복문 시작
            // 'a' 부터 'z'까지 반복시작
            for (char ch ='a'; ch <= 'z'; ch++) {
                // char[] i번째에 'a' 부터 'z'까지 바꾸면서 저장하고,
                chars[i] = ch;

                // 바뀐 char[] 을 다시 문자열로 만들어서
                String word = new String(chars);

                // 사전에 포함된다면
                if (dict.remove(word)) {

                    // 리스트 저장
                    res.add(word);
                }
            }
        }
        // 반복문 끝나면 반환
        return res;
    }

}

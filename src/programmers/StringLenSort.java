package programmers;

import java.util.*;

public class StringLenSort {

    public static void main(String[] args) {
        StringLenSort a = new StringLenSort();
        String[] strs = {"a", "aaa", "bb", "ab", "cc", "cba", "a"};
        String[] result = a.solution(strs);
        System.out.println("result : " + result);
    }

    public String[] solution(String[] strs) {
        String[] result = {};
        Set<String> set = new HashSet<>(Arrays.asList(strs));
        Queue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (a.length() < b.length()) {
                    return -1;
                } else if (a.length() == b.length()) {
                    // 길이가 같은 경우 compareTo를 이용해 역순 배치
                    if (a.compareTo(b) < 0)
                        return 1;
                    else
                        return -1;
                } else {
                    return 1;
                }
            }
        });

        for (String str : strs) {
            set.add(str);
        }
        for (String str : set) {
            queue.offer(str);
        }

        result = new String[queue.size()];
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }


        return result;
    }

}

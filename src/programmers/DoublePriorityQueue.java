package programmers;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] soultion(String[] operations) {
        /**
         * I 숫자 : 큐에다 주어진 숫자를 삽입
         * D 1 : 큐에서 가장 최댓값을 삭제
         * D -1 : 큐에서 가장 최소값을 삭제
         */
        if (operations == null || operations.length == 0)
            return new int[2];

        Queue<Integer> queue = new LinkedList<>();

        for (String str : operations) {
            String[] cal = str.split(" ");
            String command = cal[0];
            String value = cal[1];
            switch (command) {
                case "I" :
                    // 큐에 저장
                    queue.offer(Integer.parseInt(value));
                    break;

                case "D" :
                    // 큐에 저장된 요소가 없다면 무시
                    if (!queue.isEmpty()) {

                        int purpose = queue.poll(); // 찾고자 하는 수(최대 값 or 최소 값)이며, 일단 큐에서 첫번째 요소 꺼내오기
                        int size = queue.size();    // 첫번째 값을 뺀 큐의 길이
                        int cnt = 0;                // 반복 카운트

                        // 반복카운트가 큐의 길이보다 작을동안 반복
                        while (cnt < size) {
                            // 비교대상이 될 수 큐에서 꺼내기(첫번째는 위에서 이미 꺼냈으므로 기존에 두번째였던 요소를 꺼낸다)
                            int cur = queue.poll();
                            // 명령 타입 확인(1 : 최대 값 찾고 제거 or -1 : 최소 값 찾고 제거)
                            switch (value) {
                                case "1": // 큐에 저장된 수 중 가장 큰 수 제거
                                    // purpose와 cur중 더 작은 값은 큐에 다시 저장
                                    queue.offer(Math.min(purpose, cur));
                                    // 둘 중의 더 큰 값으로 purpose 값 변경
                                    purpose = Math.max(purpose, cur);
                                    // 반복 카운트 증가
                                    break;
                                case "-1": // 큐에 저장된 수 중 가장 작은 수 제거
                                    // purpose와 cur중 더 큰 값는 큐에 다시 저장
                                    queue.offer(Math.max(purpose, cur));
                                    // 둘 중의 더 작은 값으로 purpose 값 변경
                                    purpose = Math.min(purpose, cur);
                                    break;
                            }
                            // 반복 카운트 증가
                            cnt++;
                        }
                    }
                    break;
            }
        }
        int[] result = new int[2];
        if (!queue.isEmpty()) {
            result[0] = Collections.max(queue); // 현재 큐에 저장된 값중 최대 값
            result[1] = Collections.min(queue); // 현재 큐에 저장된 값중 최소 값
        }

        return result;
    }
    Solution() {}

}
public class DoublePriorityQueue {

    public static void main(String[] args) {

        Solution fn = new Solution();
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        int[] result = fn.soultion(operations);

        System.out.println("Result : max -> " + result[0] + ", min -> " + result[1]);
    }

}

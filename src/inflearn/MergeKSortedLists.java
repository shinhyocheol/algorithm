package inflearn;

import javax.swing.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @문제설명 :K 개의 소팅된 LinkedList의 배열 lists가 주어집니다.
 *          각각의 LinkedList는 오름차순으로 정렬되어 있습니다.
 *          K개의 소팅된 LinkedList 배열 lists를 하나의 정렬된 LinkedList로 병합하고 리턴합니다.
 *
 * @input : lists[][] = {{1,4,5}, {1,3,4}, {2,7}}
 * @ouput : [1, 1, 2, 3, 4, 4, 5, 7]
 *
 * @문제분석 :
 *      1. [1 -> 4 -> 5, 1 -> 3 -> 4, 2 -> 7]
 *      2. [1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 7]
 *      3. min hip 구조를 사용해서 풀어볼 수 있다.
 *
 *      ## LinkedList 구조를 이해해야한다.
 *      ## min hip 구조를 이용해 각 요소를 비교할 때 더 작은 요소를 선택해서 넣어주고, 해당 구간을 다음 순번의 요소로 교체한다.
 *      ## 교체한 후 비교 작업을 다시 반복한다. 이런식으로 작은 요소부터 먼저 들어가게끔 만든다.
 *
 *
 * @시간복잡도 : O (N logK)
 *  대상 : ListNode[] lists
 *  이유 : n = 모든 리스트의 node수, k = list의 수
 *
 * @공간복잡도 : O(N)
 *  대상 : ListNode head = new ListNode(0);
 *  이유 : n = 모든 리스트의 node수를 추가
 */
public class MergeKSortedLists {

    public static void main(String[] args) {

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list2.next = new ListNode(7);

        ListNode[] lists = {list1, list2, list3};

        MergeKSortedLists a = new MergeKSortedLists();
        ListNode result = a.solve(lists);

        System.out.println();
        while (result!= null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();

    }

    public ListNode solve(ListNode[] lists) {
        // 1. ds
        // 1. Java 8 이상에서 람다식으로 오름차순 우선순위 큐를 정의할때
        Queue<ListNode> q = new PriorityQueue<>((a, b) -> a.val - b.val);
        // a.val - b.val 여기서 a와 b는 ListNode들의 가장 첫번째 요소를 의미한다.
        // next를 가져오는 코드가 없기때문이다.
        // 따라서 각 ListNode들의 첫번째 요소들끼리 비교해서 우선순위가 정해지고 큐에 저장된다.

        // 데이터를 저장할 ListNode를 정의해야하는데 null로 정의할 수 없으니
        // 첫번째값을 0으로 하여 저장한다.(이 요소는 결과에 포함되지 않고 버리는 값임)
        ListNode head = new ListNode(0);
        ListNode res = head;

        // 2. Java 8 미만에서 Comparator 를 이용해 오름차순 우선순위 큐를 정의할때
//        Queue<ListNode> q2 = new PriorityQueue<>(new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                return o1.val - o2.val;
//            }
//        });

        // 2. for while
        // 위에서 생성한 우선순위 큐에 ListNode 객체들을 반복문을 통해 저장한다.
        // 당연히 위에서 정의한 규칙을 따라 첫번째 요소들을 기준으로 오름차순으로 큐에 저장된다.
        // <저장순서>
        // 1, 4, 5
        // 1, 3, 4
        // 2, 7
        for (ListNode list : lists) {
            if (list != null) {
                q.offer(list);
            }
        }

        while (!q.isEmpty()) {
            ListNode node = q.poll();
//            System.out.println(node.val);
            res.next = node;
            res = res.next;

            if (node.next != null) {
                q.offer(node.next);
            }
        }

        return head.next;
    }

}

package inflearn;

import java.util.List;

/**
 *
 * @문제설명 : 단일 연결 리스트가 주어집니다. 리스트를 reverse해서 reversed lists를 리턴하세요
 *
 * @input : head = [1, 2, 3]
 * @ouput : [3, 2, 1]
 *
 * @문제분석 :
 *      1. 첫번째 요소에 next를 null로 채운다.
 *      2. 그리고 자신의 다음순번 요소가 항상 자신을 바라보게끔 만든다.
 *
 *
 * @시간복잡도 :
 *  대상 :
 *  이유 :
 *
 * @공간복잡도 :
 *  대상 :
 *  이유 :
 *
 */
public class ReverseLinkedLists {

    public static void main(String[] args) {

        ListNode lists = new ListNode(1);
        lists.next = new ListNode(2);
        lists.next.next = new ListNode(3);

        ReverseLinkedLists a = new ReverseLinkedLists();

        ListNode res = a.solve(lists);

        System.out.println("======================");
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
        System.out.println("======================");

    }

    public ListNode solve(ListNode lists) {
        ListNode res = new ListNode(0);

        // 1. ds
        ListNode next = null;
        ListNode prev = null;

        // 2. for while
        while (lists != null) {

            // next : 2N - 30
            // next : 30
            // next : null
            next = lists.next;

            // lists.next : 2N -> 30 = null
            // lists.next : 30 = 10
            // lists.next : 10 = 2N -> 10
            lists.next = prev;

            // prev : null = 10
            // prev : 10 = 2N -> 10
            // prev : 2N -> 10 = 30 -> 2N -> 10
            prev = lists;

            // lists : 1N -> 2N -> 30 = 2N -> 30
            // lists : 2N -> 10 = 30
            // lists : null
            lists = next;

        }

        return prev;
    }

}

package codingPractice;

import java.util.List;

/**
 *
 * @문제설명 : 두개의 리스트가 주어질떄 같은 순서의 요소를 합산하고 10이 넘어가는 경우 다음 순서 합산에 더하여
 * 합산 결과를 만들어보세요.
 *
 * @제한사항 :
 *
 *
 * @input : int[] = {2, 4, 3}, int[] = {5,6,2}
 * @ouput : int = 706
 *
 * @문제분석 :
 *
 *
 * @시간복잡도 :
 *
 * @공간복잡도 :
 */
class ListNode {
    int val;
    ListNode next;
    ListNode (int x) {
        this.val = x;
    }
}
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(2);

        ListNode node = solve(l1, l2);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode solve(ListNode l1, ListNode l2) {
        ListNode nodeHead = new ListNode(0);
        ListNode p1 = l1, p2 = l2, p3 = nodeHead;

        int carry = 0;

        //2
        while (p1 != null || p2 != null) {
            if (p1 != null) {
                carry+= p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                carry+= p2.val;
                p2 = p2.next;
            }
            p3.next = new ListNode(carry % 10);
            p3 = p3.next;
            carry /=10;
        }
        if (carry == 1) {
            p3.next = new ListNode(1);
        }
        return nodeHead.next;
    }

}

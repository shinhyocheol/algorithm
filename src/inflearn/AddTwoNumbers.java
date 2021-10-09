package inflearn;

/**
 *
 * @문제설명 : 두개의 리스트가 주어질떄 같은 순서의 요소를 합산하고 10이 넘어가는 경우 다음 순서 합산에 더하여
 * 합산 결과를 만들어보세요.
 *
 *
 * @input : int[] = {2, 4, 3}, int[] = {5,6,2}
 * @ouput : int = 706
 *
 * @문제분석 :
 *      1. ListNode를 이용한다.
 *      2. 첫번째를 값이 0인 더미 데이터로 생성한다.
 *      3. ListNode 클래스를 생성하고 객체를 생성한다.
 *      4. ListNode 클래스에는 현재의 값인 val과 다음순번의 객체가 담길 ListNode 클래스 타입의 next가 존재한다.
 *      5. 반복문을 통해 현재요소들의 값을 계산하고 다음순번의 객체를 생성한다.
 *      6. 현재 요소들의 계산이 끝나면 캐리값을 저장한 후 다음순번의 객체를 현재 요소로 변경하여 계산을 반복한다.
 *
 * @시간복잡도 :
 *
 * @공간복잡도 :
 */
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
        // 1
        ListNode newHead = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p3 = newHead;
        int carry = 0;

        // 2
        while (p1 != null || p2 != null) {
            if (p1 != null) {
                // carry(0) + p1.val(2) = 2;
                // carry(0) + p1.val(4) = 4;
                carry += p1.val;

                // p1(2) = p1.next(4)
                // p1(4) = p1.next(3)
                p1 = p1.next;
            }
            if (p2 != null) {
                // val(2) += 5;
                // val(4) += 6;
                // carry(2) + p1.val(5) = 7;
                // carry(4) + p1.val(6) = 10;
                carry += p2.val;

                // p2(5) = p2.next(6);
                // p2(6) = p2.next(2);
                p2 = p2.next;
            }

            // p3.next = carry(7) % 10 = 0.7;
            // p3.next.next = carry(10) % 10 = 1;
            // p3.next.next.next = carry(5) % 10 = 0.5;
            p3.next = new ListNode(carry % 10);
            System.out.println("carry % 10 : " + carry % 10);


            p3 = p3.next;

            // carry = carry(7) / 10;
            // carry = carry(10) / 10;
            // carry = carry(5) / 10;
            carry = carry / 10;

            System.out.println("carry /= 10 : " + carry);
        }
        if (carry == 1) {
            p3.next = new ListNode(1);
        }
        return newHead.next;
    }

}

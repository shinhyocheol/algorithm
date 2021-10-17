package programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * 문제 설명
 * 민호는 다단계 조직을 이용하여 칫솔을 판매하고 있습니다.
 * 판매원이 칫솔을 판매하면 그 이익이 피라미드 조직을 타고 조금씩 분배되는 형태의 판매망입니다. 어느정도 판매가 이루어진 후,
 * 조직을 운영하던 민호는 조직 내 누가 얼마만큼의 이득을 가져갔는지가 궁금해졌습니다. 예를 들어, 민호가 운영하고 있는 다단계 칫솔 판매 조직이 아래 그림과 같다고 합시다.
 *
 * 민호는 center이며, 파란색 네모는 여덟 명의 판매원을 표시한 것입니다. 각각은 자신을 조직에 참여시킨 추천인에 연결되어 피라미드 식의 구조를 이루고 있습니다.
 * 조직의 이익 분배 규칙은 간단합니다.
 * 모든 판매원은 칫솔의 판매에 의하여 발생하는 이익에서 10% 를 계산하여 자신을 조직에 참여시킨 추천인에게 배분하고 나머지는 자신이 가집니다.
 * 모든 판매원은 자신이 칫솔 판매에서 발생한 이익 뿐만 아니라, 자신이 조직에 추천하여 가입시킨 판매원에게서 발생하는 이익의 10% 까지 자신에 이익이 됩니다.
 * 자신에게 발생하는 이익 또한 마찬가지의 규칙으로 자신의 추천인에게 분배됩니다.
 * 단, 10% 를 계산할 때에는 원 단위에서 절사하며, 10%를 계산한 금액이 1 원 미만인 경우에는 이득을 분배하지 않고 자신이 모두 가집니다.
 *
 * 예를 들어, 아래와 같은 판매 기록이 있다고 가정하겠습니다. 칫솔의 판매에서 발생하는 이익은 개당 100 원으로 정해져 있습니다.
 *
 * @intput :
 *          enroll =    {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}
 *          referral =  {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"}
 *          seller = {"young", "john", "tod", "emily", "mary"}
 *          amount = {12, 4, 2, 5, 10}
 *
 * @output : result = {360, 958, 108, 0, 450, 18, 180, 1080}
 */
public class ToothbrushSales {

    public static void main(String[] args) {

        String[] enroll =    {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral =  {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        ToothbrushSales toothbrushSales = new ToothbrushSales();

        int[] result = toothbrushSales.solution(enroll, referral, seller, amount);

        System.out.println();
        for (int res : result) {
            System.out.print(res + " ");
        }
        System.out.println();

    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] result = new int[enroll.length];
        Map<String, Integer> enrollAmount = new HashMap<>();
        Map<String, String> map = new HashMap<>();

        for (int i=0; i<enroll.length; i++) {
            enrollAmount.put(enroll[i], 0);
            map.put(enroll[i], referral[i]);
        }

        for (int i=0; i<seller.length; i++) {
            dfs(seller[i], (amount[i] * 100), enrollAmount, map);
        }

        for (int i=0; i<enroll.length; i++) {
            result[i] = enrollAmount.get(enroll[i]);
        }

        return result;
    }

    public void dfs(String seller, int amount, Map<String, Integer> enrollAmount, Map<String, String> map) {
        // 합산할 금액이 있다면
        if (amount > 0) {
            int sellerAmount = enrollAmount.get(seller);
            sellerAmount += amount - (int)(amount * 0.1);
            enrollAmount.put(seller, sellerAmount);

            // john과 같은 경우 민호를 제외하고 최 상단에 위치한 노드이므로 재귀호출 없이 계산만 한다.
            if (!map.get(seller).equals("-")) {
                String ref = map.get(seller);
                dfs(ref, (int)(amount * 0.1), enrollAmount, map);
            }
        }
    }
}

package inflearn;

/**
 *
 * @문제설명 : 트리가 주어졌을 때 해당 트리에서 가장 큰 dept 수를 리턴하세요.
 *
 * @input : TreeNode 타입의 트리
 *              1 : 3
 *              2 : 3-1, 3-4
 *              3 : 1-5, 1-8
 *              4 : 5-7
 *
 * @ouput : 4
 *
 * @문제분석 :
 *  1. 재귀함수를 통해 풀어볼 수 있다.
 *  2. 노드는 left와 right라는 자식 노드를 가질 수 있음. null일수도 있음.
 *  3. 재귀함수를 통해 left와 right 노드를 끝까지 방문한다.
 *  4. 언뜻보면 root 노드부터 시작하는 것처럼 보이지만 가장 하위 노드부터 올라오는 구조이다.
 *  5. 하위노드부터 올라오면서 +1을 하고 left와 right 중 큰 것을 취득한다.
 *  6. 7부터 올라오면 left는 최종적으로 4까지 값이 누적된다. right 요소 중 4까지 누적될 수 있는 요소가 없다.
 *  7. 따라서 값이 4가 나와야 한다.
 *
 * @시간복잡도 :
 *  대상 :
 *  이유 :
 *
 * @공간복잡도 :
 *  대상 :
 *  이유 :
 */
public class MaximumDepthOfBinaryTree_Recurcive {

    public static void main(String[] args) {

        MaximumDepthOfBinaryTree_Recurcive a = new MaximumDepthOfBinaryTree_Recurcive();

        // 트리 생성
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(8);

        root.left.left.left = new TreeNode(7);

        System.out.println("result : " + a.maxDepth(root));

    }

    public int maxDepth(TreeNode tree) {
        if (tree == null)
            return 0;

        // 왼쪽과 오른쪽 노드 중 큰 값을 취하여 거기에 + 1한 값이 최종 값이다.
        // 재귀함수를 호출해 가장 하단부터 올라오는 형식이다.


        // 1. 재귀함수를 통해 left의 가장 하단부까지 내려갈 것이다.
        // 2. 재귀함수를 통해 right의 가장 하단부까지 내려갈 것이다.
        // 3. left 탐색 구조
        // 4. 7 이후로는 null이므로 재귀함수가 멈춘다.
        // 5. 값 7을 가진 노드부터 올라온다.
        // 6. 7을 가진 노드에서 재귀함수를 호출했을때 둘 다 null이므로 left, right 둘 다 0이다.
        // 7. 0과 0중 큰값은 0이며, 거기에 1을 더하여 리턴한다.
        // 8. 5를 가진 노드는 자신의 왼쪽 노드로부터 1을 받았고 오른쪽 노드는 null이므로 0을 받음
        // 9. 1과 0중 큰값은 1이며, 거기에 1을 더하여 리턴한다.
        // 10. 위처럼 반복을 통해 위로 올라간다. 올라가면서 더 큰값이 위로 전달된다.
        // 11. 따라서 5-8이나 3-4을 가진 노드들이 리턴하는 값은 7부터 올라와 누적된 값보다 크지 못하다.
        int leftMax = maxDepth(tree.left);
        int rightMax = maxDepth(tree.right);

        return Math.max(leftMax, rightMax) + 1;
    }


}

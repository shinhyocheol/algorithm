package inflearn;

import java.util.Stack;

/**
 *
 * @문제설명 : 트리가 주어졌을 때 해당 트리에서 가장 큰 dept 수를 리턴하세요.
 *
 * @input : TreeNode 타입의 트리
 *              1 : 1
 *              2 : 1-2, 1-3
 *              3 : 2-4, 2-5
 *              4 : 4-6
 *
 * @ouput : 4
 *
 * @문제분석 :
 *  1. 스택을 이용해 구현한다.
 *  2. 스택에 최초 1을 저장한다.
 *  3. 스택에 저장한 1을 pop하는 순간 1의 자식 노드를 스택에 저장한다.
 *  4. 스택에는 현재 2, 3이 저장되어있다.
 *  5. 스택에서 3을 꺼내어 인접 노드를 확인해보니 아무것도 없으므로 스택에 아무것도 저장안함.
 *  6. 스택에서 2를 꺼내어 인접 노드를 확인해보니 4, 5를 존재하여 스택에 저장
 *  7. 스택에서 5를 꺼내어 인접 노드를 확인해보니 아무것도 없으므로 스택에 아무것도 저장안함.
 *  8. 스택에서 4를 꺼내어 인접 노드를 확인해보니 6이 존재하므로 스택에 저장
 *  9. 스택에서 6을 꺼내어 인접 노드를 확인해보니 아무것도 없으므로 스택에 아무것도 저장안함.
 *  10. push하는 순간 depth값을 누적시키며 저장
 *
 * @시간복잡도 :
 *  대상 :
 *  이유 :
 *
 * @공간복잡도 :
 *  대상 :
 *  이유 :
 */
public class MaximumDepthOfBinaryTree_DFS {

    public static void main(String[] args) {

        MaximumDepthOfBinaryTree_DFS a = new MaximumDepthOfBinaryTree_DFS();

        // 트리 생성
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.left.left = new TreeNode(6);

        System.out.println("result : " + a.dfs(root));

    }

    public int dfs(TreeNode tree) {
        if (tree == null)
            return 0;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> val = new Stack<>();
        stack.push(tree);
        val.push(1);
        int max = 0;

        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();
            int cnt = val.pop();
            max = Math.max(max, cnt);

            if (node.left != null) {
                stack.push(node.left);
                val.push(cnt + 1);
            }
            if (node.right != null) {
                stack.push(node.right);
                val.push(cnt + 1);
            }
        }
        return max;
    }


}

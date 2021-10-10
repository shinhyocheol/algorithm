package inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
 *  1. 큐를 이용해 구현한다.
 *  2. 큐에 루트노드의 값인 3을 넣는다.
 *  3. 큐가 비어있지 않은동안 while문을 돌리고, 큐의 사이즈만큼 for 반복문을 돌린다. 현재 큐의 사이즈는 1이다. 큐에 저장된 3을 꺼내어 인접노드를 확인한다.
 *  4. 3의 인접 노드인 1, 4가 확인되었으니 큐에 저장한다. 여기서 카운트를 +1한다. 그리고 for 반복문이 끝난다.
 *  5. 큐에서 3이 삭제 되었고, 1, 4가 저장되어있다. 두개가 저장되어있으니 while문은 돌고, for반복은 2번을 돈다.
 *  6. 큐에서 1을 꺼내어(저장순이므로) 인접 노드를 확인한다.
 *  7. 1의 인접노드를 확인해보니 5, 8이 확인되었으니 큐에 저장한다.
 *  8. 4의 인접노드를 확인해보니 아무것도 없으므로 큐에 아무것도 저장안한다. 여기서 for반복문 일단 종료하고 카운트 +1을 한다.
 *  9. 큐에 5,8이 저장되어있다. 따라서 while문은 계속 돌고 두개의 트리가 저장되어있으니 for 반복문을 다시 시작한다.
 *  10. 5부터 꺼내어 인접노드를 확인한다. 7이 존재하니 큐에 저장한다.
 *  11. 8을 꺼내어 인접노드를 확인한다. 아무것도 없으니 큐에 아무것도 저장안하고 for 반복문 종료한다. 그리고 카운트 +1을 한다.
 *  12. 큐에는 아직 7이 존재한다. 따라서 while문은 돌고, 큐에는 1개의 노드가 존재하니 for 반복문 다시 시작한다.
 *  13. 큐에서 7을 꺼내어 인접노드 확인한다. 아무것도 없으니 큐에 아무것도 저장안한다.
 *  14. for 반복문을 종료하고 카운트를 +1한다.
 *  15. 큐에는 더이상 아무것도 없으니 while문을 빠져나온다.
 *  16. 위 작업이 진행되는동안 count는 4가 되었다. 이 4가 답이 된다.
 *
 * @시간복잡도 :
 *  대상 :
 *  이유 :
 *
 * @공간복잡도 :
 *  대상 :
 *  이유 :
 */
public class MaximumDepthOfBinaryTree_BFS {

    public static void main(String[] args) {

        MaximumDepthOfBinaryTree_BFS a = new MaximumDepthOfBinaryTree_BFS();

        // 트리 생성
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(8);

        root.left.left.left = new TreeNode(7);

        System.out.println("result : " + a.bfs(root));

    }

    public int bfs(TreeNode tree) {
        if (tree == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }

        return count;
    }


}

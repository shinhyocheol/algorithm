package inflearn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @문제설명 : input으로 1, 2, 3, 4, 5 로 구성된 트리를 받으면
 *       [[1], [2, 3], [4, 5]] 와 각 레벨에 맞게 배열을 구성해 리턴하세요.
 *
 * @input : 1, 2, 3, 4, 5 로 구성된 트리
 * @ouput : [[1], [2, 3], [4, 5]]
 *
 * @문제분석 :
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
public class LevelOrderOfBinaryTree {

    public static void main(String[] args) {

        // 트리 구성
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);


        LevelOrderOfBinaryTree a = new LevelOrderOfBinaryTree();
        List<List<Integer>> result = a.solve(root);

        System.out.println("result : " + result);
    }

    public List<List<Integer>> solve(TreeNode tree) {
        // 1. ds
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);

        // 2. for, while add algo

        // level 1 node(1)
        // level 2 node(2, 3)
        // level 3 node(4, 5)
        // null
        while (!queue.isEmpty()) {

            // level 1 node (1)
            // level 2 node (2, 3) : node of level 1 node
            // level 3 node (4, 5) : left node of level 2 node
            int size = queue.size();

            List<Integer> list = new ArrayList<>();

            // queue size 1
            // queue size 2
            // queue size 2
            for (int i=0; i<size; i++) {

                // level 1 - node
                // level 2 - 2 node
                // level 2 - 3 node
                // level 3 - 4 node
                // level 3 - 5 node
                TreeNode node = queue.poll();

                // 1
                // 2, 3
                // 4, 5
                list.add(node.val);

                // level 1 : 2 = not null
                // level 2 : 4 = not null
                if (node.left != null) {
                    // level 2 left node offer
                    // level 3 left node offer
                    queue.offer(node.left);
                }

                // level 1 : 3 = not null
                // level 2 : 5 = not null
                if (node.right != null) {
                    // level 2 right node offer
                    // level 3 right node offer
                    queue.offer(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }

}

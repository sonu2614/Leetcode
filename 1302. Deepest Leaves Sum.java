// 1302. Deepest Leaves Sum
// Given the root of a binary tree, return the sum of values of its deepest leaves.

// Example 1:

// Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
// Output: 15
// Example 2:

// Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
// Output: 19

// Constraints:

// The number of nodes in the tree is in the range [1, 104].
// 1 <= Node.val <= 100

// Accepted-> 316.2K, Submissions-> 366.4K, Acceptance Rate-> 86.3%

//Solution :-
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (q.isEmpty() == false) {
            int size = q.size();
            sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                sum += curr.val;
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }

        }
        return sum;

    }
}

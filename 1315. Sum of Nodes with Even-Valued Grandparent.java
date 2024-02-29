// 1315. Sum of Nodes with Even-Valued Grandparent
// Given the root of a binary tree, return the sum of values of nodes with an even-valued grandparent. If there are no nodes with an even-valued grandparent, return 0.

// A grandparent of a node is the parent of its parent if it exists.

// Example 1:

// Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
// Output: 18
// Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.
// Example 2:

// Input: root = [1]
// Output: 0

// Constraints:

// The number of nodes in the tree is in the range [1, 104].
// 1 <= Node.val <= 100

// Accepted-> 145.8K, Submissions-> 170.6K, Acceptance Rate-> 85.5%
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
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int sum = 0;
        while (q.isEmpty() == false) {
            TreeNode curr = q.poll();
            if (curr.val % 2 == 0) {
                if (curr.left != null && curr.left.left != null) {
                    sum += curr.left.left.val;
                }
                if (curr.left != null && curr.left.right != null) {
                    sum += curr.left.right.val;
                }
                if (curr.right != null && curr.right.left != null) {
                    sum += curr.right.left.val;
                }
                if (curr.right != null && curr.right.right != null) {
                    sum += curr.right.right.val;
                }
            }
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }

        }
        return sum;
    }
}
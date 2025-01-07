package challenge.Tree;

import challenge.Tree.Helper.BinarySearchTree;
import challenge.Tree.Helper.Print;
import challenge.Tree.Helper.TreeNode;

public class FindHeightOfBST {
    public static int findHeight(TreeNode<Integer> root) {
        if (root == null) {
            return -1;
        }

        else {
            int maxSubTreeHeight = Math.max(findHeight(root.left), findHeight(root.right));
            return 1 + maxSubTreeHeight;
        }
    }

    // Driver code
    public static void main(String[] args) {
        Integer[][] inputs = {
                {18, 15, 13, 19, 5, 14},
                {1, 2, 3, 4, 5, 6},
                {100, 200, 50, 40, 30, 80, 90},
                {10},
                {1, 2},
                {-10, -20, -30, -40, -50, -60, -70}
        };

        for (int i = 0; i < inputs.length; i++) {
            BinarySearchTree<Integer> inputTree = new BinarySearchTree<Integer>(inputs[i]);
            System.out.println((i+1)+ ".\tGiven Tree: ");
            Print.displayTree(inputTree.root);
            System.out.println("\n\tHeight of the Tree: " + findHeight(inputTree.root));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}

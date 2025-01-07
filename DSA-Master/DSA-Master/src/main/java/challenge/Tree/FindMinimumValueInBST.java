package challenge.Tree;

import challenge.Tree.Helper.BinarySearchTree;
import challenge.Tree.Helper.Print;
import challenge.Tree.Helper.TreeNode;

public class FindMinimumValueInBST {
    public static int findMin(TreeNode<Integer> root) {
        if (root == null) {
            return -1;
        }

        TreeNode<Integer> current = root;

        while(current.left != null) {
            current = current.left;
        }

        return current.data;
    }

    public static int findMinRecursion(TreeNode<Integer> root) {
        if (root == null) {
            return -1;
        }

        else if (root.left == null) {
            return root.data;
        }

        else
            return findMinRecursion(root.left);
    }

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
            System.out.println((i+1)+ ".\tInput Tree: ");
            Print.displayTree(inputTree.root);
//            System.out.println("\n\tSmallest element: " + findMin(inputTree.root));
            System.out.println("\n\tSmallest element: " + findMinRecursion(inputTree.root));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}

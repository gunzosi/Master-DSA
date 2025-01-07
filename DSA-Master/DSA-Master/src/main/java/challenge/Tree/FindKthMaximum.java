package challenge.Tree;

import challenge.Tree.Helper.BinarySearchTree;
import challenge.Tree.Helper.Print;
import challenge.Tree.Helper.TreeNode;

public class FindKthMaximum {
    public static int findKthMax(TreeNode<Integer> root, int k) {
        int[] kValue = { k };
        return kthMaximumRec(root, kValue);
    }

    private static int kthMaximumRec(TreeNode<Integer> node, int[] k) {
        if (node == null) {
            return -1;
        }

        int right = kthMaximumRec(node.right, k);

        if (right != -1) {
            return right;
        }

        k[0]--;

        if (k[0] == 0) {
            return node.data;
        }

        return kthMaximumRec(node.left, k);
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
        int[] k = {2, 4, 6, 1, 1, 3};

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1)+ ".\tk = " + k[i]);
            BinarySearchTree<Integer> inputTree = new BinarySearchTree<Integer>(inputs[i]);
            System.out.println("\n\tInput tree: ");
            Print.displayTree(inputTree.root);
            System.out.println("\n\tKth maximum element is: " + findKthMax(inputTree.root, k[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}

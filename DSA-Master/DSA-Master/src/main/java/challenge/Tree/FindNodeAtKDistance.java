package challenge.Tree;

import challenge.Tree.Helper.BinaryTree;
import challenge.Tree.Helper.Print;
import challenge.Tree.Helper.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindNodeAtKDistance {

    public static List<Integer> findKNodes(TreeNode<Integer> root, int k) {
        List<Integer> result = new ArrayList<>();
        findK(root, k, result);
        return result;
    }

    public static void findK(TreeNode<Integer> root, int k, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            result.add(root.data);
            return;
        }
        findK(root.left, k - 1, result);
        findK(root.right, k - 1, result);
    }


    public static void main(String args[]) {

        Integer[][] inputs = {
                {2, 1, 4, 3, 5, 6, 7},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {45, 32, 23, 21, 18, 1},
                {8, 5, 9, 4, 6, null, 10},
                {10, 6, 9, 3, null, 8, null, 3},
        };
        Integer[] k = {0, 1, 2, 1, 3};

        for (int i = 0; i < inputs.length; i++) {
            BinaryTree<Integer> inputTree = new BinaryTree<Integer>(inputs[i]);
            System.out.println((i + 1) + ".\tInput Tree:");
            Print.displayTree(inputTree.root);
            System.out.println("\n\tk: " + k[i]);
            List<Integer> result = findKNodes(inputTree.root, k[i]);
            System.out.println("\n\tResult: " + Arrays.toString(result.toArray()));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}

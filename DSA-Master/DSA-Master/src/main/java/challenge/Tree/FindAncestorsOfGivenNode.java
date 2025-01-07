package challenge.Tree;

import challenge.Tree.Helper.BinarySearchTree;
import challenge.Tree.Helper.Print;
import challenge.Tree.Helper.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindAncestorsOfGivenNode {
    public static List<Integer> findAncestors(TreeNode<Integer> root, int k) {
        List<Integer> result = new ArrayList<>();
        recFindAncestors(root, k, result);
        return result;
    }

    public static boolean recFindAncestors(TreeNode<Integer> root, int k, List<Integer> result) {
        if(root == null) {
            return false;
        } else if (root.data == k) {
            return true;
        }

        boolean recurLeft = recFindAncestors(root.left, k, result);
        if (recurLeft) {
            result.add(root.data);
            return true;
        }

        boolean recurRight = recFindAncestors(root.right, k, result);
        if (recurRight) {
            result.add(root.data);
            return true;
        }

        return false;
    }

    public static List<Integer> findAncestorsIterative(TreeNode<Integer> root, int k) {
        if (root == null) {
            return null;
        }

        List<Integer> ancestors = new ArrayList<>();
        TreeNode<Integer> current = root;

        while (current != null) {
            // If k is greater than the current node's value, move to its right child.
            if (k > current.data) {
                ancestors.add(current.data);
                current = current.right;
            } else if (k < current.data) { // If k is less than the current node's value, move to its left child.
                ancestors.add(current.data);
                current = current.left;
            } else {
                // If k is found, return the ancestors list.
                List<Integer> reversedAncestors = new ArrayList<>(ancestors);
                Collections.reverse(reversedAncestors);
                return reversedAncestors;
            }
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        Integer inputs[][] = {
                {100, 50, 200, 25, 75, 150 , 350},
                {25, 15, 75, 8, 18, 50, 350},
                {350, -100, 450, -175, 125, 375, 500},
                {100},
                {23, 21, 27, 18, 22, 25, 29, 17, 19, 23,45,67,78, 85},
        };
        int k[] = {75, 8, 125, 100, 85};

        for (int i = 0; i < inputs.length; i++) {
            BinarySearchTree<Integer> inputTree = new BinarySearchTree<Integer>(inputs[i]);
            System.out.println((i+1)+ "\tInput Tree: ");
            Print.displayTree(inputTree.root);
            System.out.println("\n\tk: " + k[i]);
            System.out.println("\n\tThe ancestors are : " + findAncestors(inputTree.root, k[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}

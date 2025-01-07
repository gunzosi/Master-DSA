package challenge.Tree.Helper;

public class BinarySearchTree<T extends Comparable<T>> {
    public TreeNode<T> root;

    public BinarySearchTree(T[] values) {
        root = createBinaryTree(values);
    }

    private TreeNode<T> createBinaryTree(T[] values) {
        if(values.length == 0) {
            return null;
        }

        TreeNode<T> root = new TreeNode<>(values[0]);
        for(int i = 1; i < values.length; i++) {
            TreeNode<T> node = new TreeNode<>(values[i]);
            TreeNode<T> curr = root;
            while(true) {
                if (node.data.compareTo(curr.data) <= 0) {
                    if (curr.left == null) {
                        curr.left = node;
                        break;
                    } else {
                        curr = curr.left;
                    }
                } else {
                    if (curr.right == null) {
                        curr.right = node;
                        break;
                    } else {
                        curr = curr.right;
                    }
                }
            }
        }

        return root;
    }
}

package challenge.Tree.Helper;

import java.util.*;

public class BinaryTree<T> {
    public TreeNode<T> root;
    public BinaryTree(T[] ListOfNodes) {
        root = createBinaryTree(ListOfNodes);
    }

    private TreeNode<T> createBinaryTree(T[] ListOfNodes) {
        if (ListOfNodes.length == 0) {
            return null;
        }

        TreeNode<T> root = new TreeNode<>(ListOfNodes[0]);

        Queue<TreeNode<T>> q = new LinkedList<>();
        q.add(root);

        int i = 1;
        while(i < ListOfNodes.length) {
           TreeNode<T> curr = q.remove();
           if (ListOfNodes[i] != null) {
               curr.left = new TreeNode<>(ListOfNodes[i]);
               q.add(curr.left);
           }
           i++;

              if (i < ListOfNodes.length && ListOfNodes[i] != null) {
                curr.right = new TreeNode<>(ListOfNodes[i]);
                q.add(curr.right);
              }

                i++;
        }
        return root;
    }
}

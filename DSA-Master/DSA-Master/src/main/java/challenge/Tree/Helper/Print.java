package challenge.Tree.Helper;

public class Print {
    public static void displayTree(TreeNode<Integer> node) {
        if (node != null) {
            displayTree(node.left);
            System.out.print(node.data + " => ");
            displayTree(node.right);
        }
    }
}
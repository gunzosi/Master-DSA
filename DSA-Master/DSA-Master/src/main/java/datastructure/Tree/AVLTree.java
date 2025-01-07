package datastructure.Tree;

public class AVLTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    private int height(Node node) {
        return node == null ? 0 : node.getHeight();
    }

    private int getBalance(Node node) {
        return node == null ? 0 : height(node.getLeftChild()) - height(node.getRightChild());
    }

    private Node rightRotate(Node y) {
        Node x = y.getLeftChild();
        Node T2 = x.getRightChild();

        x.setRightChild(y);
        y.setLeftChild(T2);

        y.setHeight(Math.max(height(y.getLeftChild()), height(y.getRightChild())) + 1);
        x.setHeight(Math.max(height(x.getLeftChild()), height(x.getRightChild())) + 1);

        return x;
    }

    // Left rotate y
    private Node leftRotate(Node x) {
        Node y = x.getRightChild();
        Node T2 = y.getLeftChild();

        y.setLeftChild(x);
        x.setRightChild(T2);

        x.setHeight(Math.max(height(x.getLeftChild()), height(x.getRightChild())) + 1);
        y.setHeight(Math.max(height(y.getLeftChild()), height(y.getRightChild())) + 1);

        return y;
    }

    public Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if(value < node.getData()) {
            node.setLeftChild(insert(node.getLeftChild(), value));
        } else if (value > node.getData()) {
            node.setRightChild(insert(node.getRightChild(), value));
        } else {
            return node; // Duplicate values are not allowed
        }

        node.setHeight(1 + Math.max(height(node.getLeftChild()), height(node.getRightChild())));

        int balance = getBalance(node);

        // Balance the node if it has become unbalanced
        // Left-Left case
        if(balance > 1 && value < node.getLeftChild().getData()) {
            return rightRotate(node);
        }

        // Right-Right case
        if (balance < -1 && value > node.getRightChild().getData()) {
            return leftRotate(node);
        }

        // Left-Right case
        if (balance > 1 && value > node.getLeftChild().getData()) {
            node.setLeftChild(leftRotate(node.getLeftChild()));
            return rightRotate(node);
        }

        // Right-Left case
        if (balance < -1 && value < node.getRightChild().getData()) {
            node.setRightChild(rightRotate(node.getRightChild()));
            return leftRotate(node);
        }

        return node;
    }

    public void add(int value) {
        root = insert(root, value);
    }

    public Node delete(Node node, int value) {
        if (node == null) {
            return null;
        }

        if (value < node.getData()) {
            node.setLeftChild(delete(node.getLeftChild(), value));
        } else if (value > node.getData()) {
            node.setRightChild(delete(node.getRightChild(), value));
        } else {
            if ((node.getLeftChild() == null) || (node.getRightChild() == null)) {
                node = node.getLeftChild() != null ? node.getLeftChild() : node.getRightChild();
            } else {
                Node temp = findLeastNode(node.getRightChild());
                node.setData(temp.getData());
                node.setRightChild(delete(node.getRightChild(), temp.getData()));
            }
        }

        if(node == null) {
            return null;
        }

        node.setHeight(1 + Math.max(height(node.getLeftChild()), height(node.getRightChild())));

        int balance = getBalance(node);

        // Left-Left case
        if (balance > 1 && getBalance(node.getLeftChild()) >= 0) {
            return rightRotate(node);
        }

        // Left-Right case
        if (balance > 1 && getBalance(node.getLeftChild()) < 0) {
            node.setLeftChild(leftRotate(node.getLeftChild()));
            return rightRotate(node);
        }

        // Right-Right case
        if (balance < -1 && getBalance(node.getRightChild()) <= 0) {
            return leftRotate(node);
        }

        return node;
    }

    public void remove(int value) {
        root = delete(root, value);
    }

    // Smallest node in the tree
    private Node findLeastNode(Node node) {
        Node current = node;
        while (current.getLeftChild() != null) {
            current = current.getLeftChild();
        }
        return current;
    }

    // Traversal methods
    public void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            preOrderTraversal(node.getLeftChild());
            preOrderTraversal(node.getRightChild());
        }
    }

    public void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.getLeftChild());
            System.out.print(node.getData() + " ");
            inOrderTraversal(node.getRightChild());
        }
    }

    public void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.getLeftChild());
            postOrderTraversal(node.getRightChild());
            System.out.print(node.getData() + " ");
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // Adding elements
        tree.add(10);
        tree.add(20);
        tree.add(30);
        tree.add(40);
        tree.add(50);
        tree.add(25);

        System.out.println("PreOrder Traversal:");
        tree.preOrderTraversal(tree.getRoot());

        System.out.println("\nInOrder Traversal:");
        tree.inOrderTraversal(tree.getRoot());

        System.out.println("\nPostOrder Traversal:");
        tree.postOrderTraversal(tree.getRoot());

        // Deleting an element
        System.out.println("\n\nDeleting 30");
        tree.remove(30);

        System.out.println("InOrder Traversal after deletion:");
        tree.inOrderTraversal(tree.getRoot());
    }
}

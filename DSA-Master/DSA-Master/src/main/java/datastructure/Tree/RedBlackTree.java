package datastructure.Tree;

public class RedBlackTree {
    private Node root;

    private void rotateLeft(Node node) {
        Node rightChild = node.getRightChild();
        node.setRightChild(rightChild.getLeftChild());

        if (rightChild.getLeftChild() != null) {
            rightChild.getLeftChild().setParent(node);
        }

        rightChild.setParent(node.getParent());

        if (node.getParent() == null) {
            root = rightChild;
        } else if (node == node.getParent().getLeftChild()) {
            node.getParent().setLeftChild(rightChild);
        } else {
            node.getParent().setRightChild(rightChild);
        }

        rightChild.setLeftChild(node);
        node.setParent(rightChild);
    }

    // Hàm xoay phải
    private void rotateRight(Node node) {
        Node leftChild = node.getLeftChild();
        node.setLeftChild(leftChild.getRightChild());

        if (leftChild.getRightChild() != null) {
            leftChild.getRightChild().setParent(node);
        }

        leftChild.setParent(node.getParent());

        if (node.getParent() == null) {
            root = leftChild;
        } else if (node == node.getParent().getRightChild()) {
            node.getParent().setRightChild(leftChild);
        } else {
            node.getParent().setLeftChild(leftChild);
        }

        leftChild.setRightChild(node);
        node.setParent(leftChild);
    }

    // Hàm chèn giá trị vào cây
    public void insert(int data) {
        Node newNode = new Node(data);

        // Chèn nút vào cây nhị phân
        root = insertNode(root, newNode);

        // Khôi phục tính chất Red-Black Tree
        fixInsert(newNode);
    }

    // Hàm hỗ trợ chèn nút vào cây nhị phân
    private Node insertNode(Node current, Node newNode) {
        if (current == null) {
            return newNode;
        }

        if (newNode.getData() < current.getData()) {
            current.setLeftChild(insertNode(current.getLeftChild(), newNode));
            current.getLeftChild().setParent(current);
        } else if (newNode.getData() > current.getData()) {
            current.setRightChild(insertNode(current.getRightChild(), newNode));
            current.getRightChild().setParent(current);
        }

        return current;
    }

    // Hàm cân bằng cây sau khi chèn
    private void fixInsert(Node node) {
        while (node != root && node.getParent().isRed()) {
            if (node.getParent() == node.getParent().getParent().getLeftChild()) {
                Node uncle = node.getParent().getParent().getRightChild();

                // Trường hợp 1: Uncle là đỏ
                if (uncle != null && uncle.isRed()) {
                    node.getParent().setRed(false);
                    uncle.setRed(false);
                    node.getParent().getParent().setRed(true);
                    node = node.getParent().getParent();
                } else {
                    // Trường hợp 2: Uncle là đen và node là con phải
                    if (node == node.getParent().getRightChild()) {
                        node = node.getParent();
                        rotateLeft(node);
                    }

                    // Trường hợp 3: Uncle là đen và node là con trái
                    node.getParent().setRed(false);
                    node.getParent().getParent().setRed(true);
                    rotateRight(node.getParent().getParent());
                }
            } else {
                Node uncle = node.getParent().getParent().getLeftChild();

                // Tương tự như các trường hợp 1, 2, 3 nhưng đối xứng
                if (uncle != null && uncle.isRed()) {
                    node.getParent().setRed(false);
                    uncle.setRed(false);
                    node.getParent().getParent().setRed(true);
                    node = node.getParent().getParent();
                } else {
                    if (node == node.getParent().getLeftChild()) {
                        node = node.getParent();
                        rotateRight(node);
                    }

                    node.getParent().setRed(false);
                    node.getParent().getParent().setRed(true);
                    rotateLeft(node.getParent().getParent());
                }
            }
        }

        root.setRed(false); // Gốc luôn là đen
    }

    // Hàm in cây theo thứ tự inorder
    public void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.getLeftChild());
            System.out.print(node.getData() + (node.isRed() ? " (R) " : " (B) ") + " ");
            inorderTraversal(node.getRightChild());
        }
    }

    public void printTree() {
        inorderTraversal(root);
        System.out.println();
    }

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(15);
        tree.insert(25);
        tree.insert(30);
        tree.insert(5);

        System.out.println("Inorder traversal of Red-Black Tree:");
        tree.printTree();
    }
}
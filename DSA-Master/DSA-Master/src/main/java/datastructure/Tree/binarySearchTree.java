package datastructure.Tree;

public class binarySearchTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    // @@ --- Action Methods -----------------------------

    private Node findLeastNode(Node currentNode) {
        Node temp = currentNode;
        while(temp.getLeftChild() != null) {
            temp = temp.getLeftChild();
        }
        return temp;
    }



    // 1. Insertion
    public boolean add(int value) {
        if (isEmpty()) {
            root = new Node(value);
            return true;
        }

        Node currentNode = root;
        while (currentNode != null) {
            Node leftChild = currentNode.getLeftChild();
            Node rightChild = currentNode.getRightChild();

            if (currentNode.getData() > value) {
                if (leftChild == null) {
                    currentNode.setLeftChild(new Node(value));
                    return true;
                }
                currentNode = leftChild;
            } else {
                if (rightChild == null) {
                    currentNode.setRightChild(new Node(value));
                    return true;
                }
                currentNode = rightChild;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void printTree(Node current) {
        if (current == null) {
            return;
        }

        System.out.println(current.getData() + ",");
        printTree(current.getLeftChild());
        printTree(current.getRightChild());
    }

    // 1.1 -- Recursive Insertion
    public Node recursion_insert(Node currentNode, int value) {
        if (currentNode == null) {
            return new Node(value);
        }

        if (value < currentNode.getData()) {
            currentNode.setLeftChild(recursion_insert(currentNode.getLeftChild(), value));
        } else if (value > currentNode.getData()) {
            currentNode.setRightChild(recursion_insert(currentNode.getRightChild(), value));
        } else {
            return currentNode;
        }
        return currentNode;
    }

    // 2. Search
    public Node search(int value) {
        if (isEmpty()) return null;
        Node currentNode = this.root;

        while (currentNode != null) {
            if (currentNode.getData() == value) return currentNode;

            if (currentNode.getData() > value) {
                currentNode = currentNode.getLeftChild();
            } else {
                currentNode = currentNode.getRightChild();
            }

        }
        System.out.println(value + " not found in the tree");
        return null;
    }

    // 2.1 -- Recursive Search
    public Node searchRecursive(Node currentNode, int value) {
        if (currentNode == null || currentNode.getData() == value) {
            return currentNode;
        }

        if (currentNode.getData() > value) {
            return searchRecursive(currentNode.getLeftChild(), value);
        } else {
            return searchRecursive(currentNode.getRightChild(), value);
        }
    }
    // 3. Deletion

    // ----- ### Node is a leaf node
    // ----- ### Node has one child
    // ----- ### Node has two children

    boolean delete(int value, Node currentNode) {
        if (root == null) return false;
        Node parent = null;
        while(currentNode != null && currentNode.getData() != value) {
            parent = currentNode;
            if (currentNode.getData() > value) {
                currentNode = currentNode.getLeftChild();
            } else {
                currentNode = currentNode.getRightChild();
            }
        }

        if (currentNode == null) return false;

        else if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
            // 1. Node is Left Child
            if (root.getData() == currentNode.getData()) {
                setRoot(null);
                return true;
            }
            else if(currentNode.getData() < parent.getData()) {
                parent.setLeftChild(null);
                return true;
            } else {
                parent.setRightChild(null);
                return true;
            }
        } else if (currentNode.getRightChild() == null) {
            if (root.getData() == currentNode.getData()) {
                return true;
            } else if (currentNode.getData() < parent.getData()) {
                parent.setLeftChild(currentNode.getLeftChild());
                return true;
            } else {
                parent.setRightChild(currentNode.getLeftChild());
                return true;
            }
        } else if (currentNode.getLeftChild() == null) {
            if (root.getData() == currentNode.getData()) {
                return true;
            } else if (currentNode.getData() < parent.getData()) {
                parent.setLeftChild(currentNode.getRightChild());
                return true;
            } else {
                parent.setRightChild(currentNode.getRightChild());
                return true;
            }
        } else {
            //Find The Least Value Node in right-subtree of current Node
            Node leastNode = findLeastNode(currentNode.getRightChild());
            //Set CurrentNode's Data to the least value in its right-subtree
            int temp = leastNode.getData();
            delete(temp, root);
            currentNode.setData(temp);
            //Delete the leafNode which had the least value
            return true;
        }
    }

    // 4. Traversal

    // -- 4.1 PreOrder Traversal
    public static void preTraverse(Node root) {
        if (root == null) return;
        System.out.println(root.getData() + ",");
        preTraverse(root.getLeftChild());
        preTraverse(root.getRightChild());
    }

    // -- 4.2 InOrder Traversal
    public static void inTraverse(Node root) {
        if (root == null) return;

        inTraverse(root.getLeftChild());
        System.out.println(root.getData() + ",");
        inTraverse(root.getRightChild());
    }

    // -- 4.3 PostOrder Traversal
    public static void postTraverse(Node root) {
        if (root == null) return;

        postTraverse(root.getLeftChild());
        postTraverse(root.getRightChild());
        System.out.println(root.getData() + ",");
    }
}

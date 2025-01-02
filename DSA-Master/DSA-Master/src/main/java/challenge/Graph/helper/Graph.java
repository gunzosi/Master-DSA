package challenge.Graph.helper;

public class Graph {
    public int vertices;
    public LinkedList<Integer>[] adjacencyList;
    // public DoublyLinkedList < Integer > adjacencyList[];

    public int getVertices() {
        return vertices;
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

    public LinkedList<Integer>[] getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(LinkedList<Integer>[] adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    @SuppressWarnings("unchecked")
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        // For directed graph
        if (source < vertices && destination < vertices) {
            this.adjacencyList[source].insertAtEnd(destination);
        }

        // For undirected graph
        // this.adjacencyList[destination].insertAtEnd(source);
    }

    public void printGraph() {
        System.out.println(">>Adjacency List of Directed Graph");
        for (int i = 0; i < vertices; i++) {
            if (adjacencyList[i] != null) {
                System.out.println("|" + i + "| => ");
                LinkedList<Integer>.Node temp = adjacencyList[i].getHeadNode();
                while (temp != null) {
                    System.out.println("[" + temp.data + "] -> ");
                    temp = temp.nextNode;
                }
                System.out.println("null");
            } else {
                System.out.println("|" + i + "| => " + "null");
            }
        }
    }
}

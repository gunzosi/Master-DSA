package challenge.Graph.helper;

import java.util.List;

public class Graph<T> {
    public int vertices;
    public LinkedList<Integer>[] adjacencyList;
    // public DoublyLinkedList < Integer > adjacencyList[];

    public List<List<Integer>> adjacency;
    public LinkedList<Integer> list[];

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

    public void printAdjacencyList() {
        for (int i = 0; i < vertices; ++i) {
            System.out.print("Vertex " + i + " :");
            for (int j = 0; j < adjacencyList2.get(i).size(); ++j) {
                System.out.print(" -> " + adjacencyList2.get(i).get(j));
            }
            System.out.println();
        }
    }

    public void getAdjacencyList2() {
        for (int i = 0; i < vertices; ++i) {
            System.out.print("Vertex " + i + " :");
            for (int j = 0; j < adjacencyList2.get(i).size(); ++j) {
                System.out.print(" -> " + adjacencyList2.get(i).get(j));
            }
            System.out.println();
        }
    }
}

package challenge.Graph.Challenge;

import challenge.Graph.helper.DoublyLinkedList;
import challenge.Graph.helper.Graph;
import challenge.Graph.helper.LinkedList;
import challenge.StackNQueueP.Helper.Stack;

import java.util.ArrayList;
import java.util.List;

public class ImplementDFS {
    public static List<Integer> dfsTraversal(Graph graph, int source) {
        List<Integer> result = new ArrayList<>();
        int numVertices = graph.vertices;
        boolean[] visited = new boolean[numVertices];

        Stack<Integer> stack = new Stack<>(numVertices);
        stack.push(source);
        visited[source] = true;

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();
            result.add(currentVertex);

            LinkedList<Integer>.Node temp = graph.adjacencyList[currentVertex].getHeadNode();
            while (temp != null) {
                int neighbor = temp.data;
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                    // Mark the neighbors as visited when they are pushed
                    visited[neighbor] = true;
                }
                temp = temp.nextNode;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] graph_vertices = {5, 4, 6};
        int[][][][] graph_edges = {
                {{{0, 1, 2}, {2, 0, 3, 4}}},
                {{{0, 1, 2}, {2, 0, 3}}},
                {{{0, 1, 4}, {1, 2, 5}, {4, 3}, {3, 2}}}
        };
        int[] sources = {2, 0, 0};

        for (int i = 0; i < graph_vertices.length; i++) {
            Graph graph = new Graph(graph_vertices[i]);
            for (int j = 0; j < graph_edges[i][0].length; j++) {
                int source = graph_edges[i][0][j][0];
                for (int k = 1; k < graph_edges[i][0][j].length; k++) {
                    int destination = graph_edges[i][0][j][k];
                    graph.addEdge(source, destination);
                }
            }
            System.out.println((i + 1) + ".\tAdjacency List of the Graph\n");
            graph.printGraph();
            System.out.println("\n\tDFS Traversal starting from vertex " + sources[i] + ": " + dfsTraversal(graph, sources[i]));
            System.out.println(new String(new char[75]).replace('\0', '-'));
        }
    }
}

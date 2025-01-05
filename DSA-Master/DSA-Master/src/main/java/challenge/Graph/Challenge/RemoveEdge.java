package challenge.Graph.Challenge;

import challenge.Graph.helper.Graph;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RemoveEdge {
    static Graph removeEdge(Graph graph, int source, int destination) {
        List<Integer> adjacencyList = (List<Integer>) graph.adjacency.get(source);
        for (int i = adjacencyList.size() - 1; i >= 0; i--) {
            if (adjacencyList.get(i) == destination) {
                adjacencyList.remove(i);
            }
        }
        return graph;
    }

    static int countVertices(List<List<Integer>> edges) {
        int vertices = 0;
        for (List<Integer> edge : edges) {
            for (Integer vertex : edge) {
                vertices = Math.max(vertices, vertex);
            }
        }
        return vertices + 1;
    }

    public static void main(String[] args) {
        List<List<List<Integer>>> edges = Arrays.asList(
                Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 2)),
                Arrays.asList(Arrays.asList(0, 1), Arrays.asList(0, 3), Arrays.asList(1, 2)),
                Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 2), Arrays.asList(1, 3), Arrays.asList(1, 4), Arrays.asList(3, 5)),
                Arrays.asList(Arrays.asList(0, 3), Arrays.asList(1, 3), Arrays.asList(2, 4), Arrays.asList(3, 2)),
                Arrays.asList(Arrays.asList(0, 6), Arrays.asList(1, 5), Arrays.asList(1, 4), Arrays.asList(2, 4), Arrays.asList(2, 5), Arrays.asList(2, 6), Arrays.asList(3, 4), Arrays.asList(3, 6), Arrays.asList(4, 5), Arrays.asList(5, 6))
        );

        Random rand = new Random();

        for (int i = 0; i < edges.size(); ++i) {
            int vertices = countVertices(edges.get(i));
            Graph g = new Graph(vertices);
            List<Integer> edge = edges.get(i).get(rand.nextInt(edges.get(i).size()));
            for (List<Integer> e : edges.get(i)) {
                g.addEdge(e.get(0), e.get(1));
            }
            System.out.println("Initial graph: ");
            g.printAdjacencyList();
            System.out.println("\nSource: " + edge.get(0));
            System.out.println("Destination: " + edge.get(1));
            removeEdge(g, edge.get(0), edge.get(1));
            System.out.println("\nGraph after removing the edge: ");
            g.printAdjacencyList();
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}

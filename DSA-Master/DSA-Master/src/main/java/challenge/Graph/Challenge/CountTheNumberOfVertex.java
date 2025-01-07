package challenge.Graph.Challenge;

import challenge.Graph.helper.Graph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CountTheNumberOfVertex {
    static int countEdges(Graph graph) {
        if (graph.adjacencyList2 == null) {
            throw new IllegalStateException("Adjacency list is not initialized!");
        }

        int sum = 0;
        for (Object obj : graph.adjacencyList2) {
            if (obj instanceof List<?>) {
                List<?> neighbors = (List<?>) obj;
                sum += neighbors.size();
            }
        }
        return sum / 2; // Divide by 2 for undirected graph, remove division for directed graph
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

            for (List<Integer> e : edges.get(i)) {
                g.addEdge(e.get(0), e.get(1));
                // Get the lists from adjacencyList2
                @SuppressWarnings("unchecked")
                List<Integer> sourceList = (List<Integer>) g.adjacencyList2.get(e.get(0));
                @SuppressWarnings("unchecked")
                List<Integer> destList = (List<Integer>) g.adjacencyList2.get(e.get(1));

                // Add the edges for undirected graph
                sourceList.add(e.get(1));
                destList.add(e.get(0));
            }

            System.out.println("Initial graph: ");
            g.printAdjacencyList();
            System.out.println("\nTotal edges: " + countEdges(g) + "\n");
        }
    }
}
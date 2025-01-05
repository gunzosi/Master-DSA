package challenge.Graph.Challenge;

import challenge.Graph.helper.Graph;
import challenge.Graph.helper.LinkedList;
import challenge.Graph.helper.LinkedListNode;

import java.util.Arrays;

public class MotherVertexKosaraju {

    public static int findMotherVertex(Graph g) {
        boolean[] visited = new boolean[g.vertices];
        Arrays.fill(visited, false);

        int lastV = 0;

        for (int i = 0; i < g.vertices; i++) {
            if (!visited[i]) {
                DFS(g, i, visited);
                lastV = i;
            }
        }

        Arrays.fill(visited, false);
        DFS(g, lastV, visited);
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return -1;
            }
        }
        return lastV;

        /*
        * for (boolean b : visited) {
            if (!b) {
                return -1;
            }
        }*/

    }

    public static void DFS(Graph g, int v, boolean[] visited) {
        visited[v] = true;

        LinkedList<Integer> adjList = g.adjacencyList[v];
        LinkedListNode<Integer> node = adjList.head;
        while (node != null) {
            if (!visited[node.data]) {
                DFS(g, node.data, visited);
            }
            node = node.next;
        }
    }

    public static void main(String[] args) {
        int[] n = {3, 4, 5, 4, 3};
        int[][][] edges = {
                {{0, 1}, {0, 2}, {1, 2}},
                {{2, 3}, {3, 2, 1}, {3, 0, 2}, {2, 1}},
                {{0, 1}, {0, 2}, {0, 3}, {0, 4}, {3, 4}},
                {{0, 2, 1}, {3, 2, 1}, {2, 1, 0}},
                {{2, 0, 1}, {1, 2}},
        };

        for (int i = 0; i < n.length; i++) {
            System.out.println((i + 1) + ".\t n = " + n[i]);
            System.out.println("\t Edges = " + Arrays.deepToString(edges[i]));

            Graph g = new Graph(n[i]);
            for (int j = 0; j < edges[i].length; j++) {
                g.addEdge(edges[i][j][0], edges[i][j][1]);
            }

            System.out.println("\n");
            g.printGraph();
            System.out.println("\n\t The mother vertex in this graph is: " + findMotherVertex(g));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}


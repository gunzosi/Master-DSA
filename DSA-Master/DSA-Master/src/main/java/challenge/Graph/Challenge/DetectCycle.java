package challenge.Graph.Challenge;

import challenge.Graph.helper.Graph;
import challenge.Graph.helper.LinkedList;
import challenge.Graph.helper.LinkedListNode;

import java.util.Arrays;

public class DetectCycle {
    public static boolean detectCycle(Graph g) {
        boolean[] visited = new boolean[g.vertices];
        boolean[] recNodeStack = new boolean[g.vertices];
        for (int node = 0; node < g.vertices; node++) {
            if (detectCycleRec(g, node, visited, recNodeStack)) {
                return true;
            }
        }
        return false;
    }

    private static boolean detectCycleRec(Graph g, int node, boolean[] visited, boolean[] recNodeStack) {
        if(recNodeStack[node]) {
            return true;
        }

        if (visited[node]) {
            return false;
        }

        visited[node] = true;
        recNodeStack[node] = true;
        LinkedListNode<Integer> headNode = g.adjacencyList[node].head;
        while (headNode != null) {
            int adjacent = headNode.data;
            if (detectCycleRec(g, adjacent, visited, recNodeStack)) {
                return true;
            }

            headNode = headNode.next;
        }
        recNodeStack[node] = false;
        return false;
    }

    public static void main(String[] args) {
        int[][][] edgesList = {
                {{0,1}, {1,2} ,{2,3}, {3,4}, {4,5},{5,6}, {6,1}},
                {{2, 3}, {3, 2, 1}, {3, 0, 2}, {2, 1}},
                {{}, {8, 2}, {0, 6, 3, 9, 7}, {6, 7, 9, 5, 8}, {8, 6, 5}, {7, 0, 6}, {7, 9}, {9}, {7, 9}, {0}},
                {{2}, {2, 0, 1}, {1, 2}},
                {}
        };

        for (int i = 0; i < edgesList.length; i++) {
            System.out.println((i+1) + "\tEdges = " + Arrays.deepToString(edgesList[i]));
            int numVertices = edgesList[i].length;
            Graph g = new Graph(numVertices);
            for (int index = 0; index < edgesList[i].length; index++) {
                for (int node : edgesList[i][index]) {
                    g.addEdge(index, node);
                }
            }
            g.printGraph();
            System.out.println("\n\tOutput: " + detectCycle(g));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}



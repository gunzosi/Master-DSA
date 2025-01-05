package challenge.Graph.Challenge;

import challenge.Graph.helper.Graph;
import challenge.Graph.helper.LinkedListNode;
import challenge.Graph.helper.Queue;

import java.util.Arrays;

public class FindMinPathGraph {
    public static int findMin(Graph graph, int src, int dest) {
        if (src == dest) {
            return 0;
        }

        int result = 0;
        int numVertices = graph.vertices;

        boolean[] visited = new boolean[numVertices];
        int[] distance = new int[numVertices];

        Queue<Integer> queue = new Queue<>(numVertices);

        queue.enqueue(src);
        visited[src] = true;


        while(!queue.isEmpty()) {
            int currentNode = queue.dequeue();
            LinkedListNode<Integer> temp = null;
            if (graph.adjacencyList[currentNode] != null) {
                temp = graph.adjacencyList[currentNode].head;
            }

            while (temp != null) {
                if (!visited[temp.data]) {
                    visited[temp.data] = true;
                    distance[temp.data] = distance[currentNode] + 1;
                    queue.enqueue(temp.data);
                }

                if (temp.data == dest) {
                    return distance[temp.data];
                }

                temp = temp.next;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        Integer[][][] inputs = {
                {{0, 1},{1, 2}},
                {{1, 2},{2, 4},{1, 4},{4, 3}},
                {{0, 1},{1, 2},{2, 3},{3, 4},{2, 4}},
                {{0, 1},{1, 2},{2, 3},{3, 4},{4, 5},{5, 6}},
                {{0, 1},{1, 2}, {2, 3},{0, 3}},
        };

        Integer[] src =  {0, 1, 0, 0, 1};
        Integer[] dest = {2, 3, 4, 6, 3};

        for (int i = 0; i < inputs.length; i++) {
            Graph g = new Graph(7);
            for (int j = 0; j < inputs[i].length; j++){
                g.addEdge(inputs[i][j][0],inputs[i][j][1]);
            }

            String edges="[";
            for (int j = 0; j < inputs[i].length; j++){
                if(j!=inputs[i].length-1)
                    edges=edges+ Arrays.toString(inputs[i][j])+", ";
                else
                    edges=edges+Arrays.toString(inputs[i][j]);




            }
            edges+="]";

            System.out.println("\tEdges: "+edges+"\n");
            g.printGraph();
            System.out.println("\tsrc: "+src[i]);
            System.out.println("\tdest: "+dest[i]);
            System.out.println("\n\tResult: "+findMin(g,src[i],dest[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}

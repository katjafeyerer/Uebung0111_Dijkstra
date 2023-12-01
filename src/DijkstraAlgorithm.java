import java.util.*;

public class DijkstraAlgorithm {

    public static void main(String[] args) {
        // Beispielgraph
        int[][] graph = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        dijkstra(graph, 0);
    }

    private static void dijkstra(int[][] graph, int startNode) {
        int numNodes = graph.length;
        int[] distance = new int[numNodes];
        boolean[] visited = new boolean[numNodes];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[startNode] = 0;

        for (int i = 0; i < numNodes - 1; i++) {
            int minDistanceNode = minDistance(distance, visited);
            visited[minDistanceNode] = true;

            for (int j = 0; j < numNodes; j++) {
                if (!visited[j] && graph[minDistanceNode][j] != 0 &&
                        distance[minDistanceNode] != Integer.MAX_VALUE &&
                        distance[minDistanceNode] + graph[minDistanceNode][j] < distance[j]) {
                    distance[j] = distance[minDistanceNode] + graph[minDistanceNode][j];
                }
            }
        }

        printSolution(distance);
    }

    private static int minDistance(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && distance[i] < min) {
                min = distance[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    private static void printSolution(int[] distance) {
        System.out.println("Kürzeste Entfernungen von Startknoten:");

        for (int i = 0; i < distance.length; i++) {
            System.out.println("Knoten " + i + ": " + distance[i]);
        }
    }
}
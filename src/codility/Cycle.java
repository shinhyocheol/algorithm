package codility;

import java.util.Stack;

public class Cycle {

    static boolean[] visited;   // 방문여부를 저장할 일차원 배열
    static int[][] graph;       // 인접 행렬을 담을 그래프 배열
    static boolean isCycle;
    static int cycleCount;
    public static void main(String[] args) {

        int[] v = {1, 2, 3, 4, 5, 6};
        int[] e = {2, 3, 4, 5, 6, 1};

        graph = new int[v.length][v.length];
        for (int i=0; i<v.length; i++) {
           int x = v[i];
           int y = e[i];

           graph[x-1][y-1] = 1;
        }
        visited = new boolean[graph.length];
        isCycle = false;
        cycleCount = 0;

        for (int i=0; i<graph.length; i++) {
            if (!visited[i]) dfs(i);
        }

        System.out.println("is cycle?? : " + isCycle);
        System.out.println("cycel count?? : " + cycleCount);
        System.out.println("is one cycel ?? : " + (1 == cycleCount ? true : false));

    }

    static void dfs(int v) {
        if (visited[v]) { // 이미 방문한 정점이라면
            isCycle = true;
            cycleCount++;
            return;
        }

        visited[v] = true; // 방문표시
        for (int j = 0; j<graph[v].length; j++) {
            // 1인 경우 해당 순번의 인덱스가 간선이 되므로 dfs 탐색
            if (graph[v][j] == 1) {
                dfs(j);
            }
        }

    }

}

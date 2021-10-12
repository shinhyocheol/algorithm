package codility;

import java.util.Stack;

public class Cycle {

    static int[][] graph;   // 정점과 간선을 담을 그래프 이차원 배열
    static boolean[] visited;   // 방문여부를 저장할 일차원 배열
    static boolean isCycle; // 싸이클 여부

    public static void main(String[] args) {

        Cycle cycle = new Cycle();

        int[] n = {1, 2, 3};
        int[] e = {2, 3, 2};

        graph = new int[n.length][2];
        for (int i=0; i<n.length; i++) {
           graph[i][0] = n[i];
           graph[i][1] = e[i];
        }
        visited = new boolean[graph.length];

        int i = 0;
        for (int[] g : graph) {
            dfs(g, i, 0);
            i++;
        }
        System.out.println("is Cycle ?? : " + isCycle);
    }

    static void dfs(int[] g, int i, int cnt) {
        if (visited[i])  {
            if (visited.length - 1 == cnt) { // 모든 정점을 방문한 상태인가??
                isCycle = true;
            }
            return; // 이미 방문한 곳이므로 다음 로직 수행 X
        }
        visited[i] = true; // 방문처리
        cnt++; // 방문카운트 적립
        dfs(g, g[1] - 1, cnt); // 간선을 통해 해당 정점 방문
    }

}

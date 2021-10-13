package codility;

import java.util.Stack;

public class Cycle {

    static boolean[] visited;   // 방문여부를 저장할 일차원 배열
    static int[][] graph;       // 인접 행렬을 담을 그래프 배열
    static boolean isCycle;
    public static void main(String[] args) {

        int[] v = {1, 2, 3, 4};
        int[] e = {2, 3, 2, 1};

        graph = new int[v.length][v.length];
        for (int i=0; i<v.length; i++) {
           int x = v[i];
           int y = e[i];
           graph[x-1][y-1] = 1;
        }
        visited = new boolean[graph.length];
        isCycle = false;

        System.out.println("is Cycle?? : " + isCycle);

        dfs(0);

        System.out.println("is Cycle?? : " + isCycle);



    }

    static boolean dfs(int v) {
        visited[v] = true;

        for (int j = 0; j<graph[v].length; j++) {
            if (dfs(j)) return true;
        }

        // 이미 방문한 정점인가??
        if(visited[v])
            return visited[v] == false;

        // dfs가 실행중임
        visited[v] = false;

        // 현재정점의 인접정점 탐색
        for (int j = 0; j<graph[v].length; j++) {
            if (dfs(j)) return true;
        }
        visited[v] = true;
        return false;
    }

}

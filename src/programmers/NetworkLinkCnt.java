package programmers;

public class NetworkLinkCnt {

    public static void main(String[] args) {
        NetworkLinkCnt a = new NetworkLinkCnt();
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        int result = a.solution(n,computers);

        System.out.println("result : " + result);
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n]; // 정점 방문표시 저장 배열

        for (int i=0; i<n; i++) {           // 컴퓨터 수만큼 반복문 시작
            if (!visited[i]) {              // 방문하지 않았다면
                answer++;                   // 카운트 집계하고,
                dfs(computers, visited, i); // 주변탐색시작
            }
        }

        return answer;  // 최종 리턴
    }

    public void dfs(int[][] computers, boolean[] visited, int node) {
        visited[node] = true;                               // node 방문표시
        for (int i=0; i<computers.length; i++) {            // 주변에 탐색할 곳이 없는지 탐색
            if (!visited[i] && computers[node][i] == 1) {   // 아직 방문하지 않았고, 방문할 곳이 1인 경우에만 주변에 더 탐색할 노드가 없는지 추가 탐색(재귀호출)
                dfs(computers, visited, i);
            }
        }
    }

}

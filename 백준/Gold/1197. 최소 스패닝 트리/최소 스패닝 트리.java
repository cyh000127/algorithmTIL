import java.util.*;
import java.io.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int end;
        int cost;

        public Edge(int to, int cost) {
            this.end = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Main.Edge o) {
            return this.cost - o.cost;
        }
    }

    static int V, E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); // 정점의 개수
        E = Integer.parseInt(st.nextToken()); // 간선의 개수
        
        // 1. 배열 크기를 V+1로 변경
        List<Edge>[] adj = new ArrayList[V + 1];

        // 2. 배열 초기화 범위를 V+1로 변경
        for (int i = 0; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 정점 번호를 인덱스로 바로 사용
            adj[start].add(new Edge(end, cost));
            adj[end].add(new Edge(start, cost));
        }

        // 1. 배열 크기를 V+1로 변경
        boolean[] visited = new boolean[V + 1]; 
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        long ans = 0; // ans 타입을 long으로 변경 (비용의 합이 int 범위를 넘을 수 있음)

        int pick = 0; 
        
        // 3. 시작 정점을 1번으로 변경
        visited[1] = true; 
        pq.addAll(adj[1]); // adj[1]의 모든 간선을 pq에 추가
        
        // pick < V-1 조건은 모든 정점을 연결할 때까지 반복하므로 유효합니다.
        while (pick < V - 1 && !pq.isEmpty()) { // pq가 비어있는 경우도 고려
            Edge e = pq.poll();
            if (visited[e.end])
                continue;

            ans += e.cost;
            visited[e.end] = true;
            pick++;

            // 새로 방문한 정점과 연결된 모든 간선을 pq에 추가
            pq.addAll(adj[e.end]);
        }
        System.out.println(ans);
    }
}
import java.util.*;
import java.io.*;

public class Main {
	static class Edge implements Comparable<Edge> {
		int to;
		int cost;

		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Main.Edge o) {
			return this.cost - o.cost;
		}

	}

	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 컴퓨터의 수 (정점)
		M = Integer.parseInt(br.readLine()); // 선의 수 (간선)

		List<Edge>[] adj = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			adj[from].add(new Edge(to, cost));
			adj[to].add(new Edge(from, cost));
		}

		// 방문 배열
		boolean[] visited = new boolean[N + 1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		int ans = 0, pick = 0;
		visited[1] = true;
		pq.addAll(adj[1]);

		while (!pq.isEmpty() && pick < N - 1) {
			Edge e = pq.poll();

			if (visited[e.to])
				continue;

			ans += e.cost;
			visited[e.to] = true;
			pick++;
			
			pq.addAll(adj[e.to]);
		}
		
		System.out.println(ans);
	}
}
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
			return this.cost - o.cost; // 오름차순 정렬
		}
	}

	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 집의 개수 2 ~ 100_000 // 정점 개수
		M = Integer.parseInt(st.nextToken()); // 길의 개수 1 ~ 1_000_000 // 길의 개수

		// A, B, C
		List<Edge>[] adj = new ArrayList[N + 1]; // 집은 1부터

		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			adj[from].add(new Edge(to, cost));
			adj[to].add(new Edge(from, cost)); // 무향
		}

		boolean[] visited = new boolean[N + 1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int ans = 0;
		int pick = 0;

		visited[1] = true;
		pq.addAll(adj[1]);
		int dis = 0;
		// 모든 정점을 연결하거나 pq가 empty가 되기 전까지
		while (!pq.isEmpty() && pick < N - 1) {
			Edge e = pq.poll();
			if (visited[e.to])
				continue;
			dis = Math.max(dis, e.cost);
			ans += e.cost;
			visited[e.to] = true;
			pick++;

			pq.addAll(adj[e.to]);
		}
		ans -= dis; // 가장 긴거 한번 빼줌
		System.out.println(ans);
	}
}
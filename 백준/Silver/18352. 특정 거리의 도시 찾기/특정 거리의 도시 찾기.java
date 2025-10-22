import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {
	int to, cost;

	public Edge(int to, int cost) {
		this.to = to;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.cost - o.cost;
	}

}

public class Main {
	final static int INF = Integer.MAX_VALUE;

	static List<Edge>[] adj;
	static boolean[] visited;
	static int[] dist;
	static int N, M, K, X;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 백준
		// 18352. 특정 거리의 도시 찾기

		// N개의 도시 (1시작) // M개의 도로
		// 도로의 거리는 1
		// X에서 출발했을 때 최단 거리가 K인 애를 모두 구해

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 도시 개수
		M = Integer.parseInt(st.nextToken()); // 도로 개수
		K = Integer.parseInt(st.nextToken()); // 거리
		X = Integer.parseInt(st.nextToken()); // 출발 도시


		dist = new int[N + 1];
		adj = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			adj[from].add(new Edge(to, 1));
		}
		visited = new boolean[N + 1];
		dist = new int[N + 1];

		Arrays.fill(dist, INF);

		bfs(X); 

		boolean isPos = true;
		for (int i = 1; i <= N; i++) {
			if (dist[i] == K) {
				System.out.println(i);
				isPos = false;
			}
		}
		if (isPos)
			System.out.println(-1);
	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();

		dist[start] = 0;
		q.offer(start);

		while (!q.isEmpty()) {
			int current = q.poll();

			for (Edge e : adj[current]) {
				int next = e.to;
				
				if (dist[next] == INF) { 
					dist[next] = dist[current] + 1;
					q.offer(next);
				}
			}
		}
	}
}
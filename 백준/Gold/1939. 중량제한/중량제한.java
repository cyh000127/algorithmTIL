import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {
	int end, cost;

	public Edge(int end, int cost) {
		this.end = end;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return o.cost - this.cost;
	}
}

public class Main {
	static List<Edge>[] graph;
	static int N, M;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// 백준
		// 1939. 중량 제한

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		dist = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph[from].add(new Edge(to, cost));
			graph[to].add(new Edge(from, cost));
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		dijkstra(start);

		System.out.println(dist[end]);

	}

	private static void dijkstra(int from) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		pq.add(new Edge(from, Integer.MAX_VALUE));

		Arrays.fill(dist, 0);
		dist[from] = Integer.MAX_VALUE;

		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			int loc = e.end;
			int nowCost = e.cost;

			if (nowCost < dist[loc]) {
				continue;
			}

			for (Edge ed : graph[loc]) {
				int next = ed.end;
				int bridge = ed.cost;

				int nextCost = Math.min(nowCost, bridge);

				if (dist[next] < nextCost) {
					dist[next] = nextCost;
					pq.add(new Edge(next, nextCost));

				}
			}

		}

	}
}
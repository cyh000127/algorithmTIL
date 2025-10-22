import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {
	int start, end, cost;

	public Edge(int start, int end, int cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}

	public Edge(int end, int cost) {
		this.start = 0;
		this.end = end;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}

}

public class Main {
	final static int INF = Integer.MAX_VALUE;
	static List<Edge>[] adj;
	static boolean[] visited;
	static int M;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 백준
		// 1446. 지름길

		// D킬로미터 길이의 고속도로를 지남
		// 역주행 불가 (단방향)

		// 지름길의 개수 N (12이하) , 고속도로의 길이 D(10000이하)
		// 지름길 시작 위치, 도착위치, 지름길 길이

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 지름길 개수
		M = Integer.parseInt(st.nextToken()); // 고속도로 길이

		adj = new ArrayList[M + 1];
		for (int i = 0; i <= M; i++) {
			adj[i] = new ArrayList<>();
		}

		dist = new int[M + 1];
		visited = new boolean[M + 1];

		Arrays.fill(dist, INF);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			if (to > M)
				continue; // 도착지가 범위 벗어나면 나가버려

			adj[start].add(new Edge(start, to, cost));
		}

		dijkstra(0);

		System.out.println(dist[M]);
	}

	private static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		dist[start] = 0;

		pq.add(new Edge(start, 0));
		int nowLoc = 0;

		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			int current = edge.end;
			int cost = edge.cost;

			if (nowLoc > current)
				continue;

			int nextDrive = current + 1;
			int nextCost = cost + 1;

			if (nextDrive <= M && dist[nextDrive] > nextCost) {
				dist[nextDrive] = nextCost;
				pq.add(new Edge(nextDrive, nextCost));
			}

			for (Edge cut : adj[current]) {
				int shortcut = cut.end;
				int costShortcut = cut.cost;

				int total = costShortcut + cost;

				if (dist[shortcut] > total) {
					dist[shortcut] = total;
					pq.add(new Edge(shortcut, total));
				}
			}
		}
	}
}
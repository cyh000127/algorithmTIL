import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {
	int end, cost;

	public Edge(int end, int cost) {
		super();
		this.end = end;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.cost - o.cost;
	}

}

public class Main {
	static int N, M;
	static int[] dist; // 거리
	static List<Edge>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 백준
		// 1916. 최소비용 구하기

		// N개의 도시 M 개의 버스
		// A번째 도시에서 B 번째 도시까지 가는 버스비용

		N = Integer.parseInt(br.readLine()); // 도시 개수
		M = Integer.parseInt(br.readLine()); // 버스 개수

		dist = new int[N + 1];

		graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph[start].add(new Edge(to, cost));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		dijkstra(start);

		System.out.println(dist[end]);
	}

	private static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start, 0));

		final int INF = Integer.MAX_VALUE;
		Arrays.fill(dist, INF);
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			int currStart = e.end;
			int currCost = e.cost;

			// 지금의 비용이 저장된 비용보다 높다면 무시
			if (currCost > dist[currStart]) {
				continue;
			}

			for (Edge edge : graph[currStart]) {
				int nextStart = edge.end;
				int nextCost = edge.cost + currCost;
				if (nextCost < dist[nextStart]) {
					dist[nextStart] = nextCost;
					pq.add(new Edge(nextStart, nextCost));
				}
			}
		}
	}
}
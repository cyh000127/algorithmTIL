import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
	int w, c;

	public Node(int w, int c) {
		this.w = w;
		this.c = c;
	}

	// 비용을 기준으로 오름차순
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.c - o.c;
	}
}

public class Main {

	static boolean[] visited;
	static List<Node>[] graph;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// 백준
		// 1753. 최단 경로

		// 정점의 개수 V , 간선의 개수 E
		// 시작 정점의 번호 K

		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int K = Integer.parseInt(br.readLine());
		final int INF = Integer.MAX_VALUE;

		graph = new ArrayList[V + 1];
		dist = new int[V + 1];

		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}

		// dist를 INF로 초기화
		Arrays.fill(dist, INF);

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph[to].add(new Node(from, cost));
		}

		dist[K] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(K, 0));

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			int currV = curr.w;
			int currCost = curr.c;

			// 최소값이 현재 비용보다 작다면 건너뛰기
			if (dist[currV] < currCost) {
				continue;
			}

			for (Node next : graph[currV]) {
				int nextV = next.w;
				int nextC = next.c;

				int newCost = currCost + nextC;

				if (newCost < dist[nextV]) {
					dist[nextV] = newCost;
					pq.add(new Node(nextV, newCost));

				}
			}
		}
		for (int i = 1; i <= V; i++) {
			if (dist[i] == INF) {
				sb.append("INF\n");
			} else {
				sb.append(dist[i]).append("\n");
			}
		}
		System.out.print(sb.toString());
	}
}
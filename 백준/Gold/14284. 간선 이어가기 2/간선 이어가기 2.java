import java.util.*;
import java.io.*;

/*
 * 14284 간선 이어가기2
 */
public class Main {

	static class Node implements Comparable<Node> {
		int end;
		int cost;

		public Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			// 오름차순
			return this.end - o.end;
		}

	}

	static int n, m;
	static List<List<Node>> li;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());// 정점 n
		m = Integer.parseInt(st.nextToken());// 간선 m

		li = new ArrayList<>();
		for (int i = 0; i < n+1; i++) {
			li.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			li.get(start).add(new Node(end, cost));
			li.get(end).add(new Node(start, cost));

		}

		st = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		System.out.println(dijkstra(start, end));
	}

	static int INF = 10_000_001;

	private static int dijkstra(int s, int e) {

		int[] dist = new int[n + 1];
		Arrays.fill(dist, INF);

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(s, 0));

		while (!pq.isEmpty()) {
			Node n = pq.poll();
			int now = n.end;
			int nowC = n.cost;

			// 최솟값으로 등록된애보다 높을시에 무시
			if (nowC > dist[now]) {
				continue;
			}

			for (Node no : li.get(now)) {
				if (no.cost + nowC < dist[no.end]) {
					dist[no.end] = no.cost + nowC;
					pq.add(new Node(no.end, dist[no.end]));
				}
			}
		}

		return dist[e];
	}
}
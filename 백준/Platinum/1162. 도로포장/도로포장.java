import java.util.*;
import java.io.*;

/*
 * 1162 도로포장
 */
public class Main {
	static class Edge {
		int end;
		int cost;

		Edge(int to, int weight) {
			this.end = to;
			this.cost = weight;
		}
	}

	public static class Node implements Comparable<Node> {
		int end;
		long cost;
		int pack;

		public Node(int e, long c, int p) {
			end = e;
			cost = c;
			pack = p;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(cost, o.cost);

		};

	}

	static List<List<Edge>> li;
	static int n, m, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken()); // 포장할 수 있는 도로의 수

		// 각 남은 노선별 최소 치의 배열을 만든 후에
		// dp로 해결하면 되는건가 ??

		li = new ArrayList<List<Edge>>();
		for (int i = 0; i <= n; i++) {
			li.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			li.get(s).add(new Edge(e, c));
			li.get(e).add(new Edge(s, c));
		}

		System.out.println(dijkstra());
	}

	static final long INF = 10_000_000_001L;

	private static long dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 0, 0));

		long[][] dist = new long[n + 1][k + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(dist[i], INF);
		}

		dist[1][0] = 0;

		while (!pq.isEmpty()) {
			Node s = pq.poll();
			int e = s.end;
			long c = s.cost;
			int p = s.pack;

			if (c > dist[e][p]) {
				continue;
			}

			for (Edge x : li.get(e)) {
				if (p < k && dist[x.end][(p + 1)] > c) {
					dist[x.end][(p + 1)] = c;
					pq.add(new Node(x.end, c, p + 1));
				}
				if (dist[x.end][p] > x.cost + c) {
					dist[x.end][p] = c + x.cost;
					pq.add(new Node(x.end, x.cost + c, p));
				}
			}
		}

//		for (int i = 1; i <= n; i++) {
//			System.out.println();
//			for (int j = 0; j <= k; j++) {
//				System.out.print(dist[i][j] + " ");
//			}
//		}

		long s = INF;
		for (int i = 0; i <= k; i++) {
			s = Math.min(dist[n][i], s);
		}

		return s;
	}
}

import java.util.*;
import java.io.*;

/*
 * 17396 백도어
 */
public class Main {

	public static class Node implements Comparable<Node> {
		int end;
		long cost;

		public Node(int e, long c) {
			end = e;
			cost = c;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.cost, o.cost);

		};

	}

	static List<List<Node>> li;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 0에서 시작 -> N-1 까지 이동

		// 시야에 걸리는 모든 행동에 대해서는 불가능함

		// N, M이 공백으로 주어짐

		// a,b,t
		// a번째 b 번째 분기를 지나는데 t시간이 걸림

		// 각 분기점이 보이는지를 말해주는 N개의 정수가 있음

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] isVisible = new int[n];
		for (int i = 0; i < n; i++) {
			isVisible[i] = Integer.parseInt(st.nextToken());
		}

		// 넥서느는 항상 보이기 때문에 편하게 사용하기 위해 0 으로 초기화
		isVisible[n - 1] = 0;

		li = new ArrayList();
		for (int i = 0; i < n; i++) {
			li.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (isVisible[s] == 0 && isVisible[e] == 0) {
				li.get(s).add(new Node(e, c));
				li.get(e).add(new Node(s, c));
			}
		}

		System.out.println(dijkstra());

	}

	static final long INF = 10_000_000_001L;

	private static long dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 0));

		long[] dist = new long[n];
		Arrays.fill(dist, INF);
		dist[0] = 0;
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			int e = now.end;
			long c = now.cost;

			if (c > dist[e] || e == n - 1) {
				continue;
			}

			for (Node s : li.get(e)) {
				if (s.cost + c < dist[s.end]) {
					dist[s.end] = s.cost + c;
					pq.add(new Node(s.end, s.cost + c));
				}
			}
		}

		if (dist[n - 1] == INF) {
			return -1;
		} else {
			return dist[n - 1];
		}
	}
}
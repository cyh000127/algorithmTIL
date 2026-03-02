import java.util.*;
import java.io.*;

/**
 * 5972 택배 배송
 */
public class Main {
	static int N;
	static List<List<Node>> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N개의 헛간
		// M개의 길
		// C마리의 소가 있음

		// 현서는 1에서 시작
		// 찬홍이는 N에서 시작

		// 최소 여물을 찾아라

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());

			list.get(start).add(new Node(start, end, cost));
			list.get(end).add(new Node(end, start, cost));
		}

		int[] dist = dijkstra(0, N - 1);

		System.out.println(dist[N - 1]);
	}

	private static int[] dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(-1, start, 0));

		boolean[] visited = new boolean[N];

		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			int to = curr.end;
			int cost = curr.cost;

			if (visited[to])
				continue;
			
			visited[to] = true;
			
			if (to == end)
				break;

			// end에서 시작하는 애들을 가져오기
			for (Node x : list.get(to)) {
				if (!visited[x.end] && dist[x.end] > cost + x.cost) {
					dist[x.end] = cost + x.cost;
					pq.add(new Node(x.start, x.end, dist[x.end]));
				}
			}

		}
		return dist;

	}

	static class Node implements Comparable<Node> {
		int start;
		int end;
		int cost;

		public Node(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(cost, o.cost);
		}

	}
}
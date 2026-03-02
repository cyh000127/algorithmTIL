import java.util.*;
import java.io.*;

/**
 * 1238 파티
 */
public class Main {
	static int n, m, x;
	static final int INF = 1_000_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N개의 숫자로 구분된 각각의 마을에 한 명의 학생이 사는 중

		// X번 마을에서 시작
		// M개의 단방향 도로 존재
		// i번째 길 통과시 T시간 소비

		// 오고 가는데 가장 많은 시간을 쓰는 학생을 구하여라

		// 앞 뒤로 한번씩 구해야하기 때문에 x도착, x출발 하나씩 구해서 더하면 될듯?

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken()) - 1;

		// 정방향 그래프 (start -> end)
		List<List<Node>> list = new ArrayList<>();
		// 역방향 그래프 (end -> start)
		List<List<Node>> reverse = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			list.add(new ArrayList<>());
			reverse.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());

			list.get(start).add(new Node(start, end, cost));
			// 간선 반대로도 저장
			reverse.get(end).add(new Node(end, start, cost));
		}

		// 정방향 최소경로 (x -> i)
		int[] fromX = dijkstra(x, list);

		// 역방향 최소경로 (i -> x)
		int[] toX = dijkstra(x, reverse);

		// 합치기
		int max = 0;
		for (int i = 0; i < n; i++) {
			// 갈 수 없는 케이스가 섞이면 스킵
			if (fromX[i] == INF || toX[i] == INF)
				continue;
			max = Math.max(max, fromX[i] + toX[i]);
		}
		System.out.println(max);
	}

	private static int[] dijkstra(int startIdx, List<List<Node>> graph) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(-1, startIdx, 0));

		int[] dist = new int[n];
		Arrays.fill(dist, INF);
		dist[startIdx] = 0;

		boolean[] visited = new boolean[n];

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			int end = curr.end;
			int cost = curr.cost;

			// 방문 추가
			if (visited[end])
				continue;

			visited[end] = true;

			// end에서 갈 수 있는 곳들 모두 찾기
			for (Node next : graph.get(end)) {
				if (!visited[next.end] && dist[next.end] > cost + next.cost) {
					dist[next.end] = cost + next.cost;
					pq.add(new Node(end, next.end, dist[next.end]));
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
			return Integer.compare(this.cost, o.cost);
		}
	}
}
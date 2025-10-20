import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
	int w;
	int c;

	public Node(int w, int c) {
		this.w = w;
		this.c = c;
	}

	@Override
	public int compareTo(Node o) {
		return this.c - o.c;
	}

}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();

		// 백준
		// 14950. 정복자

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 도시의 개수
		int M = Integer.parseInt(st.nextToken()); // 도로의 개수
		int t = Integer.parseInt(st.nextToken()); // 도로의 비용

		List<Node>[] graph = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph[from].add(new Node(to, cost));
			graph[to].add(new Node(from, cost));

		}
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N + 1];

		pq.add(new Node(1, 0)); // 1번 도시를 처음 pq에 넣음

		int a = 0; // 가중치
		long totalCost = 0;

		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			int to = curr.w;
			int cost = curr.c;

			// 방문했다면 무시
			if (visited[to])
				continue;

			totalCost += cost + (t * a);
			if (totalCost != 0)
				a++;
//			System.out.println(totalCost);

			visited[to] = true;

			for (Node e : graph[to]) {
				if (!visited[e.w])
					pq.add(new Node(e.w, e.c));
			}
		}

		System.out.println(totalCost);
	}
}
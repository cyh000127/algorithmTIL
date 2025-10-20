import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
	int w;
	int c;

	public Node(int w, int c) {
		this.w = w;
		this.c = c;
	}

	// 비용으로 오름차순
	@Override
	public int compareTo(Node o) {
		return this.c - o.c;
	}

}

public class Main {
	static boolean[] visited;
	static PriorityQueue<Node> pq;
	static List<Node>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();

		// 백준
		// 16398. 행성 연결

		// 행성의 수 N
		// 각 행성에 뻗어나가는 관리비용이 행성수 만큼 주어짐

		int P = Integer.parseInt(br.readLine());

		graph = new ArrayList[P];

		for (int i = 0; i < P; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < P; j++) {
				// i가 시작 , j가 도착 , 비용 저장
				int s = Integer.parseInt(st.nextToken());
				graph[i].add(new Node(j, s));
			}
		}

		pq = new PriorityQueue<>();
		visited = new boolean[P];

		// pq에 0에서 시작하라고 넣어두기
		pq.add(new Node(0, 0));

		long MST = 0;
		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			int to = curr.w;
			int cost = curr.c;

			if (visited[to])
				continue;

			visited[to] = true;
			MST += cost;

			for (Node n : graph[to]) {
				if (!visited[n.w]) {
					pq.add(new Node(n.w, n.c));
				}
			}

		}
		System.out.println(MST);
	}
}

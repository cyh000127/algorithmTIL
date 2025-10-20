import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
	int v;
	int e;
	int c;

	public Node(int v, int e, int c) {
		super();
		this.v = v;
		this.e = e;
		this.c = c;
	}

	// 올ㄹㄹㄹㄹㄹㄹㄹㄹ름 차순
	@Override
	public int compareTo(Node o) {
		return this.c - o.c;
	}

}

public class Main {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();

		// 백준
		// 21924. 도시 건설

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 건물의 개수
		int M = Integer.parseInt(st.nextToken()); // 도로의 개수

		List<Node> list = new ArrayList<>();

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		long totalCost = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			list.add(new Node(from, to, cost));
			totalCost += cost;
		}

		// 비용을 기준으로 정렬
		Collections.sort(list);

		long cost = 0;
		int edgeCount = 0;

		for (Node n : list) {
			if (find(n.v) != find(n.e)) {
				union(n.v, n.e);
				cost += n.c;
				edgeCount++;
			}
			if (edgeCount == N - 1) {
				System.out.println(totalCost - cost);
				break;
			}
		}
		if (edgeCount != N - 1) {
			System.out.println(-1);
		}
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			if (a < b) {
				parent[a] = b;
			} else {
				parent[b] = a;
			}
		}

	}

	private static int find(int a) {
		if (a == parent[a])
			return a;
		return parent[a] = find(parent[a]);
	}
}

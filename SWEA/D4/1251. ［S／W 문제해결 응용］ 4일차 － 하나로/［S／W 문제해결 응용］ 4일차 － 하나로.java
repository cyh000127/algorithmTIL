import java.io.*;
import java.util.*;

public class Solution {

	static class Edge implements Comparable<Edge> {
		int u; // 시작 정점
		int v; // 도착 정점
		long w; // 간선 길이 ( 제곱으로 들어감 );

		public Edge(int u, int v, long w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}

		public Edge(int v, long w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			// this.w - o.w 방식은 long의 범위가 int 범위를 넘을 때
			// 오버플로우가 발생하여 잘못된 결과를 낼 수 있습니다.
			// 따라서 아래와 같이 Long.compare를 사용하는 것이 가장 안전하고 표준적인 방법입니다.
			return Long.compare(this.w, o.w);
		}

		@Override
		public String toString() {
			return "Edge [u=" + u + ", v=" + v + ", w=" + w + "]";
		}

	}

	static List<List<Edge>> graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());// N개의 섬
			graph = new ArrayList<>();
			// E * L^2 를 계산해서 환경 부담금이 가장 적은 걸 내게 만드셈

			int[] xarr = new int[N];
			int[] yarr = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				xarr[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				yarr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < N; i++) {
				graph.add(new ArrayList<>());
			}

			int V = N; // 정점 개수
			for (int i = 0; i < N - 1; i++) {
				for (int j = i; j < N; j++) {
					long x = xarr[i] - xarr[j];
					long y = yarr[i] - yarr[j];
					graph.get(i).add(new Edge(j, x * x + y * y)); // 거리를 애초에 제곱으로 넣을 것임
					graph.get(j).add(new Edge(i, x * x + y * y)); // 방향이 없기 떄문에 반대도 넣어주기
				}
			}

			// 간선배열을 저장할 인접리스트
			List<Edge> edges = new ArrayList<>();

			for (int u = 0; u < V; u++) {
				for (Edge edge : graph.get(u)) {
					int v = edge.v;
					long w = edge.w;
					edges.add(new Edge(u, v, w));
				}
			}

			int[] parents = makeSet(V);

			List<Edge> MST = new ArrayList<>();

			// 마지막 출력때 제곱할 필요없음
			Collections.sort(edges); // 거리별로 간선 정렬

			for (Edge edge : edges) { // 가중치가 적은 간선이 순서대로 뽑힘
				if (findSet(parents, edge.u) != findSet(parents, edge.v)) {
					MST.add(new Edge(edge.u, edge.v, edge.w));
					union(parents, edge.u, edge.v);
				}
			}
			double E = Double.parseDouble(br.readLine());
			double ans = 0.0;

			for (Edge edge : MST) {
				ans += edge.w * E;
			}
			ans = Math.round(ans);
			System.out.println("#" + tc + " " + (long)ans );
		}
	}

	private static void union(int[] parents, int x, int y) {
		int root_x = findSet(parents, x);
		int root_y = findSet(parents, y);
		if (root_x != root_y)
			parents[root_x] = root_y;
	}

	private static int findSet(int[] parents, int x) {
		if (parents[x] == x) {
			return x;
		}
		return parents[x] = findSet(parents, parents[x]);
	}

	private static int[] makeSet(int V) {
		int[] parent = new int[V];
		for (int i = 0; i < V; i++) {
			parent[i] = i;
		}
		return parent;
	}
}

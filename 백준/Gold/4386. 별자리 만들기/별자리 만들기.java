import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
	int v;
	int e;
	double cost;

	public Edge() {
	}

	public Edge(int v, int e, double cost) {
		this.v = v;
		this.e = e;
		this.cost = cost;
	}

	// 비용 오름차순 정렬
	@Override
	public int compareTo(Edge o) {
		return Double.compare(this.cost, o.cost);
	}

}

public class Main {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

//		StringBuilder sb = new StringBuilder();

		// 백준
		// 4386. 별자리 만들기

		int n = Integer.parseInt(br.readLine()); // 별의 개수

		double[][] stars = new double[n + 1][2];

		parent = new int[n + 1];

		for (int i = 0; i < n + 1; i++)
			parent[i] = i;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());

			stars[i][0] = x;
			stars[i][1] = y;

		}

		List<Edge> list = new ArrayList<>();
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {

				if (i == j)
					continue;

				double cost = Math
						.sqrt(Math.pow(stars[i][0] - stars[j][0], 2) + Math.pow(stars[i][1] - stars[j][1], 2));
				list.add(new Edge(i, j, cost));

			}
		}

		Collections.sort(list);

//		for (Edge e : list) {
//			System.out.println(e.v + " " + e.e + " " + e.cost);
//		}

		int connectCnt = 0;
		double totalDis = 0.0;

		boolean isPos = true;

		for (Edge e : list) {
			if (find(e.v) != find(e.e)) {
				connectCnt++;
				union(e.v, e.e);
				totalDis += e.cost;
			}

			if (connectCnt == n - 1) {
				System.out.printf("%.2f\n", totalDis);
				isPos = false;
				break;
			}
		}

		if (isPos)
			System.out.println(0);

	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a < b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
	}

	private static int find(int a) {
		if (a == parent[a]) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}

}

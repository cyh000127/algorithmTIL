import java.io.*;
import java.util.*;

// 간선 정보 
class Edge implements Comparable<Edge> {
	int v;
	int e;
	int cost;

	public Edge(int v, int e, int cost) {
		this.v = v;
		this.e = e;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}
}

// 행성들의 좌표 저장
class Planet implements Comparable<Planet> {
	int id;
	int pos; // 좌표정보 (x,y,z)

	public Planet(int id, int pos) {
		this.id = id;
		this.pos = pos;
	}

	// 좌표 기준으로 오름차순 정렬 -> 가장 가까운 행성들만 계산하기 위함
	@Override
	public int compareTo(Planet o) {
		return this.pos - o.pos;
	}
}

public class Main {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

//		StringBuilder sb = new StringBuilder();

		// 백준
		// 2887. 행성 터널

		// 우주는 N개의 행성으로 이루어짐
		// A와 B를 이을때 드는 비용은 min(|xa-xb|,|ya-yb|,|za-zb|)임
		// N-1개의 터널을 만들어서 모든 행성이 연결 ( 크루스칼)되게 만들려함 -> 최소 비용을 구해라
		// 정수의 범위가 -10^9 => 20억임 int 가능
		// 총합 -> long으로 해야할듯? 100_000 * 10억

		int N = Integer.parseInt(br.readLine());

		parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}

		// 0부터 시작
		parent = new int[N];
		for (int i = 0; i < N; i++)
			parent[i] = i;

		Planet[] xPlanets = new Planet[N];
		Planet[] yPlanets = new Planet[N];
		Planet[] zPlanets = new Planet[N];

		// 입력 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
            
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			xPlanets[i] = new Planet(i, x);
			yPlanets[i] = new Planet(i, y);
			zPlanets[i] = new Planet(i, z);
		}

		// 좌표들 정렬
		// 가까운 행성들만 뽑아내기 위해서
		Arrays.sort(xPlanets);
		Arrays.sort(yPlanets);
		Arrays.sort(zPlanets);

		// 간선 리스트 생성
		List<Edge> edges = new ArrayList<>();

		//
		for (int i = 0; i < N - 1; i++) {
			// x좌표 인접 간선
			edges.add(new Edge(xPlanets[i].id, xPlanets[i + 1].id, Math.abs(xPlanets[i].pos - xPlanets[i + 1].pos)));
			// y좌표 인접 간선
			edges.add(new Edge(yPlanets[i].id, yPlanets[i + 1].id, Math.abs(yPlanets[i].pos - yPlanets[i + 1].pos)));
			// z좌표 인접 간선
			edges.add(new Edge(zPlanets[i].id, zPlanets[i + 1].id, Math.abs(zPlanets[i].pos - zPlanets[i + 1].pos)));
		}

		// 모든 간선 비용순으로 정렬
		// 한번 더 정렬해줘야 크루스칼 알고리즘을 사용할 수 있음
		Collections.sort(edges);

		// 크루스칼 알고리즘 수행
		long totalCost = 0; // int의 범위를 벗어남 long으로 선언
		int edgeCount = 0;

		for (Edge edge : edges) {
			if (find(edge.v) != find(edge.e)) { // 사이클이 아니면
				union(edge.v, edge.e);
				totalCost += edge.cost;
				edgeCount++;
				if (edgeCount == N - 1)
					break; // 간선 N-1개 다 찾으면 종료
			}
		}

		System.out.println(totalCost);
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
		if (a == parent[a])
			return a;
		return parent[a] = find(parent[a]);
	}

}

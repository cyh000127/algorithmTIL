import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
	int v; // 정점
	int e; // 간선
	int c; // 비용

	public Edge(int v, int e, int c) {
		super();
		this.v = v;
		this.e = e;
		this.c = c;
	}

	// 오름차순 정렬
	@Override
	public int compareTo(Edge o) {
		return this.c - o.c;
	}

}

public class Main {
	static int[] parent;
	static int N, K;
	static int[][] map;

	static int[][] nodeMap;
	static List<int[]> point;
	static List<Edge> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

//		StringBuilder sb = new StringBuilder();

		// 백준
		// 1944. 복제 로봇

		// 미로의 흩어진 열쇠들을 찾는 임무
		// 로봇은 자기 자신을 원하는 만큼 복제할 수 있음

		// N N 미로
		// M 의 열쇠
		// 로봇 시작 위치

		// 로봇이 움직이는 횟수의 합 -> 로봇이 각각 움직인 횟수의 총 합을 말 함

		// 1 벽 | 0 길
		// S 출발 위치
		// K 열쇠 위치
		// 복제는 S, K 위에서만 가능

		// 가능하면 횟수 불가능하면 -1 출력

		// 생각 :
		// S와 K 각각에서 서로의 거리 잰 후 크루스칼

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		nodeMap = new int[N][N];
		point = new ArrayList<>();

		// idx, r, c 를 넣기 위해 3칸으로
		for (int i = 0; i < K + 1; i++) {
			point.add(new int[3]);
		}

		int idx = 1;
		int num = 0;

		for (int i = 0; i < N; i++) {
			Arrays.fill(nodeMap[i], -1);
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				char now = str.charAt(j);
				int mapN;
				if (now == 'S' || now == 'K') {
					mapN = 3;

					point.get(num)[0] = idx;
					point.get(num)[1] = i;
					point.get(num)[2] = j;

					nodeMap[i][j] = idx;

					// 다음을 위해 1씩 증가
					num++;
					idx++;

				} else {
					mapN = now - '0';
				}
				map[i][j] = mapN;
			}
		}

		// 유니온 파인드
		parent = new int[K + 2];

		for (int i = 0; i <= K + 1; i++) {
			parent[i] = i;
		}

		list = new ArrayList<>();

		for (int i = 0; i < K + 1; i++) {
			bfs(i);
		}

		// 크루스칼을 위한 정렬
		Collections.sort(list);

		int connectCnt = 0;
		int sumCost = 0;

		for (Edge e : list) {
			if (find(e.v) != find(e.e)) {
				union(e.v, e.e);
				connectCnt++;
				sumCost += e.c;
			}
		}

		if (connectCnt == K) {
			System.out.println(sumCost);
		} else {
			System.out.println(-1);
		}

	}

	// 유니온
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a > b) {
			parent[b] = a;
		} else
			parent[a] = b;

	}

	// 파인드
	private static int find(int a) {
		if (parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}

	// 방향 벡터
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static void bfs(int startPointIndex) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];

		int[] startNode = point.get(startPointIndex);
		int startNodeID = startNode[0];
		int startR = startNode[1];
		int startC = startNode[2];

		q.add(new int[] { startR, startC, 0 });
		visited[startR][startC] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			int cost = curr[2];

			for (int d = 0; d < 4; d++) {
				int R = r + dr[d];
				int C = c + dc[d];

				if (R >= 0 && C >= 0 && R < N && C < N && !visited[R][C] && map[R][C] != 1) {
					visited[R][C] = true;
					int nextCost = cost + 1;

					if (nodeMap[R][C] != -1) {
						int endNodeID = nodeMap[R][C];

						if (startNodeID < endNodeID) {
							list.add(new Edge(startNodeID, endNodeID, nextCost));
						}
					}

					q.add(new int[] { R, C, nextCost });
				}
			}
		}
	}
}
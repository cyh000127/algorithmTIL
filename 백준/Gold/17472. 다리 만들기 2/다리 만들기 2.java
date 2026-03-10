import java.util.*;
import java.io.*;

/**
 * 17472 다리 만들기 2
 */
public class Main {
	static int n, m, number;
	static final int INF = 11;
	static int[][] map, bridge;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N x M
		// 땅 1 , 바다 0
		// 1. 방향이 바뀌지 않을것 ( 직선으로만 )
		// 2. 다리의 길이는 2 이상일것 ( 최소 2 )
		// 3. 양 끝이 섬과 인접해야함 ( 어정쩡하게 놓지 마 )

		// !! 다리가 교차할 때에는 둘 다 계산해야 함

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		number = 2;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					// 2부터 시작
					map[i][j] = number;
					findIsland(i, j, number++);
				}
			}
		}

		bridge = new int[number][number];

		for (int i = 0; i < number; i++) {
			Arrays.fill(bridge[i], INF);
		}

		// r 방향
		for (int i = 0; i < n; i++) {
			int x = -1;
			int cnt = 0;

			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0) { // 섬을 만남
					if (x != -1 && map[i][j] != x && cnt > 1) {
						bridge[x][map[i][j]] = Math.min(cnt, bridge[x][map[i][j]]);
						bridge[map[i][j]][x] = Math.min(cnt, bridge[map[i][j]][x]);
					}
					x = map[i][j];
					cnt = 0;
				} else { // 바다

					if (x != -1)
						cnt++;
				}
			}
		}
		// c 방향
		for (int j = 0; j < m; j++) {
			int x = -1;
			int cnt = 0;

			for (int i = 0; i < n; i++) {
				if (map[i][j] != 0) {
					if (x != -1 && map[i][j] != x && cnt > 1) {
						bridge[x][map[i][j]] = Math.min(cnt, bridge[x][map[i][j]]);
						bridge[map[i][j]][x] = Math.min(cnt, bridge[map[i][j]][x]);
					}
					x = map[i][j];
					cnt = 0;
				} else {
					if (x != -1)
						cnt++;
				}
			}
		}

		List<Edge> edges = new ArrayList<>();

		for (int i = 2; i < number; i++) {
			for (int j = i + 1; j < number; j++) {
				if (bridge[i][j] != INF) {
					edges.add(new Edge(i, j, bridge[i][j]));
				}
			}
		}

		Collections.sort(edges);

		parent = new int[number];
		for (int i = 0; i < number; i++)
			parent[i] = i;

		int ans = 0;
		int cnt = 0;

		for (Edge e : edges) {
			if (union(e.from, e.to)) {
				ans += e.cost;
				cnt++;
			}
		}

		if (cnt != number - 3)
			System.out.println(-1);
		else
			System.out.println(ans);

	}

	static int[] parent;

	// find
	static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	
	//union
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b)
			return false;

		parent[b] = a;
		return true;
	} 

	static class Edge implements Comparable<Edge> {
		int from, to, cost;

		Edge(int f, int t, int c) {
			from = f;
			to = t;
			cost = c;
		}

		// 오름차순 정렬
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	/*
	 * 섬 찾기 로직
	 */
	private static void findIsland(int r, int c, int number) {
		Queue<int[]> q = new ArrayDeque<>();

		q.add(new int[] { r, c });

		// 넘버링을 통해 확인할 것이기 때문에 visited를 사용하지 않음
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int nowr = curr[0];
			int nowc = curr[1];

			for (int d = 0; d < 4; d++) {
				int nr = nowr + dr[d];
				int nc = nowc + dc[d];

				if (nr < 0 || nc < 0 || nr >= n || nc >= m || map[nr][nc] != 1) {
					continue;
				}
				map[nr][nc] = number;
				q.add(new int[] { nr, nc });
			}
		}
	}
}

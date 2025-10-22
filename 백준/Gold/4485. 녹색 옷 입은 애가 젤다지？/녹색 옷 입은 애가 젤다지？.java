import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {
	int r, c, cost;

	public Edge(int r, int c, int cost) {
		super();
		this.r = r;
		this.c = c;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.cost - o.cost;
	}
}

public class Main {
	static int N, M;
	static int[][] dist, map; // 거리
	static List<Edge>[][] graph;
	static boolean[][] visited;

	static int[] dr = new int[] { -1, 1, 0, 0 };
	static int[] dc = new int[] { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		// 백준
		// 4485. 녹색 옷 입은 애가 젤다지?

		// N x N 동굴의 0,0 에서 시작
		// 도둑루피(cost)의 비용만큼 소지금을 잃게 된다.
		// 한 번에 한 칸씩 이동 가능

		// 0,0 에서 N-1, N-1까지 이동해야할 때
		// 최소 비용을 구하여라
		int testCase = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) // 종료 조건
				break;

			sb.append("Problem ").append(testCase++).append(": ");

			graph = new ArrayList[N][N];
			// 2차원 그래프
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					graph[i][j] = new ArrayList<>();
				}
			}

			dist = new int[N][N];
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				Arrays.fill(dist[i], 987654321);
			}
			dist[0][0] = map[0][0];
			visited = new boolean[N][N];

			dijkstra();

			sb.append(dist[N - 1][N - 1]).append("\n");

		}
		System.out.println(sb.toString().trim());
	}

	private static void dijkstra() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		boolean[][] visited = new boolean[N][N];
		pq.add(new Edge(0, 0, dist[0][0]));

		while (!pq.isEmpty()) {
			Edge x = pq.poll();
			int r = x.r;
			int c = x.c;

			if (visited[r][c]) // 방문 여부 확인
				continue;

			visited[r][c] = true; // 방문 처리

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr < 0 || nc < 0 || nc >= N || nr >= N)
					continue;

				int next = dist[r][c] + map[nr][nc];
				if (dist[nr][nc] > next) {
					dist[nr][nc] = next;
					pq.add(new Edge(nr, nc, dist[nr][nc]));
				}

			}

		}
	}
}
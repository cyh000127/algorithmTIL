import java.io.*;
import java.util.*;

public class Main {

	// 전역 변수로 cnt를 다시 사용합니다.
	static int M, N, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 백준
		// 2583. 영역 구하기

		// N x M 지도에
		// 직사각형을 K개 뒀을때
		// 몇개의 면으로 나눠지는지 구하시오

		// 첫 째 줄 M, N ,K
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		for (int c = 0; c < K; c++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int i = y1; i < y2; i++) {
				for (int j = x1; j < x2; j++) {
					map[i][j] = 1;
				}
			}
		}

		visited = new boolean[M][N];
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] == 0) {

					cnt = 0;
					find(i, j);
					pq.add(cnt);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(pq.size()).append("\n");
		while (!pq.isEmpty()) {
			sb.append(pq.poll()).append(" ");
		}
		System.out.println(sb.toString().trim());
	}

	private static void find(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });
		visited[r][c] = true;

		cnt++;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int currR = curr[0];
			int currC = curr[1];

			for (int d = 0; d < 4; d++) {
				int nr = currR + dr[d];
				int nc = currC + dc[d];

				if (nr >= 0 && nc >= 0 && nr < M && nc < N && !visited[nr][nc] && map[nr][nc] == 0) {
					visited[nr][nc] = true;
					q.add(new int[] { nr, nc });
					cnt++;
				}
			}
		}
	}
}

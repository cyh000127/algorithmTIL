import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;

	// 상, 하, 좌, 우 탐색을 위한 델타 배열
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 백준
		// 2636. 치즈

		// 공기 ( 0 ) 과 맞닿은 면은 1시간뒤 녹아 없어진다.
		// 치즈가 모두 없어지려면 얼마나 걸리는지 계산해라
		// 그리고 치즈가 모두 녹기 한시간 전 의 남은 치즈도 계산하라
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					cnt++;
				}
			}
		}

		int time = 0;
		int lastCheeseCount = 0;

		// 치즈가 모두 녹을 때까지 반복
		while (cnt > 0) {
			time++;
			lastCheeseCount = cnt; // 녹기 전 치즈 개수를 저장

			// 외부 공기를 탐색하며 녹일 치즈를 찾고, 녹은 치즈의 수를 반환받음
			int meltedCount = melt();
			cnt -= meltedCount; // 남은 치즈 개수 업데이트
		}

		System.out.println(time);
		System.out.println(lastCheeseCount);
	}

	static int melt() {
		visited = new boolean[N][M];
		Queue<int[]> queue = new LinkedList<>();

		// (0,0)은 항상 외부 공기이므로 탐색 시작점으로 설정
		queue.offer(new int[] { 0, 0 });
		visited[0][0] = true;

		int meltedCount = 0;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int r = current[0];
			int c = current[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				// 1. 지도 범위를 벗어나거나 이미 방문한 곳이면 건너뜀
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) {
					continue;
				}

				visited[nr][nc] = true;
				if (map[nr][nc] == 0) {
					// 2. 인접한 곳이 공기(0)이면, 계속해서 외부 공기 탐색을 위해 큐에 추가
					queue.offer(new int[] { nr, nc });
				} else {
					// 3. 인접한 곳이 치즈(1)이면, 녹을 치즈이므로 공기(0)로 변경
					map[nr][nc] = 0;
					meltedCount++;
				}
			}
		}
		return meltedCount;
	}
}
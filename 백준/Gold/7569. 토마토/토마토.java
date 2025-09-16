import java.util.*;
import java.io.*;

public class Main {
	static int N, M, H, ans;
	static int[][][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 백준
		// 7569. 토마토

		// 위, 아래, 오른쪽,왼쪽, 앞, 뒤 여섯 방향의 토마토를 익힌다.
		// 상자의 크기 M, N 과 상자의 높이 H가 주어진다.
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로
		H = Integer.parseInt(st.nextToken()); // 높이

		arr = new int[H][N][M]; // 높이 , r, c 이게 순서적으로 괜찮을거같음

		Queue<int[]> q = new LinkedList<>();

		ans = -1; // 기본값 못찾았을때 -1 출력

		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < M; c++) {
					arr[h][r][c] = Integer.parseInt(st.nextToken());
					if (arr[h][r][c] == 1) {
						q.add(new int[] { r, c, h, 0 }); // 0은 시간
					}
				}
			}
		}

		// 1. 토마토가 1로 저장된 모든 구역을 찾는다?
		// 2. for문 돌려서 토마토 찾기
		// 3. bfs돌려서 토마토마토마토

		tomato(q);

		System.out.println(ans);
	}

	private static void tomato(Queue<int[]> q) {
		int[] dr = { -1, 1, 0, 0, 0, 0 }; // 앞 뒤
		int[] dc = { 0, 0, 1, -1, 0, 0 }; // 양 옆
		int[] dh = { 0, 0, 0, 0, 1, -1 }; // 상 하

		int days = 0;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			int h = curr[2];
			int cnt = curr[3];

			days = cnt;
			for (int d = 0; d < 6; d++) {
				int nr = dr[d] + r;
				int nc = dc[d] + c;
				int nh = dh[d] + h;

				if (nr >= 0 && nc >= 0 && nh >= 0 && nc < M && nr < N && nh < H && arr[nh][nr][nc] == 0) {
					arr[nh][nr][nc] = 1;
					q.add(new int[] { nr, nc, nh, cnt + 1 });

				}
			}
		}
		ans = days;
		
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (arr[h][r][c] == 0) {
						ans = -1;
					}
				}
			}
		}
	}

}
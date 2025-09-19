import java.io.*;
import java.util.*;

import javax.swing.text.AbstractDocument.BranchElement;

public class Main {

	static int[][] map;
	static int cnt, K, W, H;

	static int[][][] minMove;
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		K = Integer.parseInt(br.readLine()); // 말처럼 움직일 수 있는 횟수 K

		st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());// 가로 길이 W
		H = Integer.parseInt(st.nextToken());// 세로 길이 H

		// 1 장애물
		// 0 평지
		// 동작 수의 최솟값

		map = new int[H][W]; // 이동 횟수까지 생각
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[K + 1][H][W];
		minMove = new int[K + 1][H][W]; // minMove는 각 경로까지 도착할 수 있는 최소 경로를 의미함

		for (int i = 0; i <= K; i++) {
			for (int j = 0; j < H; j++) {
				for (int k = 0; k < W; k++) {
					minMove[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}

		bfs();
		// 디버그용
//		for(int i = 0;  i<= K; i++) {
//			System.out.println(" 현재 K 는 " + i);
//			for(int j = 0 ; j<H; j++) {
//				for(int k = 0 ; k<W; k++) {
//					System.out.print(minMove[i][j][k]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println("------------");
//		}
//		
		int ans = Integer.MAX_VALUE;

		for (int i = 0; i <= K; i++) {
			ans = Math.min(minMove[i][H - 1][W - 1], ans);
		}
		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else
			System.out.println(ans);
	}

	static int[] horseX = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] horseY = { -2, -1, 1, 2, 2, 1, -1, -2 };

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { 0, 0, 0, 0 });
		visited[0][0][0] = true;
		minMove[0][0][0] = 0;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			int k = curr[2];
			int moveCount = curr[3];

			// 말달리자
			if (k < K) {
				for (int d = 0; d < 8; d++) {
					int nr = horseX[d] + r;
					int nc = horseY[d] + c;

					if (nr >= 0 && nc >= 0 && nc < W && nr < H && !visited[k + 1][nr][nc] && map[nr][nc] == 0) {
						if (minMove[k + 1][nr][nc] < moveCount) {
							continue;// 가지치기 ?
						}
						visited[k + 1][nr][nc] = true;
						minMove[k + 1][nr][nc] = moveCount + 1;
						q.add(new int[] { nr, nc, k + 1, moveCount + 1 });
					}
				}
			}
			// 4방향 탐색
			for (int d = 0; d < 4; d++) {
				int nr = dr[d] + r;
				int nc = dc[d] + c;

				if (nr >= 0 && nc >= 0 && nc < W && nr < H && !visited[k][nr][nc] && map[nr][nc] == 0) {
					if (minMove[k][nr][nc] < moveCount) {
						continue;// 가지치기 ?
					}
					visited[k][nr][nc] = true;
					minMove[k][nr][nc] = moveCount + 1;
					q.add(new int[] { nr, nc, k, moveCount + 1 });
				}
			}

		}

	}
}
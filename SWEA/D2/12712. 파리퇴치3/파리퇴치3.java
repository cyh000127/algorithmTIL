import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// N은 지도 크기 // M 은 스프레이 범위
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			// 배열 선언 및 값 할당
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st2.nextToken());
				}
			}

			// 스프레이 델타배열 선언
			// +
			int[] dr = { -1, 1, 0, 0 };
			int[] dc = { 0, 0, -1, 1 };
			// x
			int[] drx = { -1, -1, 1, 1 };
			int[] dcx = { 1, -1, 1, -1 };

			int maxPlus = 0;
			// + 스프레이 최대 파리
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int cnt = arr[i][j];
					for (int d = 0; d < 4; d++) {
						for (int a = 1; a < M; a++) {
							int nr = i + (dr[d] * a);
							int nc = j + (dc[d] * a);

							if (nr >= N || nr < 0 || nc >= N || nc < 0)
								continue;
							cnt += arr[nr][nc];
						}
					}
					maxPlus = Math.max(maxPlus, cnt);
				}
			}

			int maxX = 0;
			// + 스프레이 최대 파리
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int cnt = arr[i][j];
					for (int d = 0; d < 4; d++) {
						for (int a = 1; a < M; a++) {
							int nr = i + (drx[d] * a);
							int nc = j + (dcx[d] * a);

							if (nr >= N || nr < 0 || nc >= N || nc < 0)
								continue;
							cnt += arr[nr][nc];
						}
					}
					maxX = Math.max(maxX, cnt);
				}
			}
			int ans = Math.max(maxPlus, maxX);
			System.out.println("#" + test + " " + ans);
		}
	}
}

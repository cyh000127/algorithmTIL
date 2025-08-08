import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스 지정
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 필드 크기 M //스프레이 크기 N
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			int[][] arr = new int[M][M];

			for (int i = 0; i < M; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(st2.nextToken());
				}
			}
			// + 모양,  자기 위치 포함
			int[] dc = { -1, 1, 0, 0};
			int[] dr = { 0, 0, 1, -1};

			// x 모양, 자기 위치 포함
			int[] drx = { -1, -1, 1, 1};
			int[] dcx = { -1, 1, -1, 1};

			// +로 최대로 잡을 수 있는 파리수 탐색
			int plusMax = 0;
			// 스프레이의 중심 기준
			for (int i = 0; i < M-1; i++) {
				for (int j = 0; j < M-1; j++) {
					int cnt = arr[i][j];
					// 방향 벡터 반복문
					for (int d = 0; d < 4; d++) {
						// 스프레이 크기 만큼을 곱하고 반복
						for (int n = 1; n < N; n++) {
							int nr = i + (dr[d] * n);
							int nc = j + (dc[d] * n);
							// 범위 벗언면 continue
							if (nr < 0 || nr >= M || nc < 0 || nc >= M)
								continue;
							cnt += arr[nr][nc];
						}
					}
					plusMax = Math.max(plusMax, cnt);
				}
			}
			// X로 최대로 잡을 수 있는 파리수 탐색
			int X_Max = 0;
			// 스프레이의 중심 기준
			for (int i = 0; i < M-1; i++) {
				for (int j = 0; j < M-1; j++) {
					int cnt = arr[i][j];
					// 방향 벡터 반복문
					for (int d = 0; d < 4; d++) {
						// 스프레이 크기 만큼을 곱하고 반복
						for (int n = 1; n < N; n++) {
							int nr = i + (drx[d] * n);
							int nc = j + (dcx[d] * n);
							// 범위 벗언면 continue
							if (nr < 0 || nr >= M || nc < 0 || nc >= M)
								continue;
							cnt += arr[nr][nc];
						}
					}
					X_Max = Math.max(X_Max, cnt);
				}
			}
			
		System.out.println("#"+test+" "+Math.max(X_Max, plusMax));	
		}
	}
}

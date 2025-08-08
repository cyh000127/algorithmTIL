import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		// 테스트 케이스
		for (int test = 1; test <= T; test++) {
			// 배열 크기 N
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];

			// 방향도 미리 선언
			int[] dr = { 1, 0, -1, 0 };
			int[] dc = { 0, 1, 0, -1 };

			// 배열에 값 할당
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 구석 제외 범위 1 ~ N-1
			// 계곡 찾기
			int cnt = 0;

			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < N - 1; j++) {
					boolean isTrue = true;

					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];

						if (arr[i][j] >= arr[nr][nc]) {
							isTrue = false;
							break;
						}
					}
					if (isTrue)
						cnt++;
				}
			}
			System.out.println("#"+test + " "+cnt);
		}
	}
}

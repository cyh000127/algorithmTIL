import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			// 지도 크기
			int N = Integer.parseInt(br.readLine());

			// 배열 선언 및 산 배치
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[] dr = { -1, 0, 1, 0 };
			int[] dc = { 0, 1, 0, -1 };

			int cnt = 0;
			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < N - 1; j++) {
					boolean isTrue = true;
					
					for (int c = 0; c < 4; c++) {
						int nr = i + dr[c];
						int nc = j + dc[c];

						if (arr[i][j] >= arr[nr][nc]) {
							isTrue = false;
							break;
						}
					}
					if(isTrue) cnt++;
				}

			}
			System.out.println("#"+test+" "+cnt);

		}
	}
}

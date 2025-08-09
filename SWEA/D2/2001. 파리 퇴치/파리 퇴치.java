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
			// M 은 지도 크기, N 은 파리채 크기
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			int[][] arr = new int[M][M];

			// 2차원 배열에 파리 넣기
			for (int i = 0; i < M; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(st2.nextToken());
				}
			}

			int maxCnt = 0 ;
			// 기존 배열에서 파리채 크기 만큼의 파리를 잡은 후
			// 가장 많은 파리를 잡은 마릿 수 출력
			for (int i = 0; i < M - N + 1; i++) {
				for (int j = 0; j < M - N + 1; j++) {
					int cnt = 0;
					for (int a = 0; a < N; a++) {
						for (int b = 0; b < N; b++) {
							cnt += arr[i + a][j + b];
						}
					}
					maxCnt = Math.max(maxCnt, cnt);
				}
			}

			System.out.println("#"+test+" "+maxCnt);
		}

	}
}

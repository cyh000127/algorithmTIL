import java.io.*;
import java.util.*;

public class Solution {
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			// 사람수
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken()); // 인접행렬을 입력으로 줌
					if (i != j && arr[i][j] == 0) {
						arr[i][j] = INF;
					}
				}
			}

			for (int k = 0; k < N; k++) {
				for (int from = 0; from < N; from++) {
					if (arr[from][k] == INF)
						continue;

					for (int to = 0; to < N; to++) {
						if (arr[k][to] == INF)
							continue;

						arr[from][to] = Math.min(arr[from][to], arr[from][k] + arr[k][to]);
					}
				}
			}
			// 음의 경로가 존재 하지 않기 때문에 negativeCycle은 발생하지 않음
			int ans = INF;
			for (int i = 0; i < N; i++) {
				int a = 0;
				for (int j = 0; j < N; j++) {
					a += arr[i][j];
				}
				ans = Math.min(a, ans);
			}
			System.out.println("#" + test + " " + ans);
		}
	}
}
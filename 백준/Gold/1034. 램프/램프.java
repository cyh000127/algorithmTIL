import java.io.*;
import java.util.*;

public class Main {
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();

		// 백준
		// 1034. 램프

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 1. 줄별로 켜지게 바꿔보기
		// 2. 같은 배열인걸 찾기
		// 3. 그 개수가 최대인걸 출력하기

		int[][] room = new int[N][M];
		int ans = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				room[i][j] = str.charAt(j) - '0';
			}
		}

		int k = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int zeroCount = 0;

			for (int j = 0; j < M; j++) {

				if (room[i][j] == 0)
					zeroCount++;
			}
			// 최대 수를 벗어나지 않고
			// 전구 키고 끌수 있는 남은횟수가 짝수여야 원상 복구를 할 수 있음
			if (zeroCount <= k && (k - zeroCount) % 2 == 0) {
				int a = isSame(room, i)+1; // 자기 자신도 더해줘야함 
				ans = Math.max(ans, a);

			}
		}
		System.out.println(ans);
	}

	private static int isSame(int[][] room, int t) {
		int cnt =0;
		for (int i = 0; i < N; i++) {
			boolean isTrue = true;

			
			if (i == t)
				continue;

			for (int j = 0; j < M; j++) {
				if (room[i][j] != room[t][j])
					isTrue = false;
			}

			if (isTrue) {
				cnt++;
			}

		}
		return cnt;
	}
}

import java.util.*;
import java.io.*;

/**
 * 1005 ACM craft
 */
public class Main {
	static int INF = 100_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 건물을 짓는 데에는 이전 테크를 모두 타야 건물을 지을 수 있음
		// 건물을 가장 빨리 지을 때의 최소 시간을 구하여라

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 건물의 개수
			int k = Integer.parseInt(st.nextToken()); // 건물 건설 순서 규칙 개수
			int w; // 승리하기 위해 지어야하는 건물 번호
			int[] time = new int[n]; // 각 건물이 지어지는 시간
			st = new StringTokenizer(br.readLine());

			// 건물 별 걸리는 시간
			for (int i = 0; i < n; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}

			// 얼마나 깊이 있는지 계산하는 degree
			int[] degree = new int[n];
			// 내가 선언한게 건물이 0부터 시작이기 때문에 -1
			List<List<Integer>> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				list.add(new ArrayList<>());
			}
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());

				int start = Integer.parseInt(st.nextToken()) - 1;
				int end = Integer.parseInt(st.nextToken()) - 1;
				list.get(start).add(end);
				// end를 짓기 위해 필요한 건물 개수를 정해두는 것
				degree[end]++;
			}
			w = Integer.parseInt(br.readLine()) - 1;

			// 가장 오래 걸리는 시간을 담을 배열 dp
			long[] dp = new long[n];
			for (int i = 0; i < n; i++) {
				dp[i] = time[i]; // 일단 default로 각 건물은 자기 자신의 시간을 가짐
			}

			ArrayDeque<Integer> q = new ArrayDeque<>();
			for (int i = 0; i < n; i++) {
				// degree 0 -> 시작 위치
				if (degree[i] == 0)
					q.add(i);
			}

			while (!q.isEmpty()) {
				int curr = q.poll();

				for (int x : list.get(curr)) {
					// 기존에 계산된 시간과 새로 계산한 시간중 최대값 저장
					dp[x] = Math.max(dp[x], dp[curr] + time[x]);

					// x의 선행조건이 하나 해결되었다는 의미
					degree[x]--;

					if (degree[x] == 0)
						// 새로운 건물 추가
						q.add(x);

				}
			}
			sb.append(dp[w]).append("\n");

		}
		System.out.println(sb.toString().trim());
	}

}
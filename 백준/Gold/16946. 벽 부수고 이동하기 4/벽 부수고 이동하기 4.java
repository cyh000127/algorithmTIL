import java.util.*;
import java.io.*;

/**
 * 벽 부수고 이동하기 4
 */
public class Main {
	static int n, m;
	static int[][] arr;
	static Map<Integer, Integer> hash;
	static int[][] find;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		hash = new HashMap<>();
//		find = new int[n][m];

		// 벽이 1이므로 2로 시작
		int cnt = 2;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 찾은 적 없고 arr의 값이 0이라면
				if (arr[i][j] == 0) {
					check(cnt++, i, j);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1) {
					int r = i;
					int c = j;
					int tmp = 1;

					// 중복 계산 방지
					Set<Integer> isUsed = new HashSet<>();

					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];

						if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
							continue;
						}

						int loc = arr[nr][nc];
						// set을 통해 검사 했던건지 검증
						if (loc >= 2 && !isUsed.contains(loc)) {
							// 옆에 1이 있다면 그것의 값은 null 일테니 getordefault
							tmp += hash.getOrDefault(loc, 0);
							isUsed.add(loc);
						}
					}
					sb.append(tmp % 10);
				} else {
					sb.append(0);
				}

				if (j == m - 1)
					sb.append("\n");
			}
		}

		System.out.println(sb.toString().trim());
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	// bfs 를 통한 check
	private static void check(int number, int r, int c) {
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { r, c });
		int cnt = 1;
		arr[r][c] = number;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int rr = curr[0];
			int cc = curr[1];

			for (int d = 0; d < 4; d++) {
				int nr = rr + dr[d];
				int nc = cc + dc[d];

				if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
					continue;
				}

				if (arr[nr][nc] == 0) {
					// 지도에 number를 넣어주기
					arr[nr][nc] = number;
					q.add(new int[] { nr, nc });
					cnt++;
				}
			}
		}
		// 마지막에 해시에 개수 넣기
		hash.put(number, cnt);
	}
}

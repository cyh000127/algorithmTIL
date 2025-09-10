import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] visited;
	static int ans, minSec;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 수빈이 위치
		M = Integer.parseInt(st.nextToken()); // 동생 위치
		visited = new int[100001];
		minSec = Integer.MAX_VALUE;
		ans = 0;

		Arrays.fill(visited, Integer.MAX_VALUE);
		if (N == M) {
			minSec = 0;
			ans = 1;
		} else
			bfs();

		System.out.println(minSec);
		System.out.println(ans);
	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { N, 0 });
		visited[N] = 0;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int nowloc = now[0];
			int sec = now[1];

			if (M == nowloc && minSec >= sec) {
				minSec = sec;
				ans++;
				continue;
			}

			int[] nextLocation = { nowloc - 1, nowloc + 1, nowloc * 2 };
			for (int nextLoc : nextLocation) {
				if (nextLoc >= 0 && nextLoc <= 100000 && visited[nextLoc] >= sec + 1) {
					visited[nextLoc] = sec+1;
					q.add(new int[] { nextLoc, sec + 1 });
				}
			}
//			if (nowloc - 1 >= 0 && visited[nowloc - 1] <= sec + 1) {
//				visited[nowloc - 1] = sec + 1;
//				q.add(new int[] { nowloc - 1, sec + 1 });
//			}
//			if (nowloc + 1 <= 100000 && visited[nowloc + 1] <= sec + 1) {
//				visited[nowloc + 1] = sec + 1;
//				q.add(new int[] { nowloc + 1, sec + 1 });
//			}
//			if (nowloc * 2 <= 100000 && visited[nowloc * 2] <= sec + 1) {
//				visited[nowloc * 2] = sec + 1;
//				q.add(new int[] { nowloc * 2, sec + 1 });
//			}

		}

	}
}
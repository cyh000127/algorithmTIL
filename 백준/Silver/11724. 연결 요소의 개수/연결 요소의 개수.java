import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static boolean[] visited;
	static int[][] node;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수

		visited = new boolean[N + 1];
		node = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			node[a][b] = 1;
			node[b][a] = 1; // 방향 없음
		}

		int cnt = 0;
		// 방문한 적 없는 정점을 만나면 cnt를 하나 올리고 관련된 모든 정점을 visited 처리 해줌
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				bfs(i);
				cnt++;
			} 
		}
		System.out.println(cnt);
	}

	private static void bfs(int x) {
		// bfs를 위한 q선언
		Queue<Integer> q = new LinkedList<>();

		q.add(x);
		visited[x] = true;

		while (!q.isEmpty()) {
			int curr = q.poll();

			for (int i = 1; i <= N; i++) {
				if (node[curr][i] == 1 && !visited[i]) {
					bfs(i);
				}
			}
		}
	}
}
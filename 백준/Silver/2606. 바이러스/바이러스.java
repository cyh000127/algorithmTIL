import java.util.*;
import java.io.*;

public class Main {
	static int[][] node;
	static int N, M;
	static boolean[] visited;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		// 1 - 이동할 수 있는 칸
		// 0 - 이동할 수 없는 칸
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 1번 컴퓨터가 바이러스에 걸렸음
		// 1번과 결과적으로 연결된 모든 애들을 찾으셈
		// 전체 컴퓨터 수 N
		// 노드 수 M
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		// 연결된 노드들저장할 배열
		node = new int[N + 1][N + 1];
		cnt = 0 ; // 정답 cnt;
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			node[a][b] = 1;
			node[b][a] = 1;
		}

		visited = new boolean[N + 1];

		dfs(1);
		System.out.println(cnt);

	}

	private static void dfs(int a) {
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { a, 0 });
		visited[a] = true;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int com = curr[0];
			int dis = curr[1];

			for (int i = 1; i <= N; i++) {
				if (node[com][i] == 1 && !visited[i]) {
					q.add(new int[] { i, dis + 1 });
					visited[i] = true;
					cnt++;
				}
			}

		}

	}
}

import java.util.*;
import java.io.*;

public class Main {
	static int N, start, end, ans;
	static int[][] adj;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 백준
		// 2644. 촌수계산

		// 입력
		// 사람의 수 n
		// 촌수 계산해야하는 번호 ( 시작노드, 끝노드 )
		// 간선 개수 m
		// 간선

		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		int v = Integer.parseInt(br.readLine());

		adj = new int[N + 1][N + 1];

		for (int i = 0; i < v; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			// 관계도 설정
			adj[from][to] = 1;
			adj[to][from] = 1;
		}
		visited = new boolean[N + 1];
		visited[start] = true;
		ans = Integer.MAX_VALUE;
		dfs(start, end, 0);
		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else
			System.out.println(ans);
	}

	private static void dfs(int s, int e, int cnt) {
		if (s == e) { // 종료 조건
			ans = Math.min(ans, cnt);
			return;
		}
		// 재귀(dfs)를 통한 촌수 찾기
		for (int to = 1; to < N + 1; to++) {
			if (!visited[to] && adj[s][to] == 1) {
				visited[to] = true;
				dfs(to, e, cnt + 1);
				visited[to] = false;
			}
		}

	}
}

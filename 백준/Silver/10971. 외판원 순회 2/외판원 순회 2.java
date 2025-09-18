import java.io.*;
import java.util.*;

public class Main {
    // N: 도시의 수, W: 비용 행렬
	static int N;
	static int[][] W;
	static boolean[] visited;
	static int minCost; // 최소 비용을 저장할 변수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		W = new int[N][N];
        visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		minCost = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			visited[i] = true; 
			dfs(i, i, 0, 1);
			visited[i] = false;
		}
		System.out.println(minCost);
	}

	private static void dfs(int start, int now, int cost, int depth) {
		if (depth == N) {
			if (W[now][start] != 0) {
				minCost = Math.min(minCost, cost + W[now][start]);
			}
			return; // 탐색 종료
		}
        
        if (cost >= minCost) {
            return;
        }

		// 3. 다음 도시 탐색 (재귀 호출)
		for (int next = 0; next < N; next++) {
			// 아직 방문하지 않았고, 현재 도시(now)에서 다음 도시(next)로 가는 길이 있는 경우
			if (!visited[next] && W[now][next] != 0) {
				visited[next] = true; 
				dfs(start, next, cost + W[now][next], depth + 1);
				visited[next] = false; 
			}
		}
	}
}
import java.io.*;
import java.util.*;

public class Main {
	static int N, M, V;
	static boolean[] visited;
	static List<Integer>[] adjList; // 인접 리스트
	static Queue<Integer> q;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 그래프를 DFS로 탐색한 결과 + BFS 탐색 결과를 출력하는 프로그램을 작성
		// 길이 여러개 -> 수 낮은거 먼저 방문
		// 정점의 개수 N
		// 간선의 개수 M
		// 시작 정점 V

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1];

		adjList = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) { // 0번 인덱스도 초기화 (ArrayIndexOutOfBounds 방지)
			adjList[i] = new ArrayList<>();
		}

		// 간선은 양방향
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adjList[a].add(b);
			adjList[b].add(a);
		}


		// 번호가 낮은애들 먼저 방문할 수 있게 정렬
		for (int i = 1; i <= N; i++) {
			Collections.sort(adjList[i]);
		}

		dfs(V);
		System.out.println(sb.toString().trim());
		sb.setLength(0);
		// 방문 배열 초기화
		visited = new boolean[N + 1];
		bfs(V);
		System.out.println(sb.toString().trim());
	}

	private static void dfs(int start) {
		visited[start] = true; // 방문 처리
		sb.append(start).append(" ");

		// 인접 행렬 대신 정렬된 인접 리스트를 사용하고, 방문하지 않은 노드만 재귀 호출합니다.
		for (int nextNode : adjList[start]) {
			if (!visited[nextNode]) {
				dfs(nextNode);
			}
		}
	}

	private static void bfs(int v) {
		q = new LinkedList<>();

		q.add(v);
		visited[v] = true;

		while (!q.isEmpty()) {
			int curr = q.poll();
			sb.append(curr).append(" ");
			
			// 탐색
			for (int w : adjList[curr]) {
				if (!visited[w]) {
					q.add(w);
					visited[w] = true;
				}
			}
		}
	}
}
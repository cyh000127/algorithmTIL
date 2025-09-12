import java.io.*;
import java.util.*;

public class Main {
	static int[] dr = { -1, 1, 0, 0 }; // 상 , 하 , 좌 , 우
	static int[] dc = { 0, 0, -1, 1 }; // 상 , 하 , 좌 , 우
	static int[][] visited;
	static int N, M, cnt;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();

		// U, D, L ,R -> 위, 아래, 좌, 우
		// 성우가 피리를 불면 사람들은 위 네가지 설정중 하나로 이동함
		// SAFE ZONE 이라는 방음 시설을 만들어 피리 소리 못듣게 하려 함
		// 무한 뺑뺑이를 돌지 않게 하기 위해 Safe zone을 만들어줘야함
		// -> 이건 사이클이 몇개 나오는지 탐색하라는 문제 같은데

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cnt = 0;
		arr = new int[N][M]; // 이 배열에는 상하좌우 dr,dc에 해당하는 idx가 들어갈것이다.
		visited = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = str.charAt(j);
				int direction = 0; // U 의 idx 0 -> 기본값
				if (c == 'D')
					direction = 1;
				else if (c == 'L')
					direction = 2;
				else if (c == 'R')
					direction = 3;
				arr[i][j] = direction;
				visited[i][j] = 0; // 방문배열 0 으로 초기화 // 사실 안해도 됨
			}
		}
		// 디버그용 코드
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}

		
		//bfs를 사용하면 rrrrllll에서 여러개의 정답이 나오기 때문에 dfs를 이용해준다. 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] == 0)
					dfs(i, j);
			}
		}
		System.out.println(cnt);

	}

	private static void dfs(int r, int c) {
		visited[r][c] = 1;
		// 방문하지 않은 장소의 i,j값을 q에 삽입
		int nr = r + dr[arr[r][c]];
		int nc = c + dc[arr[r][c]];
		// 지도 밖으로 나가는 경우의 수는 존재하지 않음
		if (visited[nr][nc] == 1) { // 1을 만난다면 -> 순회한다면 -> cnt++
			cnt++;
		} else if (visited[nr][nc] == 0) { // 0 이라면 계속 dfs 
			dfs(nr, nc);
		}
		visited[r][c] = 2; // 검사가 끝났다면 다시 사용할 수 없게 2로 박아둠

	}
}

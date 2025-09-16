import java.util.*;
import java.io.*;

public class Main {

	static int[] arr;
	static int N, cnt, teamPeople;
	static boolean[] visited;
	static boolean[] finished;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 백준
		// 9466. 텀 프로젝트

		// 프로젝트를 같이하고 싶은 한사람을 골랐음
		// 팀원수에는 제한이 없고
		// 자기 자신을 고르면 혼자할 수도 있음
		// 몇 팀이 나온지 / 팀을 이루지 못한건 몇명인지 찾으셈

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			cnt = 0;
			visited = new boolean[N + 1];
			finished = new boolean[N + 1];
			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					dfs(i);
				}
			}
			sb.append(N - cnt).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int idx) {
		visited[idx] = true; // 방문 처리
		int next = arr[idx]; // 같이 팀이 되고 싶은 친구

		if (!visited[next]) {
			// 팀 배정이 아직 안된 친구면 dfs(next);
			dfs(next);
		} else {
			if (!finished[next]) {
				cnt++; // 자기 자신부터 시작
				for (int i = next; i != idx; i = arr[i]) { // arr이 순환하는 동안 팀원 추가
					cnt++;
				}
			}
		}
		// 현재 학생은 탐색이 끝났다
		finished[idx] = true;
	}
}
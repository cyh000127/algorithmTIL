import java.io.*;
import java.util.*;

public class Main {
	static int min = Integer.MAX_VALUE;
	static int N;
	static int[][] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// N은 짝수
		// N/2 : N/2 로 축구대결할거임
		// 2차원 배열에 능력치가 주어지고
		// 팀이되면 해당 배열 위치의 모든 스탯을 더한다.
		// 각 팀의 스탯차이 최소치를 구하셈

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited[0] = true; // 1번 선수를 미리 뽑은 상태로 시작
		team(1, 1); // 2번선수부터 검색 

		System.out.println(min);
	}
	// 2명팀 = 2개
	// 3명팀 = 6개 ar+ (N/2-1)*2
	// 4명팀 = 12개
	// 5명팀 = 20개

	private static void team(int index, int member) {
		// 팀원이 N/2명이 되면 calDiff를 통해 차이를 구해라
		if (member == N / 2) {
			calDiff();
			return;
		}

		// 팀원 선택 과정
		for (int i = index; i < N; i++) {
			// 아직 팀에 합류하지 않았다면
			if (!visited[i]) {
				// visited가 true라면 start 팀
				// false 라면 link 팀이 됨
				visited[i] = true; // 팀에 포함시킨다.
				team(i + 1, member + 1); // 다음 팀원을 뽑으러간다.
				visited[i] = false; // 다른 팀원을 뽑으러 간다.
			}

		}

	}

	private static void calDiff() {
		int startteam = 0;
		int linkteam = 0;

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				// i번쨰 선수와 j번째 선수가 둘 다 스타트팀
				if (visited[i] && visited[j]) {
					startteam += arr[i][j];
					startteam += arr[j][i];
				} else if (!visited[i] && !visited[j]) {
					linkteam += arr[i][j];
					linkteam += arr[j][i];
				}
			}
		}
		// 절대값 차이를 구하고
		int diff = Math.abs(linkteam - startteam);

		if (diff == 0) {
			System.out.println(0);
			System.exit(0);
		}
		// 최소값 계산
		min = Math.min(diff, min);
	}

}
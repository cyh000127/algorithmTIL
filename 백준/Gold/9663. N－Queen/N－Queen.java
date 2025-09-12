import java.io.*;
import java.util.*;

public class Main {

	static int N, cnt; // 체스판 크기
	static boolean[] dntkd, dngk, visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cnt = 0;
		// N -queen 문제
		// N개의 queen을 N*N 체스판에 서로 공격하지 않게 만들기

		dntkd = new boolean[2 * N - 1]; // 우상,
		dngk = new boolean[2 * N - 1]; // 좌하,
		visited = new boolean[N]; // 세로 검사

		findQueen(0);

		System.out.println(cnt);

	}

	private static void findQueen(int x) {
		if (x == N) { // 시행 차수가 N-1 까지 간다면 모든 퀸을 배치한거임
			cnt++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i] || dntkd[i + x] || dngk[x - i + N - 1]) {
				continue;
			}
			// 모든 퀸 공격범위를 true로 만들기
			visited[i] = true;
			dntkd[i + x] = true;
			dngk[x - i + N - 1] = true;
			// 다음 퀸 두기
			findQueen(x + 1);
			// 퀸 다시 빼기 (백트래킹)
			visited[i] = false;
			dntkd[i + x] = false;
			dngk[x - i + N - 1] = false;

		}
	}
}

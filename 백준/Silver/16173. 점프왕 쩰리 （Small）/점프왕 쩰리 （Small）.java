import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] arr;
	static boolean can;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 정 사각형 내부에서만 이동 가능 // 밖으로 나가면 탈락
		// 항상 0,0에서 시작 ( 왼쪽 위 )
		// 오른쪽, 아래로만 이동 가능
		// 가장 우, 하 (N,N) 도착 시 게임 종료
		// 지금 밟고 있는 칸의 수 만큼만 이동 가능 (더도 말고 덜도 말고)
		// 구역의 크기 2~3이 주어짐
		// 갈 수 있으면 HaruHaru
		// 갈 수 없으면 Hing 출력
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		can = false;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		findRoot(0, 0);
		if (can)
			System.out.println("HaruHaru");
		else
			System.out.println("Hing");
	}

	private static void findRoot(int r, int c) {
		if (visited[r][c])
			return;
		if (arr[r][c] == -1) {
			can = true;
			return;
		}
		if (arr[r][c] > N) {
			return;
		}

		int moveCount = arr[r][c];
		visited[r][c] = true;

		if (moveCount + r < N) {
			findRoot(moveCount + r, c);
		}
		if (moveCount + c < N) {
			findRoot(r, c + moveCount);
		}

	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 위, 오른쪽, 아래, 왼쪽
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 가로로 C (x)
		// 세로로 R (y)
		// C x R 격자형 자리가 있음
		// (0,0) 시작이 아닌 (1,1) 시작임에 유의

		// 달팽이 문제
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		// 2차원 배열은 y,x 임
		int[][] arr = new int[R][C];

		// 시작 지점 코드상에서는 R , 0 에서 시작함
		int nowY = R;
		int nowX = 0;

		int d = 0;
		for (int i = 1; i <= C * R; i++) {

			int nr = nowY + dr[d];
			int nc = nowX + dc[d];

			if (nr < 0 || nr >= R || nc < 0 || nc >= C || arr[nr][nc] != 0) {
				d++;
				d = d % 4;
				nr = nowY + dr[d];
				nc = nowX + dc[d];

			}

			arr[nr][nc] = i;
			nowY = nr;
			nowX = nc;
		}
//			디버그용 코드
//				for (int i = 0; i < R; i++) {
//
//			for (int j = 0; j < C; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
		int target = Integer.parseInt(br.readLine());
		int ansy = 0;
		int ansx = 0;
		for (int y = 0; y < R; y++) {
			boolean isfound = false;
			for (int x = 0; x < C; x++) {
				if (arr[y][x] == target) {
					ansy = R - y;
					ansx = x + 1;
					isfound = true;
					break;
				}
			}
			if (isfound)
				break;
		}
		if (ansy == 0)
			System.out.println(0);
		else
			System.out.println(ansx + " " + ansy);
	}
}

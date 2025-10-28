import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] map;
	static int[] Rloc = new int[2];
	static int[] Bloc = new int[2];
	static int[] Oloc = new int[2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 백준
		// 13460 구슬 탈출 2

		// 세로 N
		// 가로 M

		// 문자열
		// . 빈칸
		// # 장애물
		// o 구멍
		// R 빨간 구슬 위치
		// B 파란 구슬의 위치

		// 파란구슬이 먼저 빠지거나 동시에 빠지면 실패
		// 오른쪽 왼쪽, 위 아래로 기울일 수 있음 = 모든 공이 한번에 움직임

		// 10번 안에 빼낼 수 있으면 그걸 출력
		// 불가능 시 -1

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		// -1 벽
		// 0 길
		// 1 구멍
		// 2 ,3 파, 빨강 구슬

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				char a = str.charAt(j);
				if (a == '#')
					map[i][j] = -1;
				else if (a == '.')
					map[i][j] = 0;
				else if (a == 'O') {
					map[i][j] = 1;
					Oloc[0] = i;
					Oloc[1] = j;
				} else if (a == 'R') {
					map[i][j] = 2;
					Rloc[0] = i;
					Rloc[1] = j;
				} else {
					map[i][j] = 3;
					Bloc[0] = i;
					Bloc[1] = j;

				}
			}
		}
		// 굴러다닐 수 있게 맨 땅으로 바꿔주기
		map[Rloc[0]][Rloc[1]] = 0; // 빨간 구슬 위치를 빈칸으로
		map[Bloc[0]][Bloc[1]] = 0; // 파란 구슬 위치를 빈칸으로

		visited = new boolean[N][M][N][M];
		int ans = findExit();
		System.out.println(ans);
	}

	static boolean[][][][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	private static int findExit() {
		Queue<int[]> q = new ArrayDeque<>();

		// Rr Rc Br Bc 이동횟수
		q.add(new int[] { Rloc[0], Rloc[1], Bloc[0], Bloc[1], 0 });
		visited[Rloc[0]][Rloc[1]][Bloc[0]][Bloc[1]] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			int Rr = curr[0];
			int Rc = curr[1];
			int Br = curr[2];
			int Bc = curr[3];
			int moveCnt = curr[4];

			if (moveCnt > 10) // 10번이 넘어간다면 일단 무시함
				continue;

			// 이전에 굴린방향을 저장해서 한번 더 실행할 일이 없게 만들기

			for (int d = 0; d < 4; d++) {
				int nRr = Rr;
				int nRc = Rc;
				int nBr = Br;
				int nBc = Bc;

				boolean R_inHole = false;
				boolean B_inHole = false;

				// 같은 방향 같은 위치로 굴러갈 때
				// 이동거리가 더 긴 쪽을 뒤의 좌표로 보내기 위해 이동거리 세기
				int rDist = 0; // r 이동거리
				int bDist = 0; // b 이동거리

				// 1. 빨간 구슬 굴리기
				// 다음 칸이 벽(-1)이 아니고, 현재 칸이 구멍(1)이 아닌 동안 계속 굴림
				while (map[nRr + dr[d]][nRc + dc[d]] != -1 && map[nRr][nRc] != 1) {
					nRr += dr[d];
					nRc += dc[d];
					rDist++;
					if (map[nRr][nRc] == 1) {
						R_inHole = true;
						break;
					}
				}

				// 2. 파란 구슬 굴리기
				while (map[nBr + dr[d]][nBc + dc[d]] != -1 && map[nBr][nBc] != 1) {
					nBr += dr[d];
					nBc += dc[d];
					bDist++;
					if (map[nBr][nBc] == 1) {
						B_inHole = true;
						break;
					}
				}

				// 파란 공이 구멍에 빠지는 순간 실패
				if (B_inHole)
					continue;

				// 파란공이 들어가지 않고 빨간공이 들어갔다면 성공
				if (R_inHole) {
					if (moveCnt <= 9)
						return moveCnt + 1;
				}

				// 두 구슬이 겹친 경우
				if (nRr == nBr && nRc == nBc) {
					// 더 많이 움직인 구슬 (더 뒤에 있던 구슬)을 한 칸 뒤로 민다.
					if (rDist > bDist) { // 빨간 구슬이 더 많이 움직였으면 (뒤에 있었으면)
						nRr -= dr[d];
						nRc -= dc[d];
					} else { // 파란 구슬이 더 많이 움직였으면 (뒤에 있었으면)
						nBr -= dr[d];
						nBc -= dc[d];
					}
				}

				if (!visited[nRr][nRc][nBr][nBc]) {
					visited[nRr][nRc][nBr][nBc] = true;
					q.add(new int[] { nRr, nRc, nBr, nBc, moveCnt + 1 });
				}
			}
		}
		return -1;
	}
}

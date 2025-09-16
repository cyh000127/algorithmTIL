import java.io.*;
import java.util.*;

public class Solution {
	// 0상 1우 2하 3좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 }; // 상 , 우 , 하, 좌 시계방향
	static int N, cnt;
	static char[][] map;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(br.readLine());// 필드 크기 N
			sb.append("#").append(test).append(" ");
			// 차윤이의 RC카 문제
			// N x N의 필드
			// G = 이동 가능한 땅
			// T = 나무
			// X = 현재 위치
			// Y = 도착 지점

			// RC카의 행동 지침
			// A = 앞으로 이동 ( 나무에 박거나 맵 밖으로 나가면 그 커맨드는 씹힘 )
			// L = 왼쪽으로 회전
			// R = 오른쪽으로 회전

			// 시작은 위를 바라봄
			// RC카 커맨드가 주어졌을 때 목적지에 도달할 수 있는지 구하샘

			// 출력 커맨드별 성공 실패를 출력
			map = new char[N][N];
			int[] start = null;
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == 'X') {
						start = new int[] { i, j };
					}
				}
			}
			// 커맨드
			int Q = Integer.parseInt(br.readLine());
			cnt = 0;
			while (Q-- > 0) { // 커맨드 별
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				String b = st.nextToken();

				Queue<Character> q = new LinkedList<>();

				for (int i = 0; i < a; i++) {
					q.add(b.charAt(i));
				}

				GOGOGO(q, start[0], start[1], 0);
			}
			sb.append("\n");

		}
		System.out.println(sb.toString().trim());
		br.close();
	}

	// 이동 명령 배열 arr 현재 위치(r, c) 값 + 방향
	private static void GOGOGO(Queue<Character> q, int x, int y, int dir) {
		int r = x;
		int c = y;
		int d = dir;

		while (!q.isEmpty()) {
			char m = q.poll(); // q.poll 해서 당장 해야 할 미션을 확인하자
			// 0상 1우 2하 3좌
			if (m == 'R') {
				d = (d + 1) % 4; // 4가 되면 다시 앞을 보기 떄문에 4로 나눠줌
			} else if (m == 'L') {
				d = (d + 3) % 4; // +3을 해주면 왼쪽으로 꺾기
			} else { // 남는건 직진 로직
				int nr = r + dr[d];
				int nc = c + dc[d];

				// 1. 지도 밖으로 나가거나 나무가 있을 때는 명령을 실행하지 않음
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 'T') {
					continue;
				}

				// 2. 앞으로 이동
				else {
					r = nr;
					c = nc;
				}
			}
		}
		// while문이 종료 되었을 때 종료 위치 ( 'Y'에 도착해 있는 상태인지 확인 )
//		System.out.println("종료 위치 " + r + " " + c + " " + map[r][c]);
		if (map[r][c] == 'Y') {
			sb.append(1).append(" ");
		} else
			sb.append(0).append(" ");

	}
}
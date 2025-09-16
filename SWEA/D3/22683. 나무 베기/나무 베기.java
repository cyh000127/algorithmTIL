import java.io.*;
import java.util.*;

public class Solution {
	// 0상 1우 2하 3좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 }; // 상 , 우 , 하, 좌 시계방향

	static class state implements Comparable<state> {
		int r, c, dir, cut, totalCost;

		public state(int r, int c, int dir, int cut, int totalCost) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.cut = cut;
			this.totalCost = totalCost;
		}

		@Override
		public int compareTo(state o) { // totalCost를 기준으로 오름차순
			return this.totalCost - o.totalCost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());// 필드 크기 N
			int M = Integer.parseInt(st.nextToken());// 아빠가 나무를 벨 수 있는 횟수

			// RC카 문제
			// RC카를 움직이기 위해 나무를 벤다
			// N x N 의 지도가 주어짐
			// 아빠는 나무를 최대 M회 벨 수 있음

			// G 이동 가능 땅
			// T 이동 불가 나무
			// X 시작지점
			// Y 도착지

			// 리모컨은 한번에 하나의 조작만이 가능하다
			// 방향조절에 1조작
			// 이동에 1조작
			// 최소 리모콘 조작을 구하여라
			char[][] map = new char[N][N];
			int[] start = null; // 시작 지점 저장

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					char c = str.charAt(j); //
					map[i][j] = c;
					if (c == 'X') {
						start = new int[] { i, j };
					}
				}
			}
			// G 이동 가능 땅
			// T 이동 불가 나무
			// X 시작지점
			// Y 도착지
			int[][][] cost = new int[N][N][M + 1]; // 각 지역까지 갈 수 있는 최소 비용을 저장
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					Arrays.fill(cost[i][j], Integer.MAX_VALUE); // 모두 최대 비용으로 바꿔두고
				}
			}
			// 최소 거리가 아닌 리모콘 최소 조작을 찾아야하기 때문에
			// bfs가 아닌 dfs 사용을 해서 풀긴했지만
			// 역시 bfs가 좋은거같음 괜히 했다.
			// bfs로 풀어보자
			int cnt = -1;
			PriorityQueue<state> pq = new PriorityQueue<>();

			pq.add(new state(start[0], start[1], 0, 0, 0));
			cost[start[0]][start[1]][0] = 0;

			while (!pq.isEmpty()) {
				state c = pq.poll();

				if (c.totalCost > cost[c.r][c.c][c.cut])
					continue; // 현재 경로의 비용이 이미 기록된 최소보다 낮다면 continue;

				if (map[c.r][c.c] == 'Y') {
					cnt = c.totalCost;
					break;
				}

				// 1. 방향 전환 탐색 (4방향)
				for (int d = 0; d < 4; d++) { // d는 이번에 이동할 목표 방향
					// 방향 전환 비용 계산
					int turnCost = 0;
					if (c.dir != d) { // 현재 방향과 다를 경우에만 비용 발생
						turnCost = (Math.abs(c.dir - d) == 2) ? 2 : 1;
					}

					// 다음 위치 및 총 비용 계산 (직진 비용 1 포함)
					int newTotalCost = c.totalCost + turnCost + 1;
					int nr = c.r + dr[d];
					int nc = c.c + dc[d];

					// 맵 범위 확인
					if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
						// 나무가 아닌 곳으로 이동
						if (map[nr][nc] != 'T') {
							if (newTotalCost < cost[nr][nc][c.cut]) {
								cost[nr][nc][c.cut] = newTotalCost;
								pq.add(new state(nr, nc, d, c.cut, newTotalCost));
							}
						}
						// 나무를 만났을 때
						else if (c.cut < M) { // 아직 더 자를 수 있다면
							if (newTotalCost < cost[nr][nc][c.cut + 1]) {
								cost[nr][nc][c.cut + 1] = newTotalCost;
								pq.add(new state(nr, nc, d, c.cut + 1, newTotalCost));
							}
						}
					}
				}
			}
			System.out.println("#" + test + " " + cnt);
		}
	}
}
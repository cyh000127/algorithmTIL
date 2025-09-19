import java.io.*;
import java.util.*;

public class Main {

    static int M, N;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dr = {0, 0, 0, 1, -1}; // 0, 동, 서, 남, 북 (문제의 1,2,3,4와 인덱스 일치)
    static int[] dc = {0, 1, -1, 0, 0};

    // 상태를 저장할 Robot 클래스
    static class Robot {
        int r, c, dir, cost;

        public Robot(int r, int c, int dir, int cost) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

		// 백준
		// 1726. 로봇

		// 명령 1. Go k : 1<= k <=3 - 현재 방향으로 k만큼 이동
		// 명령 2. Turn dir : dir = left or right

		// 로봇의 현재 위치 + 바라보는 방향이 주어졌을때
		// 목적지에 도착하는 최소 명령 수를 구하여라
        
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M + 1][N + 1];
        visited = new boolean[M + 1][N + 1][5]; // [행][열][방향] 3차원 방문 배열

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        Robot start = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

        st = new StringTokenizer(br.readLine());
        Robot end = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

        System.out.println(bfs(start, end));
    }

    private static int bfs(Robot start, Robot end) {
        Queue<Robot> q = new LinkedList<>();
        q.add(start);
        visited[start.r][start.c][start.dir] = true;

        while (!q.isEmpty()) {
            Robot curr = q.poll();

            // 목표 지점에 목표 방향으로 도착했다면 종료
            if (curr.r == end.r && curr.c == end.c && curr.dir == end.dir) {
                return curr.cost;
            }

            // --- 행동 1: Go k (현재 방향으로 1~3칸 이동) ---
            for (int k = 1; k <= 3; k++) {
                int nr = curr.r + dr[curr.dir] * k;
                int nc = curr.c + dc[curr.dir] * k;

                // 맵 범위를 벗어나거나, 이미 방문한 상태면 스킵
                if (nr <= 0 || nc <= 0 || nr > M || nc > N) break; // 경로가 맵을 벗어나면 더이상 진행 불가
                if (map[nr][nc] == 1) break; // 경로에 장애물이 있으면 더이상 진행 불가
                
                if (!visited[nr][nc][curr.dir]) {
                    visited[nr][nc][curr.dir] = true;
                    q.add(new Robot(nr, nc, curr.dir, curr.cost + 1));
                }
            }

            // --- 행동 2: Turn (방향 전환) ---
            for (int d = 1; d <= 4; d++) {
                // 현재 방향과 같으면 회전이 아니므로 스킵
                if (curr.dir == d) continue;
                
                // 이미 방문한 상태면 스킵
                if (visited[curr.r][curr.c][d]) continue;

                // 회전에 필요한 명령 횟수 계산
                int turnCost = 1; // 기본 90도 회전
                if ((curr.dir == 1 && d == 2) || (curr.dir == 2 && d == 1) ||
                    (curr.dir == 3 && d == 4) || (curr.dir == 4 && d == 3)) {
                    turnCost = 2; // 180도 회전 (U턴)
                }

                visited[curr.r][curr.c][d] = true;
                q.add(new Robot(curr.r, curr.c, d, curr.cost + turnCost));
            }
        }
        return -1; // 도달 불가
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static int[] dr = { 1, -1, 0, 0 }; // 상하
    static int[] dc = { 0, 0, -1, 1 }; // 좌우

    static int M, N;
    static int[][] arr;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                // 기존에 익어있는 토마토를 큐에 추
                if (arr[i][j] == 1) {
                    q.add(new int[] { i, j, 0 }); // {행, 열, 날짜}
                }
            }
        }

        int maxDays = 0;
        // BFS 시작
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int r = current[0];
            int c = current[1];
            int days = current[2];

            // 현재 날짜의 최댓값을 계속 갱신
            maxDays = Math.max(maxDays, days);

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                // 범위 체크 및 익지 않은 토마토인지 확인
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && arr[nr][nc] == 0) {
                    arr[nr][nc] = 1; // 토마토를 익게 함 (visited)
                    q.add(new int[] { nr, nc, days + 1 });
                }
            }
        }

        // BFS 종료 후, 모든 토마토가 익었는지 최종 확인
        if (checkTomato()) {
            System.out.println(maxDays);
        } else {
            System.out.println(-1);
        }
    }

    // 모든 토마토가 익었는지 확인하는 함수
    private static boolean checkTomato() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 익지 않은 토마토(0)가 하나라도 있으면 false 반환
                if (arr[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
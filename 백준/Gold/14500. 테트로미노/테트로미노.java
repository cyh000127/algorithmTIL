import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int maxNum = 0;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 1. DFS로 'ㅗ' 모양을 제외한 나머지 모양 탐색
                visited[i][j] = true;
                dfs(i, j, arr[i][j], 1);
                visited[i][j] = false;

                // 2. 'ㅗ' 모양은 별도 함수로 탐색
                checkTShape(i, j);
            }
        }
        System.out.println(maxNum);
    }

    // 'ㅗ' 모양을 제외한 나머지 테트로미노 탐색
    private static void dfs(int row, int col, int sum, int count) {
        if (count == 4) {
            maxNum = Math.max(maxNum, sum);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = row + dr[d];
            int nc = col + dc[d];

            if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
                visited[nr][nc] = true;
                dfs(nr, nc, sum + arr[nr][nc], count + 1);
                visited[nr][nc] = false;
            }
        }
    }

    // 'ㅗ', 'ㅜ', 'ㅏ', 'ㅓ' 모양 탐색
    private static void checkTShape(int r, int c) {
        // 'ㅗ' 모양들: 날개 3개와 몸통 1개로 구성
        int[][] wings = {{0, 1, 0, -1}, {-1, 0, 1, 0}, {0, -1, 0, 1}, {1, 0, -1, 0}}; // ㅏ, ㅜ, ㅓ, ㅗ 순서
        
        for (int i = 0; i < 4; i++) {
            int sum = arr[r][c];
            boolean isPossible = true;
            for (int j = 0; j < 3; j++) {
                int nr = r + wings[i][j];
                int nc = c + wings[i][j+1];
                // 날개 3개 중 하나라도 범위를 벗어나면 해당 모양은 만들 수 없음
                 if(nr < 0 || nr >= N || nc < 0 || nc >= M) {
                    isPossible = false;
                    break;
                }
                sum += arr[nr][nc];
            }
            if(isPossible) {
                maxNum = Math.max(maxNum, sum);
            }
        }
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        node = new int[N][N];
        int[][] result = new int[N][N]; // 최종 결과를 저장할 배열

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                node[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 각 정점을 시작점으로 하여 BFS 실행
        for (int i = 0; i < N; i++) {
            bfs(i, result);
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int start, int[][] result) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N];

        q.add(start);

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < N; i++) {
                if (node[now][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    result[start][i] = 1;
                }
            }
        }
    }
}
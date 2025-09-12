import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine()); // 팀의 수
            int[] lastYearRank = new int[n];
            int[] inDegree = new int[n + 1];
            boolean[][] adj = new boolean[n + 1][n + 1];

            // 1. 작년 순위 입력받기
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                lastYearRank[i] = Integer.parseInt(st.nextToken());
            }

            // 2. 작년 순위를 기반으로 초기 그래프 생성
            // 자신보다 순위가 낮은 모든 팀을 가리키는 간선을 만든다.
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int from = lastYearRank[i];
                    int to = lastYearRank[j];
                    adj[from][to] = true;
                    inDegree[to]++;
                }
            }

            // 3. 순위 변경 정보 처리 (간선 뒤집기)
            int m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int teamA = Integer.parseInt(st.nextToken());
                int teamB = Integer.parseInt(st.nextToken());

                // 기존 간선 방향을 확인하고 반대로 뒤집는다.
                if (adj[teamA][teamB]) { // 원래 teamA -> teamB 였다면
                    adj[teamA][teamB] = false;
                    adj[teamB][teamA] = true;
                    inDegree[teamB]--;
                    inDegree[teamA]++;
                } else { // 원래 teamB -> teamA 였다면
                    adj[teamB][teamA] = false;
                    adj[teamA][teamB] = true;
                    inDegree[teamA]--;
                    inDegree[teamB]++;
                }
            }

            // 4. 위상 정렬 수행
            Queue<Integer> q = new LinkedList<>();
            List<Integer> result = new ArrayList<>();

            // 진입차수가 0인 노드를 큐에 추가
            for (int i = 1; i <= n; i++) {
                if (inDegree[i] == 0) {
                    q.add(i);
                }
            }

            String status = null; // 결과 상태를 저장할 변수

            while (!q.isEmpty()) {
                // Case 1: 순서가 모호한 경우 (?)
                // 큐에 2개 이상이 들어간다는 것은 정렬 가능한 노드가 여러 개라는 의미
                if (q.size() > 1) {
                    status = "?";
                    break;
                }

                int current = q.poll();
                result.add(current);

                // 현재 노드와 연결된 노드들의 진입차수 감소
                for (int i = 1; i <= n; i++) {
                    if (adj[current][i]) {
                        inDegree[i]--;
                        if (inDegree[i] == 0) {
                            q.add(i);
                        }
                    }
                }
            }
            
  
            if (status != null) {
                sb.append(status).append("\n");
            } else if (result.size() < n) {
                // Case 2: 사이클이 발생한 경우 (IMPOSSIBLE)
                // 모든 노드를 방문하기 전에 큐가 비었다면 사이클이 존재
                sb.append("IMPOSSIBLE").append("\n");
            } else {
                // Case 3: 순위가 확정된 경우
                for (int team : result) {
                    sb.append(team).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}
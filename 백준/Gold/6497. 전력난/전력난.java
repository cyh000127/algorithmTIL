import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 간선 정보를 저장할 Edge 클래스
    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        // 비용(cost) 기준으로 오름차순 정렬
        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int[] parent; // Union-Find를 위한 부모 테이블

    // 특정 원소가 속한 집합의 루트 찾기
    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    // 두 원소가 속한 집합을 합치기
    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootY] = rootX; // y의 루트를 x의 루트로 변경
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 집의 수 (정점)
            int n = Integer.parseInt(st.nextToken()); // 길의 수 (간선)

            // 입력의 끝 (0 0)이면 종료
            if (m == 0 && n == 0) {
                break;
            }

            Edge[] edges = new Edge[n];
            long totalCost = 0; // 전체 비용 (int 범위를 넘을 수 있으므로 long)

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                edges[i] = new Edge(from, to, cost);
                totalCost += cost;
            }

            // 1. 크루스칼 알고리즘을 위해 간선을 비용순으로 정렬
            Arrays.sort(edges);

            // 2. Union-Find 자료구조 초기화
            parent = new int[m];
            for (int i = 0; i < m; i++) {
                parent[i] = i; // 자기 자신을 부모로 설정
            }

            long mstCost = 0; // 최소 신장 트리의 비용
            int edgeCount = 0; // 연결된 간선의 수

            // 3. 비용이 낮은 간선부터 순회하며 MST 구성
            for (Edge edge : edges) {
                // 두 정점의 루트가 다를 경우 (사이클이 생기지 않을 경우)
                if (find(edge.from) != find(edge.to)) {
                    union(edge.from, edge.to); // 두 집합을 합침
                    mstCost += edge.cost;      // MST 비용에 추가
                    edgeCount++;
                }

                // MST가 완성되면 (정점-1 개의 간선이 연결되면) 종료
                if (edgeCount == m - 1) {
                    break;
                }
            }
            
            // 4. (전체 비용 - 최소 비용) = 절약 비용
            System.out.println(totalCost - mstCost);
        }
    }
}
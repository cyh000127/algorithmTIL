import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    // parent[x] = x가 속한 "대표(루트)" 게이트 번호.
    // 여기서는 "x 이하에서 가장 오른쪽(가장 큰 번호)의 사용 가능한 게이트"를 루트로 유지합니다.
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine().trim()); // 게이트 수
        int P = Integer.parseInt(br.readLine().trim()); // 비행기 수

        parent = new int[G + 1];
        // 초기화: 각 게이트는 자기 자신이 루트(=사용 가능)
        // 0번 게이트는 "더 이상 배정 불가"를 표현하기 위한 센티넬(sentinel)
        for (int i = 0; i <= G; i++) {
            parent[i] = i;
        }

        int docked = 0;
        for (int i = 0; i < P; i++) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) { i--; continue; }
            int g = Integer.parseInt(line.trim());

            if (occupy(g)) docked++;
            else break;  // 더 이상 배정할 게이트가 없으면 즉시 종료
        }

        System.out.println(docked);
    }

    /**
     * 비행기를 게이트 g 이하에서 가장 큰 사용 가능한 게이트에 배정한다.
     * - 성공하면 true, 실패(더 이상 배정 불가)이면 false를 반환.
     */
    static boolean occupy(int g) {
        // find(g)는 "g 이하에서 사용 가능한 가장 큰 게이트"의 루트를 돌려준다.
        int root = find(g);
        if (root == 0) return false;

        parent[root] = find(root - 1);
        return true;
    }

    static int find(int x) {
        if (parent[x] == x) return x;            // 자기 자신이 대표면 그대로 반환
        return parent[x] = find(parent[x]);      // 경로 압축: 대표를 찾아오면서 parent[x]를 대표로 갱신
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // BufferedReader를 사용하여 입력을 훨씬 빠르게 받습니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 메모리 절약을 위해 2차원 배열 대신 
        // 1차원 배열로 그때그때 처리할 수도 있지만, 
        // 1024MB로 메모리가 넉넉하니 기존 방식의 가독성을 유지하겠습니다.
        int[][] scores = new int[N][K];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] canBeLeader = new boolean[N];

        for (int j = 0; j < K; j++) {
            int maxVal = -1;
            int candidateIdx = -1;
            boolean isTie = false;

            for (int i = 0; i < N; i++) {
                if (scores[i][j] > maxVal) {
                    maxVal = scores[i][j];
                    candidateIdx = i;
                    isTie = false;
                } else if (scores[i][j] == maxVal) {
                    isTie = true;
                }
            }

            if (!isTie && candidateIdx != -1) {
                canBeLeader[candidateIdx] = true;
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            if (canBeLeader[i]) {
                result++;
            }
        }

        System.out.println(result);
    }
}
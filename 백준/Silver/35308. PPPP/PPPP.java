import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        StringBuilder sb = new StringBuilder();

        int T = fr.nextInt();

        for (int tc = 0; tc < T; tc++) {
            int N = fr.nextInt();
            int K = fr.nextInt();

            if (N == 1) {
                sb.append(1).append('\n');
            } else if (K != 2) {
                sb.append(-1).append('\n');
            } else {
                int[] A = new int[N + 1];
                int idx = 1;
                int ele = K;

                for (int i = 0; i < N; i++) {
                    A[idx] = ele;
                    idx = ele;
                    ele++;

                    if (ele > N) ele = 2;
                    if (ele == K) ele = 1;
                }

                for (int i = 1; i <= N; i++) {
                    sb.append(A[i]);
                    if (i < N) sb.append(' ');
                }
                sb.append('\n');
            }
        }

        System.out.print(sb);
    }
}
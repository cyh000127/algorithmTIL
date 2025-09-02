import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            // 토크나이저로 명령 파싱
            StringTokenizer st = new StringTokenizer(line);
            String cmd = st.nextToken();

            switch (cmd) {
                case "push_front": {
                    int x = Integer.parseInt(st.nextToken());
                    dq.addFirst(x);
                    break;
                }
                case "push_back": {
                    int x = Integer.parseInt(st.nextToken());
                    dq.addLast(x);
                    break;
                }
                case "pop_front": {
                    Integer v = dq.pollFirst();
                    sb.append(v == null ? -1 : v).append('\n');
                    break;
                }
                case "pop_back": {
                    Integer v = dq.pollLast();
                    sb.append(v == null ? -1 : v).append('\n');
                    break;
                }
                case "size": {
                    sb.append(dq.size()).append('\n');
                    break;
                }
                case "empty": {
                    sb.append(dq.isEmpty() ? 1 : 0).append('\n');
                    break;
                }
                case "front": {
                    Integer v = dq.peekFirst();
                    sb.append(v == null ? -1 : v).append('\n');
                    break;
                }
                case "back": {
                    Integer v = dq.peekLast();
                    sb.append(v == null ? -1 : v).append('\n');
                    break;
                }
            }
        }

        System.out.print(sb.toString());
    }
}

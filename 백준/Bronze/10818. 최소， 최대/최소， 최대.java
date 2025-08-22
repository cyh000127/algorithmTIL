import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < T; i++) {
			int s = Integer.parseInt(st.nextToken());
			pq.add(s);

		}
		if (T == 1) {
			int p = pq.poll();
			sb.append(p + " " + p);
		} else {
			for (int i = 0; i < T; i++) {
				if (i == 0) {
					sb.append(pq.poll() + " ");
				} else if (i == T - 1) {
					sb.append(pq.poll());
				} else
					pq.poll();
			}
		}
		System.out.println(sb);
	}
}
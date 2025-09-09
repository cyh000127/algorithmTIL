import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int cnt = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();

		ArrayDeque<Integer> q = new ArrayDeque<>();

		for (int i = 1; i <= n; i++) {
			q.add(i);
		}

		sb.append("<");

		while (q.size() > 1) {
			for (int i = 0; i < cnt - 1; i++) {
				q.add(q.poll());
			}
			sb.append(q.poll()).append(", ");
		}

		sb.append(q.poll());
		sb.append(">");
		System.out.println(sb.toString().trim());
	}
}

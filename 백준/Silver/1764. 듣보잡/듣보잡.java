import java.util.*;
import java.io.*;

/*
 * 1764 듣보잡
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		HashSet<String> s = new HashSet<String>();
		PriorityQueue<String> pq = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			s.add(br.readLine());
		}

		for (int i = 0; i < m; i++) {
			String tmp = br.readLine();
			if (s.contains(tmp)) {
				pq.add(tmp);
			}

		}

		StringBuilder sb = new StringBuilder();
		sb.append(pq.size()).append("\n");

		while(!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}
		System.out.println(sb.toString().trim());
	}
}

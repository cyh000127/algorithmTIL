import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;


		// 백준
		// 13975. 파일 합치기 3

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			PriorityQueue<Long> pq = new PriorityQueue<>();
			int K = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			long sum = 0;
			for (int i = 0; i < K; i++) {
				pq.add(Long.parseLong(st.nextToken()));
			}

			while (pq.size() > 1) {
				long x = pq.poll() + pq.poll();
				sum += x ;
				pq.add(x);
			}
			System.out.println(sum);
		}
	}
}
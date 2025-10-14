import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			if (a[0] == b[0]) {
				return a[1] - b[1];
			}
			return a[0] - b[0];
		});
		
		
		int a = Integer.parseInt(br.readLine());

		for (int i = 0; i < a; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				if (pq.isEmpty()) {
					System.out.println(0);
				} else {
					int[] curr = pq.poll();
					if (curr[1] == 0) {
						System.out.println(-curr[0]);
					} else
						System.out.println(curr[0]);

				}

			} else {
				if (n < 0) {
					pq.add(new int[] { -n, 0 }); // 0= 음수라는 의미
				} else
					pq.add(new int[] { n, 1 });
			}
		}
	}
}
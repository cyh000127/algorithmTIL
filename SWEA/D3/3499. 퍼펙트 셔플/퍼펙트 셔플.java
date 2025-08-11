import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int card = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			Queue<String> queue1 = new LinkedList<String>();
			Queue<String> queue2 = new LinkedList<String>();

			if (card % 2 == 0) {
				for (int i = 0; i < card / 2; i++) {
					queue1.offer(st.nextToken());
				}
				for (int i = card / 2; i < card; i++) {
					queue2.offer(st.nextToken());

				}

			} else if (card % 2 == 1) {
				for (int i = 0; i < card / 2 + 1; i++) {
					queue1.offer(st.nextToken());
				}
				for (int i = card / 2 + 1; i < card; i++) {
					queue2.offer(st.nextToken());
				}
			}

			// 디버깅용 코드
//			System.out.println(queue1.toString());
//			System.out.println(queue2.toString());

			StringBuilder sb = new StringBuilder();
			while (!queue1.isEmpty() || !queue2.isEmpty()) {
				if (!queue1.isEmpty()) {
					sb.append(" ");
					sb.append(queue1.poll());
				}
				if (!queue2.isEmpty()) {
					sb.append(" ");
					sb.append(queue2.poll());
				}
			}
			System.out.println("#" + tc + sb);
		}
	}
}
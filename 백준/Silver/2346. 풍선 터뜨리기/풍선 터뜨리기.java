import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 1번의 왼쪽에 N번 풍선이 있음 (원형으로 )
		// 1번 풍선을 터트리고 안의 종이에 써있는 숫자만큼 이동 후 풍선을 터트림

		int ball = Integer.parseInt(br.readLine());

		ArrayDeque<Integer> q = new ArrayDeque<>();
		int[] arr = new int[ball + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= ball; i++) {
			q.add(i);
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 큐에 1, 2, 3, 4, 5
		// array에 0, 3, 2, 1, -1, -1;

		while (q.size() != 1) {
			int t = q.poll();
			sb.append(t).append(" ");
			if (arr[t] > 0) {
				for (int i = 1; i < arr[t]; i++) {
					q.offer(q.poll());
				}
			} else {
				for (int i = arr[t]; i < 0; i++) {
					q.offerFirst(q.pollLast());
				}
			}
		}
		sb.append(q.poll());
		System.out.println(sb);
	}
}

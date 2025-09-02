import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> q = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();

			if (order.equals("push")) {
				q.add(Integer.parseInt(st.nextToken()));
			} else if (order.equals("front")) {
				if (q.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(q.getFirst());
				}
			} else if (order.equals("back")) {
				if (q.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(q.getLast());
				}
			} else if (order.equals("pop")) {
				if (q.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(q.pop());
				}
			} else if (order.equals("empty")) {
				if (q.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
			} else if (order.equals("size")) {
				System.out.println(q.size());
			}

		}

	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 1. 정수 x를 deque의 맨 앞에 넣음
		// 2. 정수 x를 deque의 맨 뒤에 넣음
		// 3. deque가 비어있지 않다면 맨앞의 정수를 빼서 출력 else -1
		// 4. deque가 비어있지 않다면 맨뒤의 정수를 빼서 출력 else -1
		// 5. 덱의 정수 개수 (size) 출력
		// 6. isempty 면 1 else 0
		// 7. !isempty 맨 앞 정수 출력 isempty = -1
		// 8. !isempty 맨 뒤 정수 출력 isempty = -1

		ArrayDeque<Integer> q = new ArrayDeque<>();
		// 명령 개수가 첫줄에 주어짐
		// 첫 수는 명령 번호
		// 두번째 수는 정수x
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			if (order == 6) {
				if (q.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
			} else if (order == 1 || order == 2) {
				// q에 삽입
				int n = Integer.parseInt(st.nextToken());
				if (order == 1) {
					q.offerFirst(n);
				} else
					q.offerLast(n);
			} else if (order == 3 || order == 4) {
				if (q.isEmpty())
					System.out.println(-1);
				else if (order == 3) {
					System.out.println(q.poll());
				} else
					System.out.println(q.pollLast());
			} else if (order == 5) {
				System.out.println(q.size());
			} else {
				if (q.isEmpty())
					System.out.println(-1);
				else if (order == 7) {
					System.out.println(q.getFirst());
				} else
					System.out.println(q.getLast());
			}
		}
	}
}

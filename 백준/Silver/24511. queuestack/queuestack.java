import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 1~N번의 자료구조가 나열 각각 1개의 원소가 드러가 있음
		// X0 을 입력
		// x0을 1번 자료에 삽입 -> x1 = pop
		// x1을 2번 자료에 삽입 -> x2 = pop . . . . .

		// x(n-1)을 n번 자료에 삽입 -> xn =pop -> xn을 구하셈

		// 길이 M인 수열 C를 가져와 앞에서 부터 -> LIFO -> deque 넣을거임 그 출력값을 말하셈
		// 정답은 M개 나오게 되어있음

		// 처음 입력 -> 자료구조 개수 N
		// 둘재 줄 -> 수열의 형태 -> 스택 1 / 큐 0
		// 세번째 줄 -> 각 수열의 숫자
		// 네번째 줄 -> 삽입할 수열의 길이
		// 길이 M 인 수열 C가 주어짐

		// stack(1)의 pop은 후입선출(LIFO) 즉 수열이 1이라면 그냥 뺌 -> 계산이 필요 없음
		// queue(0)의 pop은 선입선출(FIFO) 즉 수열이 0이라면 이미 있던 숫자를 뺌
		// 길이가 2밖에 안되기때문에 굳이 자료구조를 선언하지 않고 풀 수 있지 않을까
        // 실패- > 런타임 에러가 남 

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 자료구조는 배열로 저장하자
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// nums에는 숫자들을 넣을겨
		st = new StringTokenizer(br.readLine());
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			// 자료구조가 스택일때는 무시 , 큐일때만 add
			if (arr[i] == 0) {
				q.add(n);
			}
		}
		// 입력 횟수
		int M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int c = Integer.parseInt(st.nextToken());

			q.addFirst(c);
			sb.append(q.pollLast()).append(" ");
		}

		System.out.println(sb.toString().trim());
	}
}
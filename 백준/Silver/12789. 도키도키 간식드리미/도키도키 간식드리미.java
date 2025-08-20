import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 주어지는 번호표 순서가 있음
		// 순서가 뒤쪽이라면 stack에 push해줌
		// stack의 peek이나 현재 대기줄이 다음 순서가 오는게 불가능하면 sad 출력
		// 온몸 비틀어서 가능하면 Nice 출력
		Stack<Integer> stack = new Stack<Integer>();
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 간식 받아야하는 순서
		int order = 1;
		String ans = "Nice";
		// arr[idx] == order 면 order ++
		// arr[idx] != order 면
		// stack.peek() == order -> stack.pop() + order++;
		// stack.peek() > arr[idx] -> break; ans = "Sad"
		// order = N -> ans = "Nice"
		for (int i = 0; i < N; i++) {
			int currentSnack = Integer.parseInt(st.nextToken());

			// 1. 현재 간식이 올바른 순서면 바로 통과
			if (currentSnack == order) {
				order++;

				// 2. 대기열에 있는 간식도 순서에 맞으면 통과
				while (!stack.isEmpty() && stack.peek() == order) {
					stack.pop();
					order++;
				}
			} else {
				// 3. 대기열에 있는 간식과 현재 간식의 순서 비교
				if (!stack.isEmpty() && stack.peek() < currentSnack) {
					// 스택의 오름차순에 어긋나게 된다면 -> 간식 받는순서가 지켜질 수 없으므로 break
					ans = "Sad";
					break;
				} else {
					// 4. 순서에 맞지 않으므로 대기열에 추가
					stack.push(currentSnack);
				}
			}
		}

		// 스택의 남은 간식 처리
		while (!stack.isEmpty() && stack.peek() == order) {
			stack.pop();
			order++;
		}

		// 모든 간식을 처리했는지 최종 확인
		if (order <= N) {
			ans = "Sad";
		}

		System.out.println(ans);
	}
}

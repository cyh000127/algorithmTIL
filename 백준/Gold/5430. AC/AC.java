import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			String command = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String arrStr = br.readLine();

			// Deque 
			ArrayDeque<Integer> deque = new ArrayDeque<>();
			
			// 입력 문자열 파싱
			// 대괄호 제거 후 쉼표로 분리
			StringTokenizer st = new StringTokenizer(arrStr.substring(1, arrStr.length() - 1), ",");
			for (int i = 0; i < n; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}

			// isReversed 플래그로 뒤집기 연산을 대체
			boolean isReversed = false;
			boolean isError = false;

			for (char cmd : command.toCharArray()) {
				if (cmd == 'R') {
					// O(1) 연산: 단순히 방향만 바꿈
					isReversed = !isReversed;
				} else { // 'D'
					if (deque.isEmpty()) {
						isError = true;
						break;
					}
					// 방향에 따라 앞에서 또는 뒤에서 제거
					if (isReversed) {
						deque.pollLast(); // 뒤집힌 상태면 뒤에서 제거
					} else {
						deque.pollFirst(); // 정방향이면 앞에서 제거
					}
				}
			}

			// 결과 출력
			if (isError) {
				sb.append("error\n");
			} else {
				sb.append("[");
				// 최종 방향에 따라 출력 순서 결정
				if (isReversed) {
					// 뒤집힌 상태면 뒤에서부터 poll
					while (deque.size() > 1) {
						sb.append(deque.pollLast()).append(",");
					}
				} else {
					// 정방향이면 앞에서부터 poll
					while (deque.size() > 1) {
						sb.append(deque.pollFirst()).append(",");
					}
				}
				// 마지막 남은 원소 처리 (덱이 비어있을 수도 있음)
				if (!deque.isEmpty()) {
					sb.append(deque.poll());
				}
				sb.append("]\n");
			}
		}
		System.out.print(sb); // 모든 테스트 케이스 결과를 모아서 한 번에 출력
	}
}


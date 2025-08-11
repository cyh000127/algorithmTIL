import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test = 1; test <= 10; test++) {
			Queue<Integer> q = new LinkedList<Integer>();
			// 테스트 케이스 번호
			int T = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			// queue에 8개의 숫자 일단 모두 담기
			for (int i = 0; i < 8; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}

			// 1~5 까지 빼기
			int minus = 0;
			// 0이 되는 순간 종료
			while (true) {
				// q를 current에 담은 후 minus 적용
				int current = q.poll();
				current += --minus;
				// 마이너스가 -5를 넘어가면 0으로 초기화
				if (minus == -5)
					minus = 0;
				// current가 0보다 작으면 0으로 만든 후
				// q에 추가 -> break;
				if (current <= 0) {
					current = 0;
					q.add(current);
					break;
				}
				q.add(current);
			}

			StringBuilder sb = new StringBuilder();
			for (int n : q) {
				sb.append(n).append(" ");
			}
			System.out.println("#" + T + " " + sb);
		}
	}
}

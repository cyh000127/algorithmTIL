import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 초기 최대 힙이 비어있다면
		// 연산 1. 자연수 X 를 삽입
		// 연산 2. 최대 힙의 루트 노드의 키 값을 출력하고(1번 노드의 키 값), 해당 노드 삭제
		// 최대값 출력 후 키 값 삭제

		// 테스트 케이스 T
		// 수행해야하는 연산의 수 N
		// N개의 줄에 걸쳐 수행해야 하는 연산에 대한 정보
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {

			PriorityQueue<Integer> pq = new PriorityQueue<>();

			int N = Integer.parseInt(br.readLine());

			//priorityqueue는 기본 최소 힙이기 때문에 최대 힙으로 만들기 위해 '-' 부호를 넣어줌
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test);
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int calc = Integer.parseInt(st.nextToken());
				if (calc == 1) {
					pq.add(-Integer.parseInt(st.nextToken()));
				} else if (calc == 2 && !pq.isEmpty()) {
					sb.append(" ").append(-pq.poll());
				} else if (calc == 2 && pq.isEmpty())
					sb.append(" ").append("-1");
			}
			
			System.out.println(sb);
		}
	}
}

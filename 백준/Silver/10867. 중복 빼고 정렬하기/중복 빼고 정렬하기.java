import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 중복을 뺴고 정렬하기
		// hash set을 사용한 후 list에 저장해보자
		int N = Integer.parseInt(br.readLine());

		Set<Integer> set = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		// set size를 배열에 저장
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int element : set) {
			pq.add(element);
		}
		
		while (!pq.isEmpty()) {
			sb.append(pq.poll()).append(" ");
		}
		
		System.out.println(sb.toString().trim());
		
	}

}

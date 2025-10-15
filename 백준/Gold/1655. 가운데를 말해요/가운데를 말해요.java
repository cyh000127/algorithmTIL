import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// 백준
		// 1655. 가운데를 말해요

		int N = Integer.parseInt(br.readLine());

		// 중간값을 찾기 위해 두개의 최대힙, 최소 힙 선언
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			// 힙에 원소 추가
			if (maxHeap.size() == minHeap.size()) {
				maxHeap.add(num);
			} else {
				minHeap.add(num);
			}

			if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
				int MAX = maxHeap.poll();
				int MIN = minHeap.poll();
				
				maxHeap.add(MIN);
				minHeap.add(MAX);
			}
			
			sb.append(maxHeap.peek()).append("\n");
		}
		System.out.println(sb.toString().trim());

	}
}

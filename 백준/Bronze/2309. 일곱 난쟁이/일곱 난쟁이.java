import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 일곱 난장이 키의 합이 100이 됨
		// 입력은 9개의 수가 주어짐
		// 9개의 수 중에서 7개의 조합으로 100이 되면 해결되는 문제
		// 7명을 찾은 후 키를 오름차순으로 정렬하라 ( priorityqueue를 쓸까 ?)

		// 먼저 정렬을 한 후 탐색을 할까 ?
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		// 9개의 수를 정렬한 후 pq에 넣음 (힙)
		for (int i = 0; i < 9; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}

		// 배열에 정렬해서 집어넣기
		int sum9 = 0;
		int idx = 0;

		int[] arr = new int[9];

		while (!pq.isEmpty()) {
			arr[idx] = pq.poll();
			sum9 += arr[idx++];
		}

		// 9명을 더한 값 sum9에서 100을 뺀값을 가지는 난쟁이 두명을 찾기
		int sum = sum9 - 100;
//		System.out.println(sum);
		for (int i = 0; i < 8; i++) {
			boolean found = false;
			for (int j = i + 1; j < 9; j++) {

				if (arr[i] + arr[j] == sum) {
					arr[i] = 0;
					arr[j] = 0;
					found = true;
					break;
				}
			}
			if (found) {
				break;
			}
		}

		for (int i = 0; i < 9; i++) {
			if (arr[i] == 0) {
				continue;
			} else
				System.out.println(arr[i]);
		}
	}
}

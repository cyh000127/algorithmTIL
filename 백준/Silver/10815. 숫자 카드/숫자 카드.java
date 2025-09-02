import java.io.*;
import java.util.*;

public class Main {
	static int N, wholeCard;
	static int[] arr, nCard;
	static boolean[] is;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		nCard = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine()); // 상근이가 가진 카드
		
		wholeCard = Integer.parseInt(br.readLine());
		arr = new int[wholeCard];
		
		is = new boolean[wholeCard];

		for (int i = 0; i < N; i++) {
			nCard[i] = Integer.parseInt(st.nextToken());
		}

		StringTokenizer a = new StringTokenizer(br.readLine());

		for (int i = 0; i < wholeCard; i++) {
			arr[i] = Integer.parseInt(a.nextToken());
		}
		Arrays.sort(nCard);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < wholeCard; i++) {
			binarySearch(i, 0, N-1);
		}

		for (int i = 0; i < wholeCard; i++) {
			if (is[i]) {
				sb.append(1).append(" ");
			} else
				sb.append(0).append(" ");
		}
		System.out.println(sb.toString().trim());
	}

	private static int binarySearch(int idx, int start, int end) {
		// 가지치기
		if (nCard[N - 1] < arr[idx] || nCard[0] > arr[idx]) {
			return -1;
		}
		// 못찾으면 return
		if (start > end) {
			return -1;
		}

		int mid = start + (end - start) / 2; // 중간 값 찾기

		if (arr[idx] == nCard[mid]) {
			is[idx] = true;
			return mid;
		} else if (arr[idx] < nCard[mid]) { // mid가 더크면 -> 작은 쪽으로 가야함
			return binarySearch(idx, start, mid - 1);
		} else {
			return binarySearch(idx, mid + 1, end);
		}
	}
}
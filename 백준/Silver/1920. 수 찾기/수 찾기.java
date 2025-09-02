import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;;
	static int aCard;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		aCard = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		arr = new int[aCard];
		for (int i = 0; i < aCard; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr); // 이진탐색은 정렬을 한 후 사용 가능

		int bCard = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < bCard; i++) {
			if (BinarySearch(Integer.parseInt(st.nextToken()), 0, aCard) == -1) {
				System.out.println(0);
			} else {
				System.out.println(1);
			}
		}

	}

	private static int BinarySearch(int num, int start, int end) {
		// start가 end보다 커지면 답이 없는 것
		if (start > end ) {
			return -1;
		}
		// 범위 밖일시 가지치기
		if (num > arr[aCard - 1] || num < arr[0]) {
			return -1;
		}


		// 1. 배열을 반으로 잘라라
		int mid = start + (end - start) / 2;

		if (arr[mid] == num) {
			return mid;
		} else if (arr[mid] < num) {
			return BinarySearch(num, mid + 1, end);
		} else {
			return BinarySearch(num, start, mid - 1);
		}

	}
}
import java.io.*;
import java.util.*;

public class Solution {
	static int[] arr;
	static int[] tmp = new int[1000000];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[1000000];
		int i = 0;
		while (st.hasMoreTokens()) {
			arr[i++] = Integer.parseInt(st.nextToken());

		}
		mergeSort(0, 999999);
		System.out.println(arr[500000]);
	}

	private static void mergeSort(int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;// 미드 포인트 구하기
			mergeSort(start, mid);
			mergeSort(mid + 1, end);

			merge(start, mid, end);
		}
	}

	private static void merge(int start, int mid, int end) {
		int L = start;
		int R = mid + 1;

		int idx = start;

		while (L <= mid && R <= end) {
			if (arr[L] <= arr[R]) {
				tmp[idx++] = arr[L++];
			} else {
				tmp[idx++] = arr[R++];
			}
		}
		if (L <= mid) {
			for (int i = L; i <= mid; i++) {
				tmp[idx++] = arr[i];
			}
		} else {
			for (int i = R; i <= end; i++) {
				tmp[idx++] = arr[i];

			}
		}
		for (int i = start; i <= end; i++) {
			arr[i] = tmp[i];
		}
	}
}

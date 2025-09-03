import java.io.*;
import java.util.*;

public class Main {
	static int[] aarr, barr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 2 차원 평면에 점 N개
		// x좌표가 증가하는 순 , x가 같다면 y가 증가하는 순으로 정렬

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;

		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o2[0] == o1[0])
					return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});

		for (int i = 0; i < N; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
	}
}

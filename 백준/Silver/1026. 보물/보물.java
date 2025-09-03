import java.io.*;
import java.util.*;

public class Main {
	static int[] aarr, barr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 첫 째 줄에 N
		// A의 수 N개
		// B의 수 N개
		int N = Integer.parseInt(br.readLine());
		// 최솟 값 찾기

		StringTokenizer Anum = new StringTokenizer(br.readLine());
		StringTokenizer Bnum = new StringTokenizer(br.readLine());

		aarr = new int[N];
		barr = new int[N];
		for (int i = 0; i < N; i++) {
			aarr[i] = Integer.parseInt(Anum.nextToken());
			barr[i] = Integer.parseInt(Bnum.nextToken());
		}

		// b의 배열을 바꾸지 말라고 하긴했으나
		// 문제에서 요구하는 답이 배열을 건드리면 안되는 방식이 아니기 때문에
		// b,a 배열을 정렬
		
		Arrays.sort(aarr);
		Arrays.sort(barr);
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			cnt += barr[i] * aarr[N - i - 1];
		}

		System.out.println(cnt);
	}
}

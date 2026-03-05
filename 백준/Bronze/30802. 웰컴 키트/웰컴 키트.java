import java.util.*;
import java.io.*;

/**
 * 30802 웰컴 키트
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[6];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		int cnt = 0;
		for (int i = 0; i < 6; i++) {
			cnt += arr[i] / T;
			cnt = arr[i] % T > 0 ? cnt + 1 : cnt;
		}
		
		System.out.println(cnt);
		System.out.println(N / P + " " + N % P);

	}
}
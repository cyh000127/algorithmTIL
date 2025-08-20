import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 총 계산한 일 수 d
		StringTokenizer st = new StringTokenizer(br.readLine());
		int d = Integer.parseInt(st.nextToken());
		// 온도를 합할 일 수 n
		int n = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[d];

		for (int i = 0; i < d; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < d - n + 1; i++) {
			int sumn = 0;
			for (int j = 0; j < n; j++) {
				sumn += arr[i + j];
			}
			max = Math.max(max, sumn);
		}
		System.out.println(max);
	}
}

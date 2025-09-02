import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[10001]; // 자연수는 10001까지

		for (int i = 0; i < N; i++) {
			int sc = Integer.parseInt(br.readLine());
			arr[sc]++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < arr.length; i++) {
			while (arr[i]-- > 0) {
				sb.append(i).append("\n");
				if (sb.length() >= (1 << 20)) {
					System.out.println(sb.toString().trim());
					sb.setLength(0);
					sb.append("\n");
				}
			}
		}
		System.out.println(sb.toString().trim());

	}
}
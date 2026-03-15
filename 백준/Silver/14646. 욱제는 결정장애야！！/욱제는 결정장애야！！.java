import java.util.*;
import java.io.*;

/**
 * 15646 욱제는 결정장애야!
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] a = new int[n + 1];
		int cnt = 0;
		int ans = 0;
		for (int i = 0; i < 2 * n; i++) {
			int s = Integer.parseInt(st.nextToken());
			if (a[s] == 0) {
				a[s]++;
				cnt++;
			} else if (a[s] == 1) {
				ans = Math.max(ans, cnt);
				cnt--;
			}
		}
		System.out.println(ans);
	}
}
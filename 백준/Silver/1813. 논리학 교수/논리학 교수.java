import java.util.*;
import java.io.*;

/**
 * 1813 논리학 교수
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] s = new int[51];
		for (int i = 0; i < n; i++) {
			s[Integer.parseInt(st.nextToken())]++;
		}

		for (int i = n; i >= 0; i--) {
			if (s[i] == i) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
	}
}
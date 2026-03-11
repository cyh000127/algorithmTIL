import java.util.*;
import java.io.*;

/**
 * 17472 다리 만들기 2
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			String str = br.readLine();
			int a = str.length();
			if (a >= 6 && a <= 9) {
				sb.append("yes\n");
			} else {
				sb.append("no\n");
			}

		}

		System.out.print(sb);
	}
}

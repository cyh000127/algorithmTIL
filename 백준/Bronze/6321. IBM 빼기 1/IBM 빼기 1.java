import java.util.*;
import java.io.*;

/**
 * 6321 IBM 빼기 1
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			char[] str = br.readLine().toCharArray();

			sb.append("String #" + i + "\n");
			for (int x = 0; x < str.length; x++) {
				str[x] += 1;
				if (str[x] == 'Z' + 1)
					str[x] = 'A';
				sb.append(str[x]);
			}
			sb.append("\n" + "\n");
		}
		System.out.println(sb.toString().trim());
	}
}
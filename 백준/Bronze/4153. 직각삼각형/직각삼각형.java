import java.util.*;
import java.io.*;

/**
 * 4153 직각삼각형
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		StringBuilder sb = new StringBuilder();
		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == 0 && b == 0 && c == 0) {
				break;
			}

			double da = Math.pow(a, 2);
			double db = Math.pow(b, 2);
			double dc = Math.pow(c, 2);

			if (da == db + dc || dc == da + db || db == dc + da) {
				sb.append("right").append("\n");
			} else 
			sb.append("wrong").append("\n");

		}
		System.out.println(sb.toString().trim());
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		String a = st.nextToken();
		String b = st.nextToken();

		if (a.charAt(2) > b.charAt(2)) {
			sb.append(a.charAt(2)).append(a.charAt(1)).append(a.charAt(0));
		} else if (a.charAt(2) < b.charAt(2)) {
			sb.append(b.charAt(2)).append(b.charAt(1)).append(b.charAt(0));
		} else {
			if (a.charAt(1) > b.charAt(1)) {
				sb.append(a.charAt(2)).append(a.charAt(1)).append(a.charAt(0));
			} else if (a.charAt(1) < b.charAt(1)) {
				sb.append(b.charAt(2)).append(b.charAt(1)).append(b.charAt(0));
			} else {
				if (a.charAt(0) > b.charAt(0)) {
					sb.append(a.charAt(2)).append(a.charAt(1)).append(a.charAt(0));
				} else if (a.charAt(0) < b.charAt(0)) {
					sb.append(b.charAt(2)).append(b.charAt(1)).append(b.charAt(0));
				}
			}
		}
		System.out.println(sb.toString());
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int repeat = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			for (int j = 0; j < str.length(); j++) {
				for (int i = 0; i < repeat; i++) {
					sb.append(str.charAt(j));
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
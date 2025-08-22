import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken()); // 앞
		int is = 0;
		for (int i = 0; i < 7; i++) {
			int b = Integer.parseInt(st.nextToken()); // 뒤
			if (a > b) {
				is++;
				a = b; // b의 갚을 앞으로 빼줌
			} else if (a < b) {
				is--;
				a = b; // b의 갚을 앞으로 빼줌
			}

		}
//		System.out.println(is);
		if (is == -7) {
			sb.append("ascending");
		} else if (is == 7) {
			sb.append("descending");
		} else
			sb.append("mixed");
		System.out.println(sb);
	}
}
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int cnt = 0 ;
		for (int i = 0; i < N; i++) {
			boolean is = true;
			int a = Integer.parseInt(st.nextToken());
			if(a == 1) continue;
			for (int j = 2; j < a; j++) {
				if (a % j == 0) {
					is = false;
					break;
				}
			}
			if (is) {
				cnt++;
			}
		}
		sb.append(cnt);
		System.out.println(sb);
	}
}

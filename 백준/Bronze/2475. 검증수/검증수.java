import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 5; i++) {
			int a = Integer.parseInt(st.nextToken());
			cnt += a * a;
		}

		System.out.println(cnt%10);
	}
}
		
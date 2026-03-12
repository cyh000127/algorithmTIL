import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			int x = n - i;
			while (x-- > 0) {
				sb.append(' ');
			}
			for (int s = i - 1; s >0; s--) {
				sb.append("**");
			}
			sb.append('*').append("\n");
		}

		for (int i = n-1; i >= 1; i--) {
			int x = n - i ;
			while (x-- > 0) {
				sb.append(' ');
			}
			for (int s = i - 1; s >0; s--) {
				sb.append("**");
			}
			sb.append('*').append("\n");
		}
		System.out.println(sb);
	}
}
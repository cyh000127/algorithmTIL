import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		// 1 1 2 2 2 8
		int[] arr = new int[6];
		int[] chess = new int[] { 1, 1, 2, 2, 2, 8 };

		for (int i = 0; i < 6; i++) {
			sb.append(chess[i] - Integer.parseInt(st.nextToken())).append(" ");
		}
		System.out.println(sb.toString().trim());
	}
}

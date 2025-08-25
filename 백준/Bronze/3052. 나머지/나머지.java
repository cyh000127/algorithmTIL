import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] arr = new int[42];
		for (int i = 0; i < 10; i++) {
			int a = Integer.parseInt(br.readLine());
			a %= 42;
			arr[a] = 1;
		}

		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1)
				cnt++;
		}
		sb.append(cnt);
		System.out.println(sb);
	}
}

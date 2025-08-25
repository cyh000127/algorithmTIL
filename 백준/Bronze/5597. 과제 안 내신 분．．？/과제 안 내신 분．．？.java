import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 30명 중 과제 안낸 두명 찾기
		int[] arr = new int[31]; // 1~30까지
		for (int i = 0; i < 28; i++) { // 28명 찾음
			int a = Integer.parseInt(br.readLine());
			arr[a] = 1;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == 0) {
				sb.append(i).append("\n");
			}
		}
		
		System.out.println(sb.toString().trim());
	}
}

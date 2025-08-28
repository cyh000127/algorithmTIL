import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = 1 << N; // 이 값보다 1 작으면 모든 칸에 1이 들어있는 것
			if (a % b == b - 1) {
				System.out.println("#" + test + " " + "ON");
			} else {
				System.out.println("#" + test + " " + "OFF");
			}

		}
	}
}
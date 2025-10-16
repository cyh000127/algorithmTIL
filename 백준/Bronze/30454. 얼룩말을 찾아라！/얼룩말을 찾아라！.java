import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();

		// 백준
		// 30454. 얼룩말을 찾아라!

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 얼룩말 개체수
		int L = Integer.parseInt(st.nextToken()); // 몸통 길이

		int maxblack = 0;
		int[] zebras = new int[N];
		for (int i = 0; i < N; i++) {
			String[] zebra = br.readLine().split("0");
			// 얼룩말의 흰색부분은 의미가 없음
			int blackline = 0;

			for (String z : zebra) {
				if (!z.isEmpty()) {
					blackline++;
				}
			}
			
			if (blackline > maxblack)
				maxblack = blackline;
			zebras[i] = blackline;
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			if (zebras[i] == maxblack) {
				count++;
			}
		}
		System.out.println(maxblack + " " + count);
	}
}

import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스 지정
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			// 카드 개수
			int card = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());

			LinkedList<String> arr1 = new LinkedList<String>();
			LinkedList<String> arr2 = new LinkedList<String>();

			if (card % 2 == 0) {
				for (int i = 0; i < card / 2; i++) {
					arr1.add(st.nextToken());
				}
				while (st.hasMoreTokens()) {
					arr2.add(st.nextToken());
				}
			} else {
				for (int i = 0; i < card / 2 + 1; i++) {
					arr1.add(st.nextToken());
				}
				while (st.hasMoreTokens()) {
					arr2.add(st.nextToken());
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test);
			while(!arr1.isEmpty()) {
				sb.append(" ").append(arr1.poll());
				if(!arr2.isEmpty())
				sb.append(" ").append(arr2.poll());
			}
			System.out.println(sb);
		}
	}
}

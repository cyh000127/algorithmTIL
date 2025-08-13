import java.io.*;
import java.util.*;

public class Solution {
	// 연산자도 포함되어 있는 구조이기 떄문에 String
	static String[][] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test = 1; test <= 10; test++) {
			// 테스트 케이스별 정점의 개수
			int N = Integer.parseInt(br.readLine());

			tree = new String[N + 1][3];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				String a = st.nextToken();
				if (a.equals("-") || a.equals("*") || a.equals("/") || a.equals("+")) {
					String leftNum = st.nextToken();
					String rightNum = st.nextToken();
					// 0일때 자신 , 1일때 왼쪽 , 2일떄 오른쪽
					tree[A][0] = a;
					tree[A][1] = leftNum;
					tree[A][2] = rightNum;
				} else {
					tree[A][0] = a;
				}
			}
			float result = calc(1);
			System.out.println("#"+test+" "+(int)result);
		}

	}

	private static float calc(int i) {
		if (tree[i][0].equals("-")) {
			return calc(Integer.parseInt(tree[i][1])) - calc(Integer.parseInt(tree[i][2]));
		} else if (tree[i][0].equals("*")) {
			return calc(Integer.parseInt(tree[i][1])) * calc(Integer.parseInt(tree[i][2]));
		} else if (tree[i][0].equals("+")) {
			return calc(Integer.parseInt(tree[i][1])) + calc(Integer.parseInt(tree[i][2]));
		} else if (tree[i][0].equals("/")) {
			return calc(Integer.parseInt(tree[i][1])) / calc(Integer.parseInt(tree[i][2]));
		} else {
			return Integer.parseInt(tree[i][0]);
		}
	}

}
import java.io.*;
import java.util.*;

public class Solution {
	// 문자를 담기 위한 String
	static String[][] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test = 1; test <= 10; test++) {
			// 테스트 케이스별 정점의 개수
			int N = Integer.parseInt(br.readLine());

			// 1~ N+1까지이기때문에 N+1
			// 자기자신, 좌, 우 있기떄문에 3
			tree = new String[N + 1][3];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int nodeNumber = Integer.parseInt(st.nextToken());
				String value = st.nextToken();
				// 노드에 값은 항상 들어감.
				tree[nodeNumber][0] = value;

				// 다음 입력이 더 있다면 연결된 노드가 있다는 의미 이기 때문에 1, 2 에 간선 추가
				if (st.hasMoreTokens()) {
					tree[nodeNumber][1] = st.nextToken();
				}
				if (st.hasMoreTokens()) {
					tree[nodeNumber][2] = st.nextToken();
				}

			}
			String output = strMaker(1);
			
			System.out.println("#" +test+ " "+output);
		}
	}

	// L V R 순회 -> 중위 순회
	private static String strMaker(int i) {
		StringBuilder sb = new StringBuilder();
		// 왼쪽 먼저 순회 깊이 들어가!!
		if (tree[i][1] != null) {
			sb.append(strMaker(Integer.parseInt(tree[i][1])));
		} 
			sb.append( tree[i][0]);
			
		if(tree[i][2] != null) {
			sb.append(strMaker(Integer.parseInt(tree[i][2])));
		}
		return sb.toString();
		
		
}

}
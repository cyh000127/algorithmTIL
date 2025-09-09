
import java.util.Scanner;

public class Solution {

	// 서로소 집합을 표현할 대표자를 가리키는 parent 배열 선언
	static protected int[] parent;

	// 초기화 make-set : 나 자신을 부모로 가리키도록 초기화 메서드
	static public void init(int N) { // 요소의 갯수가 N개 일 때에 초기화...!
		parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
	}

	// find-set : x가 속해있는 대표자를 반환하는 메서드
	static public int findSet(int x) {
		if (parent[x] == x) {
			return x;
		}

		return parent[x] = findSet(parent[x]);// 재귀호출로 부모를 통해 다시 대표자 탐색 진행
	}

	// union : x와 y가 속해있는 그룹을 통합하는 메서드
	static public void union(int x, int y) {
		int root_x = findSet(x);
		int root_y = findSet(y);

		if (root_x != root_y)
			parent[root_x] = root_y;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트케이스 수
		int T = Integer.parseInt(sc.nextLine());
		for (int tc = 1; tc <= T; tc++) {
			// 입력

			// 원소의 갯수 N, 연산의 갯수 M
			String[] temp = sc.nextLine().split(" ");
			int N = Integer.parseInt(temp[0]);
			int M = Integer.parseInt(temp[1]);

			// 연산 갯수 M 만큼의 입력이 주어진다...!
			int[][] commands = new int[M][];

			for (int i = 0; i < M; i++) {
				String[] temp2 = sc.nextLine().split(" ");

				int command = Integer.parseInt(temp2[0]);
				int x = Integer.parseInt(temp2[1]);
				int y = Integer.parseInt(temp2[2]);

//				commands[i][0] = command;
//				commands[i][1] = x;
//				commands[i][2] = y;
				commands[i] = new int[] { command, x, y };
			}

			// 로직 서로소집합을 생성한 후에, 연산에 따라서 처리 후 결과 생성!
			StringBuilder result = new StringBuilder();

			// 서로소 집합을 원소 N개로 초기화
			init(N + 1); // 1~N번까지의 원소를 자기자신으로 초기화!

			// 명령어 M개를 읽고, 명령들을 수행하는 과정...!
			for (int i = 0; i < M; i++) {
				int command = commands[i][0];
				int x = commands[i][1];
				int y = commands[i][2];

				if (command == 0) { // x, y 를 합하라 (union)
					union(x, y);
				} else if (command == 1) { // x, y가 같은 그룹인가
					int root_x = findSet(x);
					int root_y = findSet(y);

					if (root_x == root_y) {
						result.append("1"); // 두개 그룹이 서로 같다!
					} else {
						result.append("0"); // 다르다
					}
				}
			}

			// 출력
			System.out.println("#" + tc + " " + result.toString());
		}
	}
}

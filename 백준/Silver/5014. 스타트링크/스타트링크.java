import java.util.*;
import java.io.*;

public class Main {
	static int F, S, G, U, D, cnt;
	static int[] map, count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 백준
		// 5014. 스타트링크

		// F층의 빌딩
		// G층으로 이동해야함
		// 강호의 위치는 S층
		// 엘레베이터는 U, D 두개 밖에 없음
		// G 층에 도달하려면 버튼을 몇번 눌러야하는지

		st = new StringTokenizer(br.readLine());

		F = Integer.parseInt(st.nextToken()); // 최대 층
		S = Integer.parseInt(st.nextToken()); // 시작 위치
		G = Integer.parseInt(st.nextToken()); // 목적지
		U = Integer.parseInt(st.nextToken()); // 위로 U층
		D = Integer.parseInt(st.nextToken()); // 아래로 D층

		count = new int[F + 1];
		Arrays.fill(count, -1); // 배열을 -1로 초기화하여 방문하지 않았음을 표시

		cnt = 0;
		bfs();
		if (cnt != 0) {
			System.out.println(cnt);
		}
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();

		q.add(S);
		count[S] = 0; // 시작 위치는 0번 클릭

		while (!q.isEmpty()) {
			int curr = q.poll();

			// 목적지에 도착했다면 횟수 출력 후 종료
			if (curr == G) {
				System.out.println(count[curr]);
				return;
			}

			// 1. U버튼을 누르는 경우
			int nextUp = curr + U;
			if (nextUp <= F && count[nextUp] == -1) { // 건물 범위 안이고, 아직 방문 안했다면
				q.add(nextUp);
				count[nextUp] = count[curr] + 1;
			}

			// 2. D버튼을 누르는 경우
			int nextDown = curr - D;
			if (nextDown >= 1 && count[nextDown] == -1) { // 건물 범위 안이고, 아직 방문 안했다면
				q.add(nextDown);
				count[nextDown] = count[curr] + 1;
			}
		}

		// while문이 끝날 때까지 목적지에 도달하지 못했다면
		System.out.println("use the stairs");
	}
}

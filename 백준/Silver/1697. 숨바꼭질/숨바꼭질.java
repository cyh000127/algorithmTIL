import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 수빈이 위치
		K = Integer.parseInt(st.nextToken()); // 동생 위치

		// 1초마다 할 수 있는 행동
		// 1. x+1 / x-1로 이동
		// 2. 2*x로 순간이동
		ans = Integer.MAX_VALUE;
		bfs();

	}

	private static void bfs() {
		// BFS 탐색을 위한 큐. {위치, 시간}을 배열로 저장
		Queue<int[]> queue = new LinkedList<>();
		boolean[] visited = new boolean[100001];

		// 1. 시작점(N)을 0초와 함께 큐에 추가
		queue.add(new int[]{N, 0});
		visited[N] = true;

		while (!queue.isEmpty()) {
		    int[] current = queue.poll();
		    int position = current[0];
		    int time = current[1];

		    // 큐에서 꺼낸 위치가 동생의 위치(K)와 같다면,
		    // 현재까지의 시간이 최단 시간이므로 정답을 출력하고 종료
		    if (position == K) {
		        System.out.println(time);
		        return; // 또는 break;
		    }

		    // 2. 다음 위치로 이동하는 3가지 경우를 계산
		    //  X-1로 이동
		    if (position - 1 >= 0 && !visited[position - 1]) {
		        visited[position - 1] = true;
		        queue.add(new int[]{position - 1, time + 1});
		    }
		    // X+1로 이동
		    if (position + 1 <= 100000 && !visited[position + 1]) {
		        visited[position + 1] = true;
		        queue.add(new int[]{position + 1, time + 1});
		    }
		    //  2*X로 이동
		    if (position * 2 <= 100000 && !visited[position * 2]) {
		        visited[position * 2] = true;
		        queue.add(new int[]{position * 2, time + 1});
		    }
		}
	}
}
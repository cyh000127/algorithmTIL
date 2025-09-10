import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 수빈이 위치
		M = Integer.parseInt(st.nextToken()); // 동생 위치

		visited = new boolean[100_001];
		Queue<int[]> q = new LinkedList<>();

		visited[N] = true;
		q.add(new int[] { N, 0 });

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int location = now[0];
			int time = now[1];

			if (location == M) {
				System.out.println(time);
				break;
			}

			if (location * 2 <= 100_000 && !visited[location*2]) {
				visited[location * 2] = true;
				q.add(new int[] { location * 2, time });
			}
			if (location - 1 >= 0 && !visited[location-1]) {
				visited[location - 1] = true;
				q.add(new int[] { location - 1, time + 1 });

			}
			if (location + 1 <= 100_000 && !visited[location+1]) {
				visited[location + 1] = true;
				q.add(new int[] { location + 1, time + 1 });

			}
		}
	}
}
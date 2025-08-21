import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];

		PriorityQueue<Integer> q = new PriorityQueue<>();
		// 모두 더한 후 뒤에서 부터 큰거 하나씩 빼면 답이 나온다
		// 결국에는 정렬을 해야하는게 아닌지 ?
		// 그렇네
		// 그럼 먼저 정렬을 해보자

		// 오름차순으로 정렬 됐을 것
		int sumAll = 0;
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			q.add(-a);
			sumAll += a;
		}
		int idxsum = sumAll;
		for (int i = 0; i < N; i++) {
			sumAll -= (-q.poll());
			idxsum += sumAll;
		}
		sb.append(idxsum);
		System.out.println(idxsum);
	}
}
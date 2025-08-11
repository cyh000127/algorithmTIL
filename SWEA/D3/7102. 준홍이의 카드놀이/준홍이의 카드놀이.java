import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			// 카드 덱 N과 M
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			Queue<Integer> qN = new LinkedList<Integer>();
			Queue<Integer> qM = new LinkedList<Integer>();

			// 더한 값이 나올때마다 +1 씩하는 N+M크기의 배열
			int[] arr = new int[N + M+1];
			for (int i = 1; i <= N; i++) {
				qN.add(i);

			}
			for (int i = 1; i <= M; i++) {
				qM.add(i);
			}

			for (int i = 1; i <= N; i++) {
				int n = qN.poll();
				for (int j = 1; j <= M; j++) {
					int m = qM.poll();
					arr[n+m]++;
					qM.add(m);
				}
			}
			// 최대 빈도 수 저장
			int max = 0; 
			for(int i = 0 ; i<N+M; i++) {
				max =Math.max(max, arr[i]);
			}
			// 최대 빈도를 나타내는 i 값 sb에 저장
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0 ; i<N+M; i++) {
				if(arr[i]==max) sb.append(" ").append(i);
			}
		System.out.println("#"+tc+sb);
		}
	}
}
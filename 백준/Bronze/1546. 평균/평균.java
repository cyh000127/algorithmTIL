import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 자기 점수중 최댓값을 M이라고 함
		// 모든 점수에 *100/M 했음
		// 이렇게 만든 성적이 있을때 새로운 평균을 구해라

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];

		int highscore = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			highscore = Math.max(highscore, arr[i]);
		}
		double avg = 0;
		for (int i = 0; i < N; i++) {
			avg +=  ((double)arr[i] / (double)highscore) * 100.0;
		}
		avg /= (double) N;
		System.out.println(avg);
	}
}

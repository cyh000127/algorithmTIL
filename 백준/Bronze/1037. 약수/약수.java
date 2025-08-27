import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		// N은 약수의 개수이고
		// 그 다음 입력이 약수들 (약수가 순서대로 주어지지 않음)
		StringTokenizer st = new StringTokenizer(br.readLine());

		int minv = Integer.MAX_VALUE; // 최소값
		int maxv = Integer.MIN_VALUE; // 최대값 
		
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			//최소, 최대를 찾고
			maxv = Math.max(maxv, a);
			minv = Math.min(minv, a);
		}
		//둘을 곱해서 출력하면 정답
		sb.append(maxv*minv);
		System.out.println(sb.toString().trim());
	}
}

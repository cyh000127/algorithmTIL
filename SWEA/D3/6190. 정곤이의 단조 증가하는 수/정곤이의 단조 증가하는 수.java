import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {

			int N = Integer.parseInt(br.readLine()); // 정수의 개수 N
			StringTokenizer st = new StringTokenizer(br.readLine()); // N개의 정수 나열

			// 단조증가 = 이전수보다 크거나 같은 상태로 계속 수가 나열 되는것
			// Ai x Aj값이 단조 증가하는 수
			// 십의자리가 일의자리보다 작거나 같아야함
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			// 최종 정답을 보관하는 변수
			// 단조증가가 없으면 -1 출력
			int ans = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i == j) continue; 
					int target= arr[i] * arr[j];
					boolean isTrue = true;
					String str = String.valueOf(target);
					
					for(int k = 0; k<str.length()-1; k++) {
						if(str.charAt(k)>str.charAt(k+1)) {
							isTrue = false;
							break;
						}
					}
					if(isTrue) {
						ans = Math.max(ans, target);
					}
				}
			}
			System.out.println("#" + test + " " + ans);
		}
	}

}

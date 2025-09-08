import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// '-'와 '|'가 이어진건 하나 , 이어지지 않은건 따로로 총 몇개인지 새라

		// y축(세로) N
		// x축(가로) M

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] arr = new String[N];
		// 가로 , 세로 한번씩 반복을 돌려서 찾으면 되는거 아님 ?

		int count = 0;
		for (int i = 0; i < N; i++) { // 가로로 돌리는 반복문
			String str = br.readLine();
			st = new StringTokenizer(str, "|"); // | 을 기준으로 string 자르기

			count += st.countTokens(); // 가로의 - 통나무 개수를 세서 count에 저장
			arr[i] = str; // | 개수를 세기 위해 배열에 저장
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				char now = arr[i].charAt(j);

				if (now == '|') {
					if (i == 0 || arr[i - 1].charAt(j) == '-') { // 아래나 가장 위가 '-' 라면 새로운 막대
						
						count++; // 될때마다 count ++;
					}
				}
			}
		}
		
		System.out.println(count);
	}
}

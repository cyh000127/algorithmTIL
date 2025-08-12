import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {

			// 전등 개수 N
			int N = Integer.parseInt(br.readLine());
			// 이전 before과 이후 after을 하나씩 선언
			int[] beforeLamp = new int[N];
			int[] afterLamp = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				beforeLamp[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				afterLamp[i] = Integer.parseInt(st.nextToken());
			}

			// 1이나 0 의 반복이 끊길 때마다 그 자리에서 스위치를 누른거임
			// 즉 숫자가 연속되지 않을때의 switchCnt값을 구하면 됨
			//
			int switchCnt = 0;
			// 먼저 기존 램프 상태와 이후 램프 상태가 달라지는 장소를 찾음
			for (int i = 0; i < N; i++) {
				if (beforeLamp[i] != afterLamp[i]) {
					for (int j = i; j < N; j++) {
						beforeLamp[j] = 1 - beforeLamp[j];
					}
					switchCnt++;
				}
			}
			System.out.println("#" + test + " " + switchCnt);
		}

	}
}

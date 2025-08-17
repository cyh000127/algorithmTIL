import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스 지정
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 퍼즐 맵 크기 N
			int K = Integer.parseInt(st.nextToken()); // 단어 길이 K

			// 일단 2차원 배열에 집어 넣어
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 길이가 K 인 단어가 알맞게 들어갈 수 있는 장소를 찾아야함
			// -> 앞 뒤가 0이거나 끝부분인 장소를 찾아야 들어갈 수 있음
			// 세로 , 가로 방향을 따로 계산하는게 빠름

			int cnt = 0;

			// 가로 방향 검사
			for (int i = 0; i < N; i++) {
				int count1 = 0;
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1) {
						count1++;
					} else { // 0이 나오면 흰색 칸의 연속이 끊김
						if (count1 == K) {
							cnt++;
						}
						count1 = 0;
					}
				}
				// 행의 끝에서 연속된 흰색 칸이 K개일 경우를 처리
				if (count1 == K) {
					cnt++;
				}
			}

			// 세로 방향 검사
			for (int j = 0; j < N; j++) {
				int count1 = 0;
				for (int i = 0; i < N; i++) {
					if (arr[i][j] == 1) {
						count1++;
					} else { // 0이 나오면 흰색 칸의 연속이 끊김
						if (count1 == K) {
							cnt++;
						}
						count1 = 0;
					}
				}
				// 열의 끝에서 연속된 흰색 칸이 K개일 경우를 처리
				if (count1 == K) {
					cnt++;
				}
			}

			System.out.println("#" + test + " " + cnt);
		}
	}
}
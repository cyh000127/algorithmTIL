import java.io.*;
import java.util.*;

public class Solution {

	// 우 우상, 우하, 상, 하
	static int[] dr = { 0, -1, 1, -1, 1 };
	static int[] dc = { 1, 1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {

			// 오목판의 크기 N
			int N = Integer.parseInt(br.readLine());
			char[][] arr = new char[N][N];

			// 오목판에 오목을 둠
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			// o 가 5개 이어져 있음 -> 이긴 것이므로 YES 출력
			// 그 외 모든 상황은 -> NO 출력
			String ans = "NO";
			boolean isOmok = false; // 오목을 찾았는지?
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 'o') {
						for (int d = 0; d < 5; d++) {
							int count = 1; // 오목 돌 계산 
							for (int pow = 1; pow <= 4; pow++) {
								int nr = dr[d] * pow + i;
								int nc = dc[d] * pow + j;
								if ( nr >= N || nr < 0 || nc >= N || nc < 0 || arr[nr][nc] != 'o') {
									isOmok = false;
									break;
								}
								count++;
							}
								if (count == 5) {
									ans = "YES";
									isOmok = true;
									break;
								}
							}
						}
					if(isOmok) break;
					}
				if(isOmok) break;
				}
			System.out.println("#" + test + " " + ans);
			}
		}
	}

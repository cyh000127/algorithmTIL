import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 수학 여행 참가 학생 수 N
		// 한 방에 배정할 수 있는 최대 인원 수 K
		// 성별, 학년 // S, Y
		// 한방에는 최소 K 명이 들어갈 수 있음
		// 같은 학년 + 같은 성별 이여야지 한 방을 사용하게 되는 것
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 학생 수 N
		int K = Integer.parseInt(st.nextToken()); // 방 당 최대 인원 수

		// 학년, 성별 2차원 배열 선언
		int[][] arr = new int[7][2]; // 학년 1~6까지 / 성별

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			// 해당 성별, 학년에 학생수 1씩 추가
			arr[grade][gender]++;
		}

		int roomCnt = 0;
		for (int i = 1; i <= 6; i++) {
			for (int j = 0; j < 2; j++) {
				if (arr[i][j] % K == 0)
					roomCnt += arr[i][j] / K;
				else
					roomCnt += (arr[i][j] / K) + 1;
			}
		}
		System.out.println(roomCnt);
	}
}

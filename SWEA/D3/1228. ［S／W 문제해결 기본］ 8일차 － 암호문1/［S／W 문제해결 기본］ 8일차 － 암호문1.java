import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스 10개라고 문제에서 주어짐
		for (int test = 1; test <= 10; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken()); // 원본 암호문의 개수

			// 한 테스트 케이스에 4줄이 주어짐
			// 첫줄은 원본 암호문 개수 N
			// 두번째 줄은 원본 암호문
			// 세번째 줄은 명령어의 개수
			// 네번째 줄은 명령어

			st = new StringTokenizer(br.readLine());
			LinkedList<Integer> list = new LinkedList<Integer>();

			// list에 암호문들 집어 넣기
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			// 명령어의 개수 M
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());

			// 명령어 해석
			// I가 나온 후 x 번째 idx 에서
			// y 개의 숫자를 삽입 s는 y개의 수 배열
			// for i < M
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				if (st.nextToken().charAt(0) == 'I') {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						list.add(x, Integer.parseInt(st.nextToken()));
						x++;
					}

				}

			}
			// 출력
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test);
			for (int i = 0; i < 10; i++) {
				sb.append(" ").append(list.get(i));
			}
			System.out.println(sb);
		}
	}
}

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			// O와 B라는 로봇이 버튼을 각각 눌러야함
			// 1에서 100까지 100개의 버튼이 존재한다. -> 로봇은 1번에서 시작 함
			// 테스트 케이스에서 처음 주어지는 숫자는 눌러야하는 버튼 개수
			// 그 다음부터 누가 어떤 버튼을 눌러야 하는지가 주어짐
			// 한번에 하나의 동작만 할 수 있기 때문에 B 2 라면 B의 이동 + 버튼 누르기 까지 3의 시간이 필요함(cnt++)
			// A와 B는 독립된 개체로 따로 움직일 수 있음
			// 주어지는 테스트케이스의 실행 최소 시간을 구하라
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			// 위치를 각각 계산해줌
			int B_position = 1;
			int O_position = 1;
			// 이동 시간을 각각 계산해줌
			int B_time = 0;
			int O_time = 0;
			// 총 걸린 시간
			int minTime = 0;

			for (int i = 0; i < N; i++) {
				String moveTarget = st.nextToken();
				int button = Integer.parseInt(st.nextToken());

				if (moveTarget.equals("B")) {
					// 위치까지 이동하는데 걸리는 시간
					int moveLoc = Math.abs(button - B_position);
					// 기존에 걸린시간과 이번에 위치 까지 이동한 시간을 합한 후 지금까지 걸린 시간과 비교함
					// 지금까지 걸린 시간과 위치 까지 이동한 시간중 더 큰 것을 저장
					int moveTime = B_time + moveLoc;
					minTime = Math.max(minTime, moveTime);

					minTime++; // 버튼 누르는 시간

					// 이동한 위치로 갱신
					B_time = minTime;
					B_position = button;

				} else if (moveTarget.equals("O")) {
					// O도 똑같이 반복
					int moveLoc = Math.abs(button - O_position);
					int moveTime = O_time + moveLoc;
					minTime = Math.max(minTime, moveTime);

					minTime++; // 버튼 누르는 시간

					// 위치 갱신
					O_time = minTime;
					O_position = button;

				}

			}
			System.out.println("#" + test + " " + minTime);
		}
	}

}

import java.util.*;
import java.io.*;

/**
 * 20207 달력
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 연속된 날에 일정이 하나 이상 있으면 "연속된 일정"
		// 모든 일정은 하나의 직사각형에 포함되어야 함 -> 하나의 스티커
		// 모든 일정 가질 수 있게 코팅지를 자름

		// 일정 = 시작날짜 , 끝날짜를 포함
		// 시작일이 가장 앞선 일정부터 차례로 채움
		// 시작일이 같을 경우 일정의 기간이 긴 것이 먼저 채움
		// 일정은 최상단에 배치
		// 하나의 세로 길이는 1
		// 하루 폭 1
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[366];

		int maxDay = 0;
		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			for (int j = start; j <= end; j++) {
				arr[j]++;
			}

			if (maxDay < end) {
				maxDay = end;
			}
		}

		int maxLength = 0;
		int cnt = 0; // 높이

		int ans = 0;
		for (int i = 1; i < maxDay + 1; i++) {

			if (arr[i] > 0) {
				maxLength++;
				if (cnt < arr[i]) {
					cnt = arr[i];
				}
			}

			if (cnt != 0 && (arr[i] == 0 || i == maxDay)) {
				ans += cnt * maxLength;
				maxLength = 0;
				cnt = 0;
			}
		}

		System.out.println(ans);

	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 스위치 개수 N
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 학생 수 stu
		int stu = Integer.parseInt(br.readLine());

		// 남자는 1, 여자는 2
		for (int i = 0; i < stu; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int card = Integer.parseInt(st.nextToken());

			if (gender == 1) { // 남학생이라면
				// 남학생이 받은 수(card)의 배수 스위치를 조작
				for (int j = card; j <= N; j += card) {
					// 스위치 번호(j)는 1부터 시작하므로, 배열 인덱스(j-1)로 접근
					arr[j - 1] = (arr[j - 1] + 1) % 2;
				}
			} else if (gender == 2) { // 여학생이라면
				// 여학생이 받은 번호(card)를 중심으로 대칭 구간을 찾음
				// 스위치 번호(card)는 1부터 시작하므로, 배열 인덱스(idx)로 변환
				int idx = card - 1;

				// 대칭 구간의 시작과 끝을 찾는 변수
				int left = idx;
				int right = idx;

				// 가장 큰 대칭 구간을 찾기 위해 좌우로 확장
				// 배열 범위를 벗어나지 않고, 양옆의 스위치 상태가 같은 경우만 확장
				while (left > 0 && right < N - 1 && arr[left - 1] == arr[right + 1]) {
					left--;
					right++;
				}

				// 찾아낸 대칭 구간(left부터 right까지)의 모든 스위치 상태를 변경
				for (int j = left; j <= right; j++) {
					arr[j] = (arr[j] + 1) % 2;
				}
			}
		}

		// 최종 스위치 상태를 문제에서 요구하는 형식에 맞게 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(arr[i]);
			// 20번째마다 줄바꿈 추가
			if ((i + 1) % 20 == 0) {
				sb.append('\n');
			} else {
				// 마지막 스위치가 아니면 공백 추가
				if (i < N - 1) {
					sb.append(' ');
				}
			}
		}
		System.out.println(sb.toString());
	}
}
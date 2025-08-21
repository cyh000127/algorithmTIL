import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int s = Integer.parseInt(br.readLine());

		int cnt = 0;
		// 5kg 봉지 , 3kg 봉지 있는데 가장 작은단위의 봉지를 가져가는 경우를 계산해라
		// 어떠한 방식으로도 들고갈 수 없다면 -1을 출력하라
		// 최소공배수 문제 ?
		while (s > 0) {
			if (s % 5 == 0) { // 설탕이 5의 배수가 되는 순간 5로 나눈 후 순회 종료
				cnt += s / 5;
				s = 0;
				break;
			}
			s -= 3;
			cnt++;
		}
		if (s == 0) {
			sb.append(cnt);
		} else {
			sb.append(-1);
		}
		System.out.println(sb);
	}

}

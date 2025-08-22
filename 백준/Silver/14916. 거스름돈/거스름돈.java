import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 2원과 5원으로만 거스름돈을 달라고 함
		// 동전을 최소 개수로 줄 수있는 방법을 찾아주는 프로그램을 작성
		// 거슬러 줄 수 없다면 -1 출력

		int money = Integer.parseInt(br.readLine());

		// 먼저 단순 맥시멈 5원개수를 찾는다.
		int coin5 = money / 5;
		boolean is = false;
		while (true) {
			// 5원개수가 음수로 가는 순간부터 불가능한 조합이 되기 떄문에 -1 출력
			if (coin5 < 0) {
				sb.append(-1);
				break;
			}
			// 5원 개수를 하나씩 빼면서 값이 만들어질 수 있는 수를 찾는다.
			// 찾으면 출력후 break;
			if ((money - (coin5 * 5)) % 2 == 0) {
				sb.append(((money - (coin5 * 5)) / 2) + coin5);
				break;
			}

			// 코인을 하나씩 빼준다.
			coin5--;
		}
		System.out.println(sb);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 0과 1로만 구성된 문자열 S가 있음
		// S에 있는 모든 숫자를 전부 같게 만드려고 함
		// S에서 연속된 하나 이상의 숫자를 잡고 모두 뒤집는게 가능
		// 0->1 cnt랑 1->0 cnt 비교해서 math.min 하면 됨
		String str = br.readLine();

		int cnt0 = 0; // 0->1
		int cnt1 = 0; // 1->0

		if (str.charAt(0) - '0' == 0)
			cnt0++; // 시작하는 장소의 집단이 0이라면
		else
			cnt1++; // 나중에 1을 0으로 바꿀때 한 번 더 실행하기 때문에

		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) != str.charAt(i - 1)) {
				if (str.charAt(i) == '0') { // 0의 집단로 바뀌는 상황을 찾음
					cnt0++;
				} else // 1의 집단 찾음
					cnt1++;
			}
		}
		sb.append(Math.min(cnt1, cnt0));
		System.out.println(sb);
	}
}

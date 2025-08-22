import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// +, - 밖에 없기때문에
		// -를 기준으로 뒤에 값이 제일 크면 되는 거아님 ?
		// -를 기준으로 자르는게 이득일거같은데 ? 이유 ( st[0] 에서 st[1]부터 다 빼면 됨)
		// 예시로 55 - 50 +40 은 55에서 90 빼는거임

		StringTokenizer st = new StringTokenizer(br.readLine(), "-");

		// 55 / 50 + 40
		// 10+20+30+40
		// 이런식으로 쪼개질텐데
		// string 형태의 + 식을 해결하긴 해야함
		// 앞에 + 식을 해결해보자
		int a = 0;
		int suma = 0;

		String str = st.nextToken();
		// 반복문으로 돌려서 덧셈 완료
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) - '0' >= 0) {
				a *= 10;
				a += (str.charAt(i) - '0');
			} else {
				suma += a;
				a = 0;
			}
			if (i == str.length() - 1) {
				suma += a;
				a = 0;
			}
		} // 첫 +

		int ans = suma;
//		System.out.println(suma); // suma 디버그용
//		System.out.println(a); // suma 디버그용
//		System.out.println(ans); // suma 디버그용

		int mina = 0;
		while (st.hasMoreTokens()) {
			String d = st.nextToken();
			// 반복문으로 돌려서 덧셈 완료

			for (int i = 0; i < d.length(); i++) {
				if (d.charAt(i) - '0' >= 0) {
					a *= 10;
					a += (d.charAt(i) - '0');
				} else {
					mina += a;
					a = 0;
				}
				if (i == d.length() - 1) {
					mina += a;
					a = 0;
				}

			}

		}
		ans -= mina;

		sb.append(ans);
		System.out.println(sb);
		// 토큰이 몇개가 나올지 모르기 때문에 while 문을 써야함

	}
}

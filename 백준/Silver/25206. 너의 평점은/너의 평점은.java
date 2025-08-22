import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 각 줄에 과목명 학점 과목평점 이렇게 나온다
		// (과목 평점 * 학점 )/ 과목 수
		// P인 과목은 계산에서 제외할것
		// 학점을 소수점 6자리 까지 표현하여라

		// 과목 수 20개
		double sumscore = 0.0;
		// 학점의 총합
		int score = 0;

		for (int i = 0; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// ST를 통해 공백을 끊어 버림
			st.nextToken(); // 과목명은 버려도 됨
			// 학점 a
			double a = Double.parseDouble(st.nextToken());
			String str = st.nextToken();
			// 평점 b;
			double b = 0.0;
			// 패스면 계산에서 제외
			if (str.charAt(0) == 'P') {
				continue;
			}
			score += a;
			// 처음 영어로 학점을 부여
			if (str.charAt(0) == 'A') {
				b = 4.0;
			} else if (str.charAt(0) == 'B') {
				b = 3.0;
			} else if (str.charAt(0) == 'C') {
				b = 2.0;
			} else if (str.charAt(0) == 'D') {
				b = 1.0;
			} else if (str.charAt(0) == 'F') {
				b = 0.0;
			}
			// 그다음 나오는 +나 0으로 인해 0.5를 더해줌
			if (b != 0.0 && str.charAt(1) == '+') {
				b += 0.5;
			}
			// 학점과 평점을 곱해서 sumscore에 저장해둠
			sumscore += a * b;
		}
		// 평점을 구해야합니다. 소수점 6자리까지
		String ans = String.format("%.6f", sumscore / score);
		sb.append(ans);
		System.out.println(sb);
	}
}

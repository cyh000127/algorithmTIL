import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 수의 범위가 long임
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());

		// 1. (b - a + 1) 크기의 boolean 배열 선언
		// checks[i]는 숫자 a+i를 의미함
		int range = (int) (b - a + 1);
		boolean[] checks = new boolean[range];

		// 2. 2의 제곱부터 sqrt(b)의 제곱까지 반복
		// i*i가 b보다 커지면 더 이상 확인할 필요 없음
		// i는 int 범위를 넘을 수 있으므로 long으로 선언
		for (long i = 2; i * i <= b; i++) {
			long square = i * i;

			// 3. a 이상인 첫 번째 제곱수 배수 찾기 (시작점)
			// (a / square) 올림 * square 와 동일
			// a보다 크거나 같은 제곱수 배수를 찾기
			long start = ((a - 1) / square + 1) * square;

			// 4. 찾은 시작점부터 b까지 square의 배수들을 모두 true로 체크
			for (long j = start; j <= b; j += square) {
				// j는 a, b 범위의 실제 숫자이므로 배열 인덱스로 변환
				// j - a는 항상 int 범위 내에 있음
				checks[(int) (j - a)] = true;
			}
		}

		// 5. checks 배열에서 false인(제곱 ㄴㄴ 수) 개수 세기
		int count = 0;
		for (int i = 0; i < range; i++) {
			if (!checks[i]) {
				count++;
			}
		}

		System.out.println(count);
	}
}
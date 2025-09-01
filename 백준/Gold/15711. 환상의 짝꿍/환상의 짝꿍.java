import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static boolean[] isPrime = new boolean[2_000_001];
	public static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		eratosthenes();

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());

			long sum = A + B;

			//골드바흐의 추측을 통해 알 수 있음
			// 4 보다 작은 수는 소수의 합으로 나타낼 수 없음
			// 2보다 큰 짝수들은 무조건 소수의 합으로 나타낼 수 있음
			// 2보다 큰 홀수들의 소수 여부를 계산하는 로직이 필요함
			// 홀수들은 무조건 2를 사용해야함
			// -2 를 했을 때의 값이 소수라면 YES
			
			if (sum < 4) {
				sb.append("NO").append("\n");
			} else if (sum % 2 == 0) {
				sb.append("YES").append("\n");
			} else {
				if (check(sum - 2)) {
					sb.append("YES").append("\n");
				} else {
					sb.append("NO").append("\n");
				}
			}
		}

		System.out.println(sb);
	}

	public static boolean check(long x) {
		if (x <= 2_000_000) //x가 200만보다 작으면 int 범위로 해결 가능 (isPrime의 역결과를 출력)
			return !isPrime[(int) x];

		for (int i = 0; i < list.size(); i++) {
			if (x % list.get(i) == 0) {// list의 요소를 나눠서 나눠진다면 그것은 가능하다는 뜻
				return false;
			}
		}

		return true;
	}

	public static void eratosthenes() {
		isPrime[0] = isPrime[1] = true;

		for (int i = 2; i <= 2_000_000; i++) {
			if (!isPrime[i]) {
				list.add(i);
				for (int j = i * 2; j <= 2_000_000; j += i)
					isPrime[j] = true;
			}
		}
	}
}
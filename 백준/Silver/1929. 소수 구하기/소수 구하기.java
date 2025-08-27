import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		// 에라토스테네스의 체
		// a~ b 사이의 소수를 구하시오
		// 에라토스테네스의 체는 루트 b만큼의배수만 체크하면 소수를 구할 수 있다는 논리이므로
		// finalnum의 제곱근이 정수로 딱떨어지면 그것으로, 그게 아니라면 +1 해줌
		boolean[] prime = new boolean[b + 1];

		// 1과 0은 소수가 될 수 없음
		prime[1] = prime[0] = true; // 배열을 b+1 크기로 만들었기 때문에

		for (int i = 2; i*i <= b; i++) {
			if (!prime[i]) {
				for (int j = i * i; j <= b; j += i) {
					prime[j] = true;
				}
			}
		}
		// a부터 b까지 false면 출력
		for (int i = a; i <= b; i++) {
			if (!prime[i])
				System.out.println(i);
		}
	}
}

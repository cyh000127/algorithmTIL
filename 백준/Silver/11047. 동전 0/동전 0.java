import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		// 동전의 종류가 N만큼 있고 총 target만큼 만들어야한다면
		// 어떤 동전을 어떻게 더해야 최소 개수의 동전만 사용해서 목적을 달성할 수 있을까
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		// 동전의 종류가 오름차순으로 주어진다
		// 배열에 저장했으니 배열의 뒤에서부터 나눠서 몫이 있는게 가장 큰 동전
		int coincnt = 0;
		for (int i = N - 1; i >= 0; i--) {
			int a = arr[i];
			if (target / a > 0) {
				coincnt += target / a;
				target = target % a;

				if (target % a == 0) {
					break;
				}
			}

		}

		sb.append(coincnt);
		System.out.println(sb);
	}

}

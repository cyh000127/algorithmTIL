import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 연속된 숫자가 계속 같거나 커지거나
		// 작거나 같아지는 최대값을 구해라
		int number = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 배열 선언
		int[] arr = new int[number];
		for (int i = 0; i < number; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 1;
		int maxplus = 0;
		int maxminus = 0;
		for (int i = 1; i < number; i++) {
			if (arr[i - 1] <= arr[i]) {
				cnt++;
			} else {
				maxplus = Math.max(maxplus, cnt);
				cnt = 1;
			}
		}
		maxplus = Math.max(maxplus, cnt);
		cnt = 1;
		for (int i = 1; i < number; i++) {
			if (arr[i - 1] >= arr[i]) {
				cnt++;
			} else {
				maxminus = Math.max(maxminus, cnt);
				cnt = 1;
			}
		}
		maxplus = Math.max(maxplus, cnt);
		
//		디버그용
//		System.out.println(maxminus + " " + maxplus);
		System.out.println(Math.max(maxminus, maxplus));

	}
}

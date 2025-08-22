import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// X가 있다면
		// X * 2 ;
		// X*10 + 1;
		// 두개의 방법을 반복해서 두번째 입력을 만들어줘야함

		// 반대로 생각해보자
		// toN % 2 == 0 이거나
		// toN의 끝자리가 1이여야함

		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int toN = Integer.parseInt(st.nextToken());

		// toN이 2로 나눠지면 나누고
		// 만약 끝의 자리 수가 1이라면 1을 제거해줌
		// cnt ++ 로 카운트 하고
		// 아닌경우 탈출

		int cnt = 1;
		while (toN != x) {
			if (toN < x || (toN % 10 != 1 && toN % 2 != 0)) {
				cnt = -1;
				break;
			} else if (toN % 2 == 0 && toN > 0) {
				toN /= 2;
				cnt++;
//				System.out.println("2 나누기 " + toN); // 디버그용 코드
			} else if (toN % 10 == 1) {
				toN /= 10; // 정수 계산이기때문에 소수점은 버려짐
				cnt++;
//				System.out.println("1 제거하기  " + toN); // 디버그용 코드
			}
		}
		sb.append(cnt);
		System.out.println(sb);
	}
}

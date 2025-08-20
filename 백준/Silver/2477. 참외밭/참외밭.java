import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 처음 입력 참외 개수
		// 2~7줄까지의 입력은 임의의 한 점을 기준으로 반시계 방향으로 삥 도는 듯한 모양을 만들어줌
		// 밭의 모양은 ㄱ 자임
		// 생각
		// 직사각형에서 ㄱ자에 해당하지 않는 부분의 넓이를 뺀 후 *참외 개수 하면 답 나올듯

		int kmelon = Integer.parseInt(br.readLine());

		// ← 1
		// → 2
		// ↓ 3
		// ↑ 4
		// 두개의 면은 항상 최고로 큰 값이 나옴
		// 방향은 항상 6개가 주어짐

		// 방향 배열 + 길이 배열 하나씩
		int[] dir = new int[6];
		int[] dis = new int[6];

		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int diri = Integer.parseInt(st.nextToken());
			int disi = Integer.parseInt(st.nextToken());
			dir[i] = diri;
			dis[i] = disi;
		}

		// 꺾이는거 없이 한변이 온전히 있는 변에 붙어있는 변은 잘린 면이 아님
		// -> 붙어있는 idx를 제외한 나머지 idx를 찾아서 곱하면 걔네가 잘린 면의 넓이
		int solo1 = 0;
		int solo2 = 0;
		for (int i = 0; i < 6; i++) {
			boolean isTrue = false;
			for (int j = 0; j < 6; j++) {
				if (i == j)
					continue;
				if (dir[i] == dir[j]) {
					isTrue = true;
				}
			}
			if (!isTrue) {
				if (solo1 == 0) {
					solo1 = i;
				} else if (solo1 != 0)
					solo2 = i;
			}
			if (solo2 != 0)
				break;
		}
//		System.out.println(solo1 + " " + solo2);
		// solo2 까지 찾았다면 붙어있는 변을 찾는다.
		// 로직상 무조건 solo1이 solo2보다 작을 수밖에없음
		// idx를 찾아야한다.
		int near1 = 0;
		int near2 = 0;
		// near 찾기
		if ((solo1 == 5 && solo2 == 0) || (solo2 == 5 && solo1 == 0)) {
			near1 = 1;
			near2 = 4;
		} else if (solo1 == 0 || solo2 == 0) {
			near1 = 5;
			near2 = 2;
		} else if (solo2 == 5 || solo1 == 5) {
			near1 = 3;
			near2 = 0;
		} else if (solo1 > solo2) {
			near1 = solo1 + 1;
			near2 = solo2 - 1;
		} else {
			near1 = solo1 - 1;
			near2 = solo2 + 1;

		}
//		System.out.println(near1 + " " + near2);
		// near 두개를 찾았다면 이제 그 반대에 해당하는 둘을 찾자
		int no1 = 0;
		int no2 = 0;

		for (int i = 0; i < 6; i++) {
			if (i == near1 || i == near2)
				continue;
			if (dir[near1] == dir[i]) {
				no1 = i;
			} else if (dir[near2] == dir[i])
				no2 = i;
		}
//		System.out.print(no1 + " " + no2);
		int ans = kmelon * (dis[solo1] * dis[solo2] - dis[no1] * dis[no2]);
		System.out.println(ans);
	}

}

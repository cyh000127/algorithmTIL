import java.util.*;
import java.io.*;
import java.lang.Integer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			// 3장의 카드가 연속된 카드 -> run
			// 3장의 카드가 동일한 번호 -> triplet

			// 6장의 카드가 run + triplet -> baby gin

			// 6자리 수를 입력받아 baby gin 여부를 판별하라
			boolean ans = false;
			String str = br.readLine();

			int[] arr = new int[10]; // 0 ~ 9

			for (int i = 0; i < 6; i++) {
//				System.out.println(str.charAt(i));
				arr[str.charAt(i) - '0']++; // 해당하는 배열에 +1
			}
			int cnt = 6;
			// triplet 조사
			for (int i = 0; i < 10; i++) {
				if (arr[i] / 3 == 2) {
					cnt -= 6;
				} else if (arr[i] / 3 == 1) {
					arr[i] -= 3;
					cnt -= 3;
				}
			}

			// run 조사
			for (int i = 0; i < 10; i++) {
				if (arr[i] > 0) {
					if (i < 8 && arr[i] == 2) {
						for (int j = i; j < i + 3; j++) {
							arr[j] -= 2;
							cnt -= 2;
						}
					} else if (i < 8 && arr[i] == 1) {
						for (int j = i; j < i + 3; j++) {
							arr[j]--;
							cnt--;
						}
					} else {
						ans = false;
						break;
					}
				}
			}

			// 6개의 수가 모두 없어졌다면 ans는 true
			if (cnt == 0) {
				ans = true;
			}

			System.out.println("#" + test + " " + ans);
		}

	}
}
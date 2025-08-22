import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 후보가 N명
		// 마을의 주민 M명이 있음
		// 다솜이가 기호 1번인데
		// 몇명을 세뇌해야 자신이 당선될 수 있을까

		// ArrayList로 풀면 어떨까 아니? 의미 없는듯
		// 그냥 자료구조가 아닌 점화식을 써야할것 같음
		// 다른 후보의 수가 자신을 찍을 사람 수보다 많다면
		// 그 후보를 -1 해서 자신을 +1
		// 제일 높지만 같은 후보가 있을경우 +1 -> return
		// 자신이 혼자 제일 높다면 return
		// 다솜이의 득표수
		int N = Integer.parseInt(br.readLine());

		if (N == 1) {
			System.out.println(0);
			return;
		}

		int dasom = Integer.parseInt(br.readLine());
		int[] others = new int[N - 1];
		for (int i = 0; i < N - 1; i++) {
			others[i] = Integer.parseInt(br.readLine());
		}

		int mindControl = 0;

		while (true) {
			// 다른 후보들 중 가장 많은 표를 가진 후보의 표 수와 인덱스를 찾습니다.
			int maxVotes = -1;
			int maxIndex = -1;
			for (int i = 0; i < N - 1; i++) {
				if (others[i] > maxVotes) {
					maxVotes = others[i];
					maxIndex = i;
				}
			}

			// 다솜이의 표가 다른 후보들 중 가장 많아지면 반복을 종료합니다.
			// 동점일 경우에도 표를 뺏어야 하므로 '>'로 비교
			if (dasom > maxVotes) {
				break;
			}

			// 가장 많은 표를 가진 후보의 표를 뺏어옵니다.
			others[maxIndex]--;
			dasom++;
			mindControl++;
		}

		System.out.println(mindControl);
	}
}
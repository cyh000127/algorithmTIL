import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		String[] word = new String[T];
		for (int i = 0; i < T; i++) {
			word[i] = br.readLine();
		}

		// 1. 커스텀 정렬: 길이순 -> 사전순
		Arrays.sort(word, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() != s2.length()) {
					return s1.length() - s2.length();
				}
				return s1.compareTo(s2);
			}
		});

		// 2. 중복 제거 및 출력
		sb.append(word[0]).append('\n');
		for (int i = 1; i < T; i++) {
			// 이전 단어와 현재 단어가 다르면 출력
			if (!word[i].equals(word[i - 1])) {
				sb.append(word[i]).append('\n');
			}
		}

		System.out.println(sb);
	}
}
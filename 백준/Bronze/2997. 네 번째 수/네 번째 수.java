import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[3];

		for (int i = 0; i < 3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int[] s = new int[2];
		for (int i = 0; i < 2; i++) {
			s[i] = arr[i + 1] - arr[i];
		}

		
		if (s[0] == s[1]) {
			System.out.println(arr[2] + s[0]);
		} else if (s[0] > s[1]) {
			System.out.println(arr[0] + s[1]);
		} else {
			System.out.println(arr[1] + s[0]);
		}
	}
}
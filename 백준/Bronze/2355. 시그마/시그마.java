import java.util.*;
import java.io.*;

/**
 * 2355 시그마
 */
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		long A = Math.min(N, M);
		long B = Math.max(N, M);
		long sum = (A + B) * ((B - A + 1) / 2);
		
		if((B - A + 1) % 2 != 0) {
			sum += (A + B) / 2;
		}
		System.out.println(sum);
	}

}
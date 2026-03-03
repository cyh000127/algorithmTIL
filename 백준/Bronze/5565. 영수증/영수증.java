import java.util.*;
import java.io.*;

/**
 * 5565 영수증
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		for (int i = 0; i < 9; i++)
			total -= Integer.parseInt(br.readLine());
		System.out.println(total);
	}
}
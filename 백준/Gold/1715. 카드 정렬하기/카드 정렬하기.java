import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int a = Integer.parseInt(br.readLine());

		for (int i = 0; i < a; i++) {
			pq.add(Integer.parseInt(br.readLine()));

		}

		int Total = 0;
		while (pq.size() > 1) {
			int sum = pq.poll() + pq.poll();
			Total += sum;
			pq.add(sum);
		}

		System.out.println(Total);
	}
}
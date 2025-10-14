import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int a = Integer.parseInt(br.readLine());

		for (int i = 0; i < a; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < a; j++) {
				pq.add(-Integer.parseInt(st.nextToken()));
			}
		}
		for(int i =1; i<a;i++) {
			pq.poll();
		}
		System.out.println(-pq.poll());
	}
}
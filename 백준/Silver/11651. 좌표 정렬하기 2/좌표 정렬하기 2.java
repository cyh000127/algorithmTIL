import java.io.*;
import java.util.*;

class dot {
	int x;
	int y;

	dot(int a, int b) {
		x = a;
		y = b;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 2차원 배열
		// 1. y가 증가하는 순서
		// 2. x가 증가

		int T = Integer.parseInt(br.readLine());

		dot[] a = new dot[T];
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			a[i] = new dot(x, y);
		}

		Arrays.sort(a, new Comparator<dot>() {
			@Override
			public int compare(dot o1, dot o2) {
				if(o2.y ==o1.y) {
					return o1.x - o2.x;
				}
				return o1.y - o2.y;
			}
		});
		
		for(int i = 0 ; i<T; i++) {
		System.out.println(a[i].x +" "+a[i].y);
		}
	}
}

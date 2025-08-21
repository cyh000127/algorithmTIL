import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 가로 길이 x
		// 세로 길이 y
		// 상점의 개수 store
		// 상점의 위치
		// 마지막 줄에 동근이 위치
		// 꼭짓점에는 상점이나 동근이가 위치할 수 없음

		// 동근이의 위치와 각 상점 사이의 최단 거리 합을 구하여라

		// 각 위치를 알릴 때
		// 1 북쪽 2 남쪽
		// 3 서쪽 4 동쪽
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		// 상점의 개수
		int store = Integer.parseInt(br.readLine());

		// 위치 저장
		// x 는 왼쪽부터 셈
		// y 는 위에서 아래로 셈
		int[] arr = new int[store];
		// 동서남북 저장
		int[] dir = new int[store];

		for (int i = 0; i < store; i++) {
			st = new StringTokenizer(br.readLine());
			dir[i] = Integer.parseInt(st.nextToken());
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 동근이의 위치가 마지막에 주어지기 때문에
		// 다른 수 들을 다 저장해뒀어야 함
		st = new StringTokenizer(br.readLine());
		int dongdir = Integer.parseInt(st.nextToken());
		int dongloc = Integer.parseInt(st.nextToken());
		// 1 북쪽 2 남쪽
		// 3 서쪽 4 동쪽
		int dissum = 0;
		for (int i = 0; i < store; i++) {
			// 상대적인 위치가 어디인지 알기 위한 변수 a

			// 같은 면에 있다면 바로 거리를 더해주면 됨
			if (dir[i] == dongdir)
				dissum += Math.abs(dongloc - arr[i]);

			// 반대 편이라면 서 <-> 동
			else if ((dongdir == 3 || dongdir == 4) && (dir[i] == 3 || dir[i] == 4)) {
				dissum += Math.min((arr[i] + dongloc), (y - arr[i] + y - dongloc)) + x;
				// 남 <-> 북
			} else if ((dongdir == 1 || dongdir == 2) && (dir[i] == 1 || dir[i] == 2)) {
				dissum += Math.min((arr[i] + dongloc), (x - arr[i] + x - dongloc)) + y;
			}
			// 옆에 붙어있다면
			else {
				if (dongdir == 1) { // 동근이가 북쪽에 있을 때
					if (dir[i] == 3)
						dissum += dongloc + arr[i]; // 북-서
					else if (dir[i] == 4)
						dissum += (x - dongloc) + arr[i]; // 북-동
				} else if (dongdir == 2) { // 동근이가 남쪽에 있을 때
					if (dir[i] == 3)
						dissum += dongloc + (y - arr[i]); // 남-서
					else if (dir[i] == 4)
						dissum += (x - dongloc) + (y - arr[i]); // 남-동
				} else if (dongdir == 3) { // 동근이가 서쪽에 있을 때
					if (dir[i] == 1)
						dissum += dongloc + arr[i]; // 서-북
					else if (dir[i] == 2)
						dissum += (y - dongloc) + arr[i]; // 서-남
				} else if (dongdir == 4) { // 동근이가 동쪽에 있을 때
					if (dir[i] == 1)
						dissum += dongloc + (x - arr[i]); // 동-북
					else if (dir[i] == 2)
						dissum += (y - dongloc) + arr[i]; // 동-남
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(dissum);
		System.out.println(sb);

	}
}

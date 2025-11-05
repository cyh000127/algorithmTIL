import java.util.*;
import java.io.*;

public class Main {
	static int[][] chicken;
	static int[] selected;
	static int chickenDis, M, N, chickenHouse, house;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// N x N 도시가 잇음
		// r,c 는 1부터 시작

		// 집과 가장 가까운 치킨집 사이의 거리가 치킨거리
		// 두칸 사이의 거리는 |r1-r2| + |c1-c2| 임
		// 도시의 치킨거리 = 각 집의 치킨 거리들의 합

		// 0은 빈칸 , 1은 집, 2는 치킨집
		// M개의 치킨집을 남기고 나머지는 전부 폐업 하려고 함

		// 도시의 치킨거리가 가장 작게 될 지 구하셈

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 지도의 크기
		M = Integer.parseInt(st.nextToken()); // 남길 개수

		house = 0; // 집의 개수
		chickenHouse = 0; // 치킨집의 개수

		List<int[]> houseList = new ArrayList<>(); // 집 위치 리스트
		List<int[]> chickenList = new ArrayList<>(); // 치킨 위치 리스트

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int a = Integer.parseInt(st.nextToken());
				if (a == 1) {
					house++;
					houseList.add(new int[] { i, j });
				} else if (a == 2) {
					chickenHouse++;
					chickenList.add(new int[] { i, j });
				}
			}
		}

		chicken = new int[house][chickenHouse];

		for (int i = 0; i < house; i++) {
			for (int j = 0; j < chickenHouse; j++) {
				int[] hl = houseList.get(i);
				int[] cl = chickenList.get(j);

				chicken[i][j] = Math.abs(hl[0] - cl[0]) + Math.abs(hl[1] - cl[1]);
			}
		}

		// 디버깅
//		for (int i = 0; i < house; i++) {
//			for (int j = 0; j < chickenHouse; j++) {
//				System.out.print(chicken[i][j] + " ");
//			}
//			System.out.println();
//		}

		chickenDis = Integer.MAX_VALUE;
		selected = new int[M];
		dfs(0, 0); // 여태 선택한 치킨집 개수 , 탐색을 시작한 치킨집 인덱스
		System.out.println(chickenDis);

	}

	private static void dfs(int count, int idx) {
		if (count == M) {
			calcDis();
			return;
		}
		for (int i = idx; i < chickenHouse; i++) {
			selected[count] = i;
			dfs(count + 1, i + 1);
		}

	}

	private static void calcDis() {
		int total = 0;

		for (int i = 0; i < house; i++) {
			int min = Integer.MAX_VALUE;

			for (int j = 0; j < M; j++) {
				int shop = selected[j];
				int distance = chicken[i][shop];
				min = Math.min(min, distance);
			}

			total += min;

			if (total >= chickenDis) {
				return;
			}
		}
		
		chickenDis = Math.min(chickenDis, total);
	}
}
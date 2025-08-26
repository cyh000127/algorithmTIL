import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 사전순으로 나중에 있다
		// 1. 두 수열 중 첫번쨰 수가 큰쪽은 사전순으로 나중이다
		// 2. 두 수열의 첫 수가 같다면 두번째 수를 비교, 사전순으로 나중인쪽(큰쪽)이 나중이다.
		// 3. 길이가 0인수열과 다른 수열을 비교시 -> 다른 수열이 사전순으로 나중
		// N 길이의 수열 양의정수로이루어짐
		// M 길이의 수열이 주어짐
		// 두 수열이 공통으로 갖는 부분 수열들 중 사전순으로 가장 나중 ( 공통 부분 중 가장 작은 수 구해라 ?)
		// 같이 가진 수를 찾은 후
		// 순서가 바뀌지 않는 특성을 이용해서
		// 가장 큰 수가 앞에 있는걸 찾는다
		
        // N 입력
        int N = Integer.parseInt(br.readLine());
        int[] arrN = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }
        
        // M 입력
        int M = Integer.parseInt(br.readLine());
        int[] arrM = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arrM[i] = Integer.parseInt(st.nextToken());
        }

        // 공통 원소를 찾고 내림차순으로 정렬하기 위한 리스트
        List<Integer> lcs = new ArrayList<>();
        int lastIdxN = -1;
        int lastIdxM = -1;

        while (true) {
            int maxVal = 0;
            int nextIdxN = -1;
            int nextIdxM = -1;

            // 현재 위치(lastIdxN, lastIdxM)보다 뒤에서 공통으로 존재하는 가장 큰 수를 찾습니다.
            for (int i = lastIdxN + 1; i < N; i++) {
                for (int j = lastIdxM + 1; j < M; j++) {
                    if (arrN[i] == arrM[j] && arrN[i] > maxVal) {
                        maxVal = arrN[i];
                        nextIdxN = i;
                        nextIdxM = j;
                    }
                }
            }

            // 더 이상 찾을 공통 원소가 없으면 종료
            if (maxVal == 0) {
                break;
            }

            // 가장 큰 수를 찾았으면, 그 수가 두 수열에서 처음으로 등장하는 위치를 다시 찾습니다.
            // 이렇게 해야 다음 탐색 범위를 최대한 넓게 가져갈 수 있습니다.
            int finalIdxN = -1;
            int finalIdxM = -1;
            
            for (int i = lastIdxN + 1; i < N; i++) {
                if (arrN[i] == maxVal) {
                    finalIdxN = i;
                    break;
                }
            }

            for (int j = lastIdxM + 1; j < M; j++) {
                if (arrM[j] == maxVal) {
                    finalIdxM = j;
                    break;
                }
            }
            
            lcs.add(maxVal);
            lastIdxN = finalIdxN;
            lastIdxM = finalIdxM;
        }
       
        System.out.println(lcs.size());
        for (int num : lcs) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}

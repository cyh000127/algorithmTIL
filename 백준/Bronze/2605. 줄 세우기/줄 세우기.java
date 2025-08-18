import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 학생들이 한줄로 줄을 설거에요
		// 처음 에는 0번 = 맨 앞에 서고
		// 두번째 애는 0번 or 1번 // 0 = 그 자리 / 1 = 앞으로 한칸
		// 세번째 애는 0번 or 1번 or 2번 // 뽑은 번호만큼 앞으로 감 
		
		// 학생 수 N 이 주어지고
		// 다음 줄에 차례로 뽑은 카드 수가 주어질 때 
		// 최종적으로 줄을 선 순서를 번호로 출력하셈 
		
		// LinkedList를 사용하여 중간에 넣을 수 있다 ?
		LinkedList<Integer> list = new LinkedList<>();
		
		// (size - 뽑은 번호)를 하면 그 순서로 서지 않을까? 
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i<=N; i++) {
			int token = Integer.parseInt(st.nextToken());
			list.add(list.size()-token,i);
		}
		while(!list.isEmpty()) {
			System.out.print(list.poll());
			if(!list.isEmpty()) System.out.print(" ");
		}
	}
}

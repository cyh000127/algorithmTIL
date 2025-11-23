import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		//각 좌표 설정
		int x1, y1, x2, y2 = 0;
		
		//입력값이 4의 배수일 경우 나머지가 0으로 나오기 때문에 y좌표 값을 0으로 한다.
		//x좌표도 같은 경우다. 딱 맞아 떨어지기 때문에 몫을 그대로 가져온다.
		if(A % 4 == 0) {
			x1 = A / 4;
			y1 = 1;
		//4의 배수가 아니면 x좌표는 1을 더해주고, y좌표는 나머지를 5에서 빼준다.
		}else {
			x1 = (A / 4) + 1;
			y1 = 5 - (A % 4);
		}
		
		//B좌표도 A좌표와 마찬가지다
		if(B % 4 == 0) {
			x2 = B / 4;
			y2 = 1;
		}else {
			x2 = (B / 4) + 1;
			y2 = 5 - (B % 4);
		}
		
		//두 좌표값중 어느 좌표값이 더 큰지 알 수 없기에 뺀 뒤 절댓값으로 계산한다.
		System.out.println(Math.abs(x2 - x1) + Math.abs(y2 - y1));
	}

}
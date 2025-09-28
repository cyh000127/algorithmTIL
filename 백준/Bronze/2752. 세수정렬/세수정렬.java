import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//숫자가 3개 제한
		int[] arr = new int[3];
		
		for(int i = 0; i < 3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		//배열을 출력하게 되면 다른 기호도 출력되기 때문에 하나씪 꺼내 출력한다.
		for(int i = 0; i < 3; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
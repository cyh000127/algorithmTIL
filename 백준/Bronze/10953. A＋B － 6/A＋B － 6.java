import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);

		int N = sc.nextInt();
		
		for(int i = 0; i<N; i++) {
			String str = sc.next();
			String[] nums = str.split(",");
			int A = Integer.parseInt(nums[0]);
			int B = Integer.parseInt(nums[1]);
		
			System.out.println(A+B);
		}
	}
}
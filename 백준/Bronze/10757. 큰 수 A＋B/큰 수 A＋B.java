import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	

		// 정수형 입력 두개를 받아서 a, b 변수에 할당한다	
		// 가변적인 크기를 가지는 참조자료형을 사용해보자...! ( 정수형 가변적인 참조자료형 BigInteger )
		BigInteger a = scanner.nextBigInteger();
		BigInteger b = scanner.nextBigInteger();
		
		// BigInteger는 별도의 메서드가 필요
		System.out.println(a.add(b));
	}
}
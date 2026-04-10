import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int Y = sc.nextInt();

        // repeat 대신 별도의 메서드 사용
        String s1 = repeatString("1", X);
        String s2 = repeatString("1", Y);

        BigInteger num1 = new BigInteger(s1);
        BigInteger num2 = new BigInteger(s2);

        System.out.println(num1.add(num2));

        sc.close();
    }

    // Java 8에서 String.repeat() 역할을 하는 메서드
    public static String repeatString(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
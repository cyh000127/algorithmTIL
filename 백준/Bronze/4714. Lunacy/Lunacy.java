import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		double weight = sc.nextDouble();
		while(weight != -1) {
			double moonWeight = weight * 0.167;
			System.out.println("Objects weighing " + String.format("%.2f", weight) + " on Earth will weigh " + String.format("%.2f", moonWeight) + " on the moon.");
			weight = sc.nextDouble();
		}
		sc.close();
	}
}
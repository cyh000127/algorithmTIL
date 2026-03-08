import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double K = sc.nextDouble();
        double P = sc.nextDouble();
        double X = sc.nextDouble();

        double optimalM = Math.sqrt((K * P) / X);

        long m1 = (long) Math.floor(optimalM);
        long m2 = (long) Math.ceil(optimalM);

        if (m1 < 1) m1 = 1;
        if (m2 < 1) m2 = 1;

        double cost1 = (double) m1 * X + (K / m1) * P;
        double cost2 = (double) m2 * X + (K / m2) * P;

        double minCost = Math.min(cost1, cost2);

        System.out.printf("%.3f\n", minCost);

        sc.close();
    }
}
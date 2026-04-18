import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int color = sc.nextInt();

        if (620 <= color && color <= 780){
            System.out.println("Red");
        } else if (590 <= color && color <= 620){
            System.out.println("Orange");
        } else if (570 <= color && color <= 590){
            System.out.println("Yellow");
        } else if (495 <= color && color <= 570){
            System.out.println("Green");
        } else if (450 <= color && color <= 495){
            System.out.println("Blue");
        } else if (425 <= color && color <= 450){
            System.out.println("Indigo");
        } else if (380 <= color && color <= 425){
            System.out.println("Violet");
        }
    }
}
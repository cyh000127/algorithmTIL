import java.util.Scanner;
public class Main {
//최소 3개의 안테나와 최대 4개의 눈을 가지고있는 TroyMartian
// 최대 6개의 안테나와 최소 2개의 눈을 가지고 있는 VladSaturnian
// 최대 2개의 안테나와 최소 3개의 눈을 가지고 있는 GraemeMercurian
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);



        int Antena = sc.nextInt();
        int eyes = sc.nextInt();


        if (Antena >= 3 && eyes <=4){
            System.out.println("TroyMartian");
        }if(Antena <= 6 && eyes >= 2 ){
            System.out.println("VladSaturnian");
        }if(Antena <=2 && eyes <= 3){
            System.out.println("GraemeMercurian");
        }else {

        }

    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 시작 위치는 1번 칸
        int currentSquare = 1;
        
        while (true) {
            // 사용자로부터 주사위 합 입력 (2~12) 또는 종료 신호 (0)
            if (!sc.hasNextInt()) break;
            int diceSum = sc.nextInt();
            
            // 0을 입력하면 게임 종료
            if (diceSum == 0) {
                System.out.println("You Quit!");
                break;
            }
            
            // 주사위 값만큼 이동했을 때 100을 넘지 않는지 확인
            if (currentSquare + diceSum <= 100) {
                currentSquare += diceSum;
                
                // 사다리 및 뱀 처리
                currentSquare = checkBoard(currentSquare);
            }
            
            // 현재 위치 출력
            System.out.println("You are now on square " + currentSquare);
            
            // 100번 칸에 도착하면 승리 및 종료
            if (currentSquare == 100) {
                System.out.println("You Win!");
                break;
            }
        }
        
        sc.close();
    }

    /**
     * 특정 칸에 도착했을 때 사다리나 뱀이 있는지 확인하여 위치를 조정합니다.
     */
    private static int checkBoard(int square) {
        // 사다리 (Ladders)
        if (square == 9) return 34;
        if (square == 40) return 64;
        if (square == 67) return 86;
        
        // 뱀 (Snakes)
        if (square == 54) return 19;
        if (square == 90) return 48;
        if (square == 99) return 77;
        
        return square;
    }
}
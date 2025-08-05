import java.util.Scanner;

public class Main{
    	public static void main(String[] args) {      	

    	Scanner sc = new Scanner(System.in);
    	
    	int n = sc.nextInt();
    	sc.nextLine();
    	int[] arr= new int[n];
    
    	String arrN = sc.nextLine();
    	String[] ARR = arrN.split(" ");
    
    	int t = sc.nextInt();
    	int cnt= 0;
    	
    	for(int i = 0 ; i<arr.length; i++) {
    		arr[i] = Integer.parseInt(ARR[i]);
    	}
    	
    	for(int i = 0 ; i<arr.length; i++) {
    		if(arr[i] == t) {cnt++;}
    	}
    	System.out.println(cnt);
	}
}
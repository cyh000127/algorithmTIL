import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			String a = sc.nextLine();
			String f = "";
			for(int i = 0; i < a.length(); i++) {
				if(a.charAt(i) == 'e') {
					f += 'i';
				}else if(a.charAt(i) == 'i') {
					f += 'e';
				}else if(a.charAt(i) == 'E') {
					f += 'I';
				}else if(a.charAt(i) == 'I') {
					f += 'E';
				}else {
					f += a.charAt(i);
				}
			}
			System.out.println(f);
		}
		sc.close();
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int card = Integer.parseInt(br.readLine());

		LinkedList<Integer> list = new LinkedList<>();

		for (int i = card; i >= 1; i--) {
			list.push(i);
		}

		while (true) {
			if (list.size() == 1)
				break;
			list.poll();
			int x = list.poll();
			list.add(x);
		}
		
		System.out.println(list.get(0));
	}
}

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();
		int length = str.length();

		LinkedList<Character> list = new LinkedList<>();

		for (int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i));
		}

		ListIterator<Character> li = list.listIterator();
		while (li.hasNext()) {
			li.next();
		}

		int N = Integer.parseInt(br.readLine()); // 명령어의 개수

		for (int order = 0; order < N; order++) {
			// 편집기는 소문자 영어만 들어감
			// L idx -1
			// D idx +1
			// B remove(idx-1)
			// P $ 문자를 그 idx 에 추가
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			switch (a) {
			case "L":
				if (li.hasPrevious()) {
					li.previous();
				}
				break;
			case "D":
				if (li.hasNext()) {
					li.next();
				}
				break;
			case "P":
				li.add(st.nextToken().charAt(0));
				break;
			case "B":
				if (li.hasPrevious()) {
					li.previous();
					li.remove();
				}
				break;
			default:
				break;
			}

		}
		for (Character cha : list) {
			sb.append(cha);
		}
		System.out.println(sb.toString());
	}
}

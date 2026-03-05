import java.util.*;
import java.io.*;

/**
 * 27652 AB
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// A와 B, 문자열 S에 대해 다음 쿼리를 수행

		// add a s: A에 S를 추가
		// delete a s : A에서 S를 제거
		// add b s: B에 S추가
		// delete b s : A에서 S를 제거

		// find s : A + B => S가 되는 경우의수를 출력

		int q = Integer.parseInt(br.readLine());

		Trie tra = new Trie();
		Trie trb = new Trie();

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		char[] findWord;
		while (q-- > 0) {
			st = new StringTokenizer(br.readLine());

			String aOrb;
			switch (st.nextToken()) {
			case "add":
				aOrb = st.nextToken();
				if (aOrb.equals("A")) {
					tra.insert(st.nextToken());
				} else {
					// b는 뒤에서부터 넣어서 suffix를 뒤에서 부터 탐색
					StringBuilder reverse = new StringBuilder();
					reverse.append(st.nextToken());
					trb.insert(reverse.reverse().toString());
				}
				break;
			case "delete":
				aOrb = st.nextToken();
				String target = st.nextToken();
				if (aOrb.equals("A")) {
					tra.delete(target);
				} else {
					// B도 add와 마찬가지로 뒤집어서 삭제 진행
					trb.delete(new StringBuilder(target).reverse().toString());
				}
				break;
			case "find":
				sb.append(Trie.find(tra, trb, st.nextToken())).append("\n");
				break;
			}
		}
		System.out.println(sb);

	}

	static class Node {
		HashMap<Character, Node> chiledNode = new HashMap<>();
		int cnt;
		boolean end;
	}

	static class Trie {
		Node rootNode = new Node();

		public void insert(String str) {
			Node node = this.rootNode;

			for (int i = 0; i < str.length(); i++) {
				node = node.chiledNode.computeIfAbsent(str.charAt(i), key -> new Node());
				// prefix, subfix의 중복 개수를 찾기 위한 cnt
				node.cnt++;
			}
			node.end = true;
		}

		public void delete(String str) {
			Node node = this.rootNode;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				Node child = node.chiledNode.get(c);
				if (child == null)
					return;

				if (child.cnt > 1) {
					child.cnt--;
					node = child; // 다음 노드로 이동
				} else {
					// cnt가 1이면 이 아래로는 더 이상 노드가 필요 없음
					node.chiledNode.remove(c);
					return;
				}
			}
		}

		// cbt 개수 리턴
		public int search(String str) {
			Node node = this.rootNode;

			for (int i = 0; i < str.length(); i++) {
				node = node.chiledNode.getOrDefault(str.charAt(i), null);
				if (node == null) {
					return -1;
				}
			}
			return node.cnt;
		}

		public static int find(Trie tra, Trie trb, String str) {
			int L = str.length();
			int[] countA = new int[L + 1];
			int[] countB = new int[L + 1];

			// A Trie에서 각 길이별 접두사 개수 파악
			Node currA = tra.rootNode;
			for (int i = 0; i < L; i++) {
				currA = currA.chiledNode.get(str.charAt(i));
				if (currA == null)
					break;
				countA[i + 1] = currA.cnt;
			}

			// B Trie에서 각 길이별 접미사 개수 파악
			Node currB = trb.rootNode;
			for (int i = 0; i < L; i++) {
				currB = currB.chiledNode.get(str.charAt(L - 1 - i));
				if (currB == null)
					break;
				countB[i + 1] = currB.cnt;
			}

			int totalCnt = 0;
			// A의 접두사 길이 i, B의 접미사 길이 j. i + j == L 이고 i, j >= 1
			for (int i = 1; i < L; i++) {
				int j = L - i;
				if (countA[i] > 0 && countB[j] > 0) {
					totalCnt += countA[i] * countB[j];
				}
			}
			return totalCnt;
		}
	}
}
import java.util.*;
import java.io.*;

class Solution {
    static int len;
    static String[] answer;
    static boolean finished;

    public String[] solution(String[][] tickets) {
        len = tickets.length;
        answer = new String[len + 1];

        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] a, String[] b) {
                return a[1].compareTo(b[1]);
            }
        });

        List<String> path = new ArrayList<>();
        path.add("ICN");

        boolean[] visited = new boolean[len];

        dfs(tickets, "ICN", 0, path, visited);

        return answer;
    }

    public void dfs(
            String[][] tickets,
            String nloc,
            int ncnt,
            List<String> path,
            boolean[] visited
    ) {
        if (finished) {
            return;
        }

        if (ncnt == len) {
            answer = path.toArray(new String[0]);
            finished = true;
            return;
        }

        for (int i = 0; i < len; i++) {
            String from = tickets[i][0];
            String to = tickets[i][1];

            if (nloc.equals(from) && !visited[i]) {
                visited[i] = true;
                path.add(to);

                dfs(tickets, to, ncnt + 1, path, visited);

                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }
}
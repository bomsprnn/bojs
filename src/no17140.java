import java.io.*;
import java.util.*;

public class no17140 {
    static int a[][];
    static int r, c, k;
    static int row = 3, col = 3;

    static class Node implements Comparable<Node> {
        int no, count;

        Node(int no, int cnt) {
            this.no = no;
            this.count = cnt;
        }

        public int compareTo(Node o) {
            if (this.count == o.count) return this.no - o.no;
            return this.count - o.count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        r = Integer.parseInt(st.nextToken()); //모든 행에 대해 정렬
        c = Integer.parseInt(st.nextToken()); //모든 열에 대해 정렬
        k = Integer.parseInt(st.nextToken());
        a = new int[r][c];
        // 행과 열 중 더 큰 것 고르기 -> 긴 것을 기준으로 정렬 수행 (숫자 등장 횟수 오름 - 숫자 크기 오름차순)

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(bfr.readLine());
            for (int j = 0; j < 3; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfw.write(ans());

    }

    private static int ans() {
        int cnt = 0;
        while (true) {


            if (a[r][c] == k) return cnt;
            if (row >= col) {

                int col2 = 0;
                for (int i = 0; i < row; i++) {
                    Map<Integer, Integer> sort = new HashMap<>();
                    List<Node> list = new ArrayList<>();
                    for (int j = 0; j < col; j++) {
                        if (a[i][j] == 0) continue;
                        if (!sort.containsKey(a[i][j])) sort.put(a[i][j], 1);
                        else sort.replace(a[i][j], sort.get(a[i][j]) + 1);
                        a[i][j] = 0;
                    }

                    for (int key : sort.keySet()) {
                        list.add(new Node(key, sort.get(key)));
                    }
                    col2 = Math.max(col2, list.size() * 2);
                    Collections.sort(list);

                    for (int j = 0, idx = 1; j < list.size(); j++, idx += 2) {
                        if (idx > 100) break;
                        a[i][idx] = list.get(j).no;
                        a[i][idx + 1] = list.get(j).count;
                    }
                    col = col2;
                }
            } else {                                            // C 연산
                int row2 = 0;
                for (int i = 0; i < col; i++) {
                    Map<Integer, Integer> sort = new HashMap<>();
                    List<Node> list = new ArrayList<>();
                    for (int j = 0; j < row; j++) {
                        if (a[j][i] == 0) continue;
                        if (!sort.containsKey(a[j][i])) sort.put(a[j][i], 1);
                        else sort.replace(a[j][i], sort.get(a[j][i]) + 1);
                        a[j][i] = 0;
                    }
                    for (int key : sort.keySet()) {
                        list.add(new Node(key, sort.get(key)));
                    }
                    row2 = Math.max(row2, list.size() * 2);
                    Collections.sort(list);

                    for (int j = 0, idx = 1; j < list.size(); j++, idx += 2) {
                        if (idx > 100) break;
                        a[idx][i] = list.get(j).no;
                        a[idx + 1][i] = list.get(j).count;
                    }
                }
                row = row2;
            }

        }
    }
}




import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class no1697 { //16740	168
    static int[] visited = new int[100001];
    static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        /**
         *
         *  수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동
         *  순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동
         *
         *  수빈이와 동생의 위치가 주어졌을 때,
         *  수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램
         */

        // 수빈이의 위치 N, 동생의 위치 K
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int n = Integer.parseInt(st.nextToken()); // 수빈이의 위치
        int k = Integer.parseInt(st.nextToken()); // 동생의 위치
        if (n == k) bfw.write("0");
        else bfs(n, k);
        bfw.flush();
    }

    private static void bfs(int n, int k) throws IOException {
        visited[n] = 1;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(n);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int i = 0; i < 3; i++) { // 걷기, 순간이동
                int next;
                if (i == 0) next = x - 1;
                else if (i == 1) next = x + 1;
                else next = x * 2;
                if (next == k) { // 동생을잡으면
                    bfw.write((visited[x]) + "");
                    return;
                }
                if (next >= 0 && next < visited.length&& visited[next] == 0) {
                    visited[next] = visited[x] + 1;
                    queue.add(next);
                }


            }
        }
    }
}

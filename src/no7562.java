import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no7562 { //91884	328ms
    static int[][] pos = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, //상하
            {-1, -2}, {1, -2}, {-1, 2}, {1, 2}}; //좌우

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        /**
         * 조건
         * l X l의 체스판, 나이트가 이동할 수 있는 방법은 8가지(4방향 전진 * 2방향 상향 대각선)
         * 현재 위치에서 목표 위치까지 이동하는 최소 횟수 출력
         *
         * 접근
         * 최소 값을 찾아야하므로 BFS 사용, 나이트가 이동할 수 있는 방향을 배열 지정 (8가지)
         * 노드 방문하면 8방향으로 돌면서 확인
         */
        int t = Integer.parseInt(bfr.readLine()); //test case

        boolean[][] visited;

        for (int i = 0; i < t; i++) { //test case만큼 반복
            int l = Integer.parseInt(bfr.readLine());
            visited = new boolean[l][l];
            StringTokenizer st = new StringTokenizer(bfr.readLine());
            int[] start = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            st = new StringTokenizer(bfr.readLine());
            int[] end = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            bfw.write(bfs(start, end, visited) + "\n");


        }
        bfw.flush();
    }

    private static int bfs(int[] start, int[] end, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true; //시작점 방문 마ㅡ크
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == end[0] && cur[1] == end[1]) return cur[2]; //목표지점 도착하면 리턴
            for (int i = 0; i < 8; i++) {
                int[] next = {cur[0] + pos[i][0], cur[1] + pos[i][1]};
                if (next[0] >= 0 && next[0] < visited.length && next[1] >= 0 && next[1] < visited.length && !visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.offer(new int[]{next[0], next[1], cur[2] + 1});
                }
            }
        }
        return -1;
    }
}

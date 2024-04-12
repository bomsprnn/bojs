import java.io.*;
import java.util.*;

public class no1261 { //16324	196
    /**
     * 조건
     * 미로는 N*M 크기이며, 총 1*1크기의 방/벽, 이동할 수 있는 방은 상하좌우로 인접한 빈 방
     * 현재 (1, 1)에 있는 알고스팟 운영진이 (N, M)으로 이동하려면 벽을 최소 몇 개 부수어야 하는지
     * <p>
     * 접근
     */
    static int n, m; //(1 ≤ N, M ≤ 100) 다 부숴도 max m*n
    static int[][] maze;
    static int[][] brk;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int max = n * m;
        maze = new int[n][m];
        brk = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] str = bfr.readLine().split("");
            for (int j = 0; j < m; j++) {
                maze[i][j] = str[j].charAt(0) - '0';
                //!! 아스키 48 빼서 int 그대로 저장... 아니먄 계속 0만 나옴 ㅡㅠ
                brk[i][j] = max;
            }
        }

        bfw.write(Dijkstra() + "");
        bfw.flush();

    }

    private static int Dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        brk[0][0] = 0;
        pq.add(new Node(0, 0, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (node.x ==m - 1 && node.y == n - 1) return node.cost; //도착하면 지금까지 부순 벽 반환
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    if (brk[ny][nx] > node.cost + maze[ny][nx]) {
                        brk[ny][nx] = node.cost + maze[ny][nx];
                        pq.add(new Node(nx, ny, brk[ny][nx]));
                    }
                }
            }
        }
        return 0;
    }

    static class Node implements Comparable<Node> {
        public int x;
        public int y;
        public int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}


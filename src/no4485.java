import java.util.*;
import java.io.*;

public class no4485 {//20416	268ms
    /**
     * 조건
     * N x N 크기의 동굴의 제일 왼쪽 위 (0,0)
     * 제일 오른쪽 아래 칸인 [N-1][N-1]까지 이동
     * 동굴의 각 칸마다 도둑루피, 해당 도둑루피의 크기만큼 소지금을 잃음
     * 한 번에 상하좌우 인접한 곳으로 1칸씩, 동굴 건너편까지 이동
     * 잃는 최소 금액 구하기
     * <p>
     * 접근
     * 다익스트라 이용해서 원점에서부터 비용 갱신
     */
    static int n;
    static int[][] map;
    static int[][] distance;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int problem = 1;

        while (true) {
            n = Integer.parseInt(bfr.readLine());
            if (n == 0) break;
            map = new int[n][n];
            distance = new int[n][n];
            StringTokenizer st;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(bfr.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    distance[i][j] = 150000; // 모든 칸을 들러 루피 털리는 경우 125*125*900 = 1406250
                }
            }
            bfw.write("Problem "+problem+": "+Dijkstra()+"\n");
            problem++; // 문제 번호 출력 관여
        }
        bfw.flush();
    }

    private static int Dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance[0][0] = map[0][0]; // 시작점 비용 초기화
        pq.add(new Node(0, 0, map[0][0]));
        while (!pq.isEmpty()) {
            Node node = pq.poll();

            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                if(nx>=0 &&ny>=0 && nx<n && ny<n){
                    if(distance[ny][nx] > node.cost + map[ny][nx]){
                        distance[ny][nx] = node.cost + map[ny][nx]; // 비용 갱신
                        pq.add(new Node(nx, ny, distance[ny][nx]));
                    }
                }

            }

        }
        return distance[n - 1][n - 1]; //
    }

    static class Node implements Comparable<Node> {
        public int x;
        public int y;
        public int cost;

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}

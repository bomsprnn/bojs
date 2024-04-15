import java.util.*;
import java.io.*;

public class no5927 { //맞았습니다!!	39152	440
    /**
     * N (1 <= N <= 50,000) 개의 헛간과, 소들의 길인 M (1 <= M <= 50,000) 개의 양방향 길
     * 각각의 길은 C_i (0 <= C_i <= 1,000) 마리의 소가 있습니다.
     * 길은 두 개의 떨어진 헛간인 A_i 와 B_i (1 <= A_i <= N; 1 <= B_i <= N; A_i != B_i)를 이음
     * 헛간 1에서 출발, N까지 최소 소
     */

    static int n, m;
    static ArrayList<Node>[] shed;
    static int[] cost;
    static int max = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        shed = new ArrayList[n + 1];
        cost = new int[n + 1];
        for (int i = 0; i <=n; i++) {
            shed[i] = new ArrayList<>();
            cost[i] = max;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bfr.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            shed[from].add(new Node(to, cost));
            shed[to].add(new Node(from, cost));
        }

        Dijkstra();

    }

    private static void Dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        cost[1] = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (now.to == n) { // 도착하면 리턴
                System.out.println(cost[n]);
                return;
            }if (now.cost > cost[now.to]) { // 최소값이 아니면 패스
                continue;
            }
            for (Node next : shed[now.to]) { // 다음 노드가 더 작으면 갱신
                if (cost[next.to] <= cost[now.to] + next.cost) {
                    continue;
                }
                cost[next.to] = cost[now.to] + next.cost;
                pq.add(new Node(next.to, cost[next.to]));
            }
        }
    }


    static class Node implements Comparable<Node>{
        public int to;
        public int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}



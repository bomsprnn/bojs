import java.util.*;
import java.io.*;

public class no10282 {
    /**
     * 해킹
     * 해킹한 컴퓨터 번호와 각 의존성이 주어질 때,
     * 해킹당한 컴퓨터까지 포함하여 총 몇 대의 컴퓨터가 감염되며 그에 걸리는 시간이 얼마인지 구하는 프로그램
     * <p>
     * 첫째 줄에 컴퓨터 개수 n, 의존성 개수 d, 해킹당한 컴퓨터의 번호 c가 주어진다(1 ≤ n ≤ 10,000, 1 ≤ d ≤ 100,000, 1 ≤ c ≤ n).
     * 이어서 d개의 줄에 각 의존성을 나타내는 정수 a, b, s가 주어진다(1 ≤ a, b ≤ n, a ≠ b, 0 ≤ s ≤ 1,000).
     * 이는 컴퓨터 a가 컴퓨터 b를 의존하며, 컴퓨터 b가 감염되면 s초 후 컴퓨터 a도 감염됨을 뜻한다.
     * <p>
     * 접근
     * 일단 그래프문제.. 의존성은 단방향으로 연결
     * 다익스트라로 최단시간 구하기ㄱㄱ
     */

    static int[] cost;
    static ArrayList<Node>[] computer;
    static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(bfr.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(bfr.readLine());
            int n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
            int d = Integer.parseInt(st.nextToken()); // 의존성 개수
            c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터 번호
            cost = new int[n];
            computer = new ArrayList[n];

            for (int j = 0; j < n; j++) {
                computer[j] = new ArrayList<>();

            } // 배열 초기화


            for (int j = 0; j < d; j++) {
                st = new StringTokenizer(bfr.readLine());
                int a = Integer.parseInt(st.nextToken()); // from
                int b = Integer.parseInt(st.nextToken()); // to
                int s = Integer.parseInt(st.nextToken()); // time
                computer[b - 1].add(new Node(a - 1, s));
            }
            dijkstra();
            int com = 0;
            int max = 0;
            for (int j = 0; j < n; j++) {
                if (cost[j] != Integer.MAX_VALUE) {
                    com++;
                    max = Math.max(max, cost[j]);
                }
            }
            bfw.write(com + " " + max + "\n");
            
        }
        bfw.flush();


    }

    private static void dijkstra() {
        Arrays.fill(cost, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(c-1, 0));
        cost[c-1] = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int to = now.to;
            int nowCost = now.cost;
            if (cost[to] < nowCost) continue; // 최소값이 아니면 패스

            int size = computer[to].size();
            for (int i = 0; i < size; i++) {
                int next = computer[to].get(i).to; // 다음 노드
                int nextCost = computer[to].get(i).cost + nowCost;
                if (cost[next] > nextCost) { // 다음 노드가 더 작으면 갱신
                    cost[next] = nextCost;
                    pq.add(new Node(next, nextCost));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int to;
    int cost;

    public Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return cost - o.cost;
    }
}

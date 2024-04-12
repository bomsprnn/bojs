import java.util.*;
import java.io.*;
public class no1238 {
    /**
     * 조건
     * N명의 학생이 X (1 ≤ X ≤ N)번 마을에 모여서 파티를 벌이기로 했다.
     * 이 마을 사이에는 총 M개의 단방향 도로들이 있고 i번째 길을 지나는데 Ti(1 ≤ Ti ≤ 100)의 시간을 소비한다.
     * 각각의 학생들은 다시 그들의 마을로 돌아와야 한다.
     * N명의 학생들 중 오고 가는데 가장 많은 시간을 소비하는 학생의 소요시간
     *
     * 접근
     * 엣지가 단방향임을 유의!!!
     * 그래프에 위치,가중치 함께 저장, 다익스트라로 풀기
     * 단방향 그래프이므로 오는길에 대한 값도 따로 구해서 더한 값이 가장 큰 아이 고르기
     *
     */

    static int n, m, x; //N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 10,000),
    static ArrayList<Node>[] fore;
    static ArrayList<Node>[] back;
    static int[] cost;
    static int max = 1000000; //m * t
    static int[] foreCost;
    static int[] backCost;

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken()); // 파티가 열리는 마을 (목적지)

        fore = new ArrayList[n];
        back = new ArrayList[n];
        foreCost = new int[n];
        backCost = new int[n];
        for (int i = 0; i < n; i++) {
            fore[i] = new ArrayList<>();
            back[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bfr.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            fore[from - 1].add(new Node(to - 1, cost));
            back[to - 1].add(new Node(from - 1, cost)); // 오는길은 to -> from
        }


        Dijkstra(fore, foreCost);
        Dijkstra(back, backCost);

        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, foreCost[i] + backCost[i]); // 가는길 오는길 합이 가장 큰 것을 갱신
        }
        bfw.write(result + "");
        bfw.flush();



    }

    private static int[] Dijkstra(ArrayList<Node>[] arr, int[] cost) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(cost, max); // 모든 정점 일단 초기화 (가장 큰 값으로)
        cost[x - 1] = 0; // 출발지는 0으로 - 정방향 역방향 동일
        pq.add(new Node(x - 1, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int size = arr[node.idx].size(); // 현재 노드와 연결된 노드들
            for (int i = 0; i < size; i++) {
                Node forenode = arr[node.idx].get(i);
                if (cost[forenode.idx] > node.cost + forenode.cost) {
                    cost[forenode.idx] = node.cost + forenode.cost;
                    pq.add(new Node(forenode.idx, cost[forenode.idx]));
                }
            }
        }
        return cost;
    }

    static class Node implements Comparable<Node>{
        int idx;
        int cost;
        public Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
}



import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class no1939 {
    /**
     * N개의 섬으로 이루어진 나라, 몇 개의 섬 사이에는 다리가 설치되어 있어서 차들이 다닐 수 있다.
     * 섬 - 섬 다리에는 중량제한
     * 한 번의 이동에서 옮길 수 있는 물품들의 중량의 최댓값을 구하기
     * <p>
     * 입력
     * 첫째 줄에 N, M(1 ≤ M ≤ 100,000)이 주어진다.
     * 다음 M개의 줄에는 다리에 대한 정보를 나타내는 세 정수 A, B(1 ≤ A, B ≤ N), C(1 ≤ C ≤ 1,000,000,000)가 주어진다.
     * 이는 A번 섬과 B번 섬 사이에 중량제한이 C인 다리가 존재한다는 의미이다.
     * 서로 같은 두 섬 사이에 여러 개의 다리가 있을 수도 있으며, 모든 다리는 양방향이다.
     * 마지막 줄에는 공장이 위치해 있는 섬의 번호를 나타내는 서로 다른 두 정수가 주어진다.
     * <p>
     * 접근
     *
     * 중량 내림차순으로 pq에 때려넣고 출발 도착지 인아웃간선 비교하면서 ...리스트에 추가?
     * ㅜㅜㅜㅜ멀라용
     *
     */
    static int[] visited = new int[10001]; //N(2 ≤ N ≤ 10,000)개
    // 방문체크 겸    ...다익스트라 임시그래프 (현재까지 알고있는 최대 중량 체크)

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Island> island[] = new ArrayList[n + 1]; // 엣지 리스트
        for (int i = 0; i < n + 1; i++) {
            island[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bfr.readLine());
            int a = Integer.parseInt(st.nextToken()); // 섬 a
            int b = Integer.parseInt(st.nextToken()); // 섬 b
            int c = Integer.parseInt(st.nextToken()); // a-b 다리 중량제한
            island[a].add(new Island(b, c));
            island[b].add(new Island(a, c)); // 그래프에 추가
        }
        st = new StringTokenizer(bfr.readLine());
        int startFac = Integer.parseInt(st.nextToken()); // 출발지 공장
        int endFac = Integer.parseInt(st.nextToken()); // 도착지 공장

        findMaxWeight(n, island, startFac, endFac);

        bfw.write(visited[endFac]+"\n");
        bfw.flush();

    }

    private static void findMaxWeight(int n, ArrayList<Island>[] island, int startFac, int endFac) {
        PriorityQueue<Island> pq = new PriorityQueue<>((a, b) -> b.weight - a.weight); // 중량 내림차순
        pq.add(new Island(startFac, 1000000000)); // 시작점
        visited[startFac] = 1000000000; // 시작점 중량 max로 넣어놓고 ㅡ(어차피갱신)

        while (!pq.isEmpty()) {
            Island Island = pq.poll(); // 중량이 가장 큰것부터 꺼내서
            if (visited[Island.end] > Island.weight) continue;
            // 지금 만들어놓은 <최선의그래ㅠ프>와 비교하기 ..
            for(int i=0;i<island[Island.end].size();i++){ //현재 간선의 끝 노드에서 갈수있는 간선들 탐색
                Island next = island[Island.end].get(i); // 다음 간선
                int nextWeight = Math.min(Island.weight,next.weight);
                // 더작은값이 다음섬까지 이동할 수 있는 이동 경로.. 크면,,가다가 와르르.,.
                if(visited[next.end]<nextWeight){ // 최대 중량 갱신 (더 좋은 경로)
                    visited[next.end] = nextWeight;
                    pq.add(new Island(next.end,nextWeight));
                }
            }

        }
    }
    static class Island {
        int end;
        int weight;

        public Island(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}

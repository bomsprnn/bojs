import java.io.*;
import java.util.*;

public class no24444 {
    static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static ArrayList<Integer> graph[];
    public static int[] result;
    public static int cnt;

    public static void main(String[] args) throws IOException { //90100	1136ms
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        /**
         * 조건
         * N개의 정점과 M개의 간선으로 구성된 무방향 그래프
         * 정점 번호는 1번부터 N번이고 모든 간선의 가중치는 1
         * 정점 R에서 시작하여 너비 우선 탐색으로 노드를 방문할 경우 노드의 방문 순서를 출력
         * 시작 정점에서 방문할 수 없는 경우 0을 출력
         *
         * 접근
         * 큐를 활용하여 bfs를 구현
         */
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int n = Integer.parseInt(st.nextToken()); //정점의 개수
        int m = Integer.parseInt(st.nextToken()); //간선의 개수
        int r = Integer.parseInt(st.nextToken()); //시작 정점
        graph = new ArrayList[n + 1]; //그래프
        boolean[] visited = new boolean[n + 1]; //방문 여부
        result = new int[n + 1]; //방문 순서
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>(); //그래프 초기화
        } //그래프 초기화

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(bfr.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a); //방향이 없는 그래프 -> 양쪽에 추가
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]); //정렬
        }// 방문 순서를 보장하기 위해 수행

        bfs(visited, r);
        for (int i = 1; i <= n; i++) {
            bfw.write(result[i] + "\n");
        }
        bfw.flush();

    }

    private static void bfs(boolean[] visited, int r) {
        visited[r] = true; //r번째 노드 방문
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(r); //시작 노드 넣기
        while (!queue.isEmpty()) {
            int x = queue.poll();
            cnt++; result[x] = cnt; //방문 순서 저장
            for (int i = 0; i < graph[x].size(); i++) {
                int y = graph[x].get(i);
                if (!visited[y]) {
                    queue.offer(y); //방문하지 않은 노드 큐에 넣기
                    visited[y] = true;
                }
            }
        }
    }
}

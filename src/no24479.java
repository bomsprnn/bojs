import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class no24479 {//92144	1172ms
    static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static ArrayList<Integer> graph[];
    public static int[] result;
    public static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        /**
         * 조건
         * N개의 정점과 M개의 간선으로 구성된 무방향 그래프
         * 정점 번호는 1번부터 N번이고 모든 간선의 가중치는 1
         * 정점 R에서 시작하여 깊이 우선 탐색으로 노드를 방문할 경우 노드의 방문 순서를 출력
         * 시작 정점에서 방문할 수 없는 경우 0을 출력
         *
         * 접근
         * 이차원 배열로 그래프를 표현하고, 방문 여부를 체크하는 배열을 만든다.
         * dfs를 통해 방문한 노드를 출력한다.
         * ----> 메모리 초과 ... 512MB 제한인데 배열로만 400 10^9바이트
         * 그래프를 arraylist로 바꿔서
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
        dfs(visited, r);
        for (int i = 1; i <= n; i++) {
            bfw.write(result[i] + "\n");
        }
        bfw.flush();
    }

    private static void dfs(boolean[] visited, int i) throws IOException {
        visited[i] = true; //i번째 노드 방문
        cnt++;
        result[i] = cnt; //방문 순서 저장
        for (int j = 0; j < graph[i].size(); j++) { //모든 노드를 탐색
            if (!visited[graph[i].get(j)]) {
                dfs(visited, graph[i].get(j));
                //i와 연결되어 있고 방문하지 않은 노드 재귀호출!
            }
        }
    }
}

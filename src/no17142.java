import java.util.*;
import java.io.*;

public class no17142 { //32144	300
    /**
     * 가장 처음에 모든 바이러스는 비활성 상태,
     * 활성 상태인 바이러스는 상하좌우로 인접한 모든 빈 칸으로 동시에 복제, 1초 소요
     * <p>
     * 연구소(N×N)의 바이러스 M개를 활성 상태로 변경해 모든 빈 칸에 바이러스를 퍼뜨리는데 걸리는 최소 시간
     * <p>
     * 접근
     * 바이러스 위치 배열에 저장한다음 m개 뽑아 활성화 (벽세우기처럼!)
     */

    static int n, m, minTime, empty;
    static int[][] lab;
    static int[][] activated;
    static boolean[][] visited;

    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        lab = new int[n][n];
        empty = 0; // 빈 칸의 수를 세기 위한 변수 초기화
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bfr.readLine());
            for (int j = 0; j < n; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 0) empty++;
            }
        }
        minTime = Integer.MAX_VALUE;
        activated = new int[m][2];
        Activate(0, 0);
        System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime); // 빈 칸을 바이러스로 채울 수 없으면 -1
    }

    private static void Activate(int start, int depth) {
        if (depth == m) { // 더이상 활성화 할 필요가 없게 되면 BFS
            BFS();
            return;
        }
        for (int i = start; i < n * n; i++) { //lab 모두 순회하며 바이러스를 선택할 수 있는지 확인
            int y = i / n; // y좌표
            int x = i % n; // x좌표
            if (lab[y][x] == 2) { // 바이러스가 있다면
                activated[depth] = new int[]{y, x}; // 활성화
                Activate(i + 1, depth + 1); // 다음 바이러스 활성화
            }
        }
    }

    private static void BFS() {
        visited = new boolean[n][n];
        Queue<int[]> virus = new ArrayDeque<>();
        int tmpEmpty = empty; // 남은 빈 칸 수
        for (int i = 0; i < m; i++) {
            virus.add(activated[i]); // 활성화된 바이러스 큐에 넣기
            visited[activated[i][0]][activated[i][1]] = true;
        }

        int time = 0;
        while (!virus.isEmpty() && tmpEmpty > 0) { // 바이러스가 퍼질 수 있는 동안
            int size = virus.size();
            for (int s = 0; s < size; s++) { 
                int[] now = virus.poll();
                for (int i = 0; i < 4; i++) { // 상하좌우 탐색
                    int ny = now[0] + dy[i];
                    int nx = now[1] + dx[i];
                    if (ny >= 0 && ny < n && nx >= 0 && nx < n && !visited[ny][nx] && lab[ny][nx] != 1) {
                        // 범위 내에 있고 방문하지 않았고 벽이 아니라면!
                        visited[ny][nx] = true;
                        virus.add(new int[]{ny, nx});
                        if (lab[ny][nx] == 0) {
                            tmpEmpty--; // 빈 칸이라면 빈 칸 수 감소
                        }
                    }
                }
            }
            time++;
        }

        if (tmpEmpty == 0) minTime = Math.min(minTime, time); // 빈 칸이 없다면 최소 시간 갱신
    }
}

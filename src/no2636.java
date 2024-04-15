import java.util.*;
import java.io.*;

public class no2636 {
    /**
     * 직사각형 판에 치즈
     * 공기와 닿는 부분은 한시간 뒤 녹아 없어진다.
     * 입력으로 사각형 모양의 판의 크기와 한 조각의 치즈가 판 위에 주어졌을 때,
     * 공기 중에서 치즈가 모두 녹아 없어지는 데 걸리는 시간과
     * 모두 녹기 한 시간 전에 남아있는 치즈조각이 놓여 있는 칸의 개수를 구하는 프로그램
     * <p>
     * 접근
     * bfs..해야겠지
     * 공기 중심으로 탐색, 상하좌우에 치즈가 있다면 녹이고 치즈 개수 증가
     * 한번 돌 때 녹는 치즈 양 체크해서 총 치즈양에서 빼기
     * 치즈 0이 될 때까지 반복   치!~~~즈
     */

    static int n, m, melt;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로
        grid = new int[n][m];
        int cheese = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bfr.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1) cheese++; // 치즈 개수 세기
            }
        }

        int time = 0;
        while (cheese > 0) {
            time++;
            bfs(0, 0);
            cheese -= melt;
        }
        System.out.println(time);
        System.out.println(melt);


    }

    private static void bfs(int y, int x) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x});
        visited = new boolean[n][m];
        melt = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    if (grid[ny][nx] == 1) { // 치즈가 있다면
                        melt++; // 녹이기
                        grid[ny][nx] = 0; // 녹인 부분 처리
                    } else {
                        q.add(new int[]{ny, nx}); // 아니라면 계속 탐색
                    }
                }
            }
        }

    }
}

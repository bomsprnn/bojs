import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class no14502 { //91536	400ms
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n, m,result;
    static int[][] lab;
    static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        /**
         *  조건
         *  연구소는 크기가 N×M인 직사각형
         *  연구소는 빈 칸, 벽으로 이루어져 있으며, 벽은 칸 하나를 가득 차지한다
         *  일부 칸은 바이러스가 존재하며, 이 바이러스는 상하좌우로 인접한 빈 칸으로 모두 퍼져나갈 수 있다.
         *  새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다.
         *
         * 벽을 3개 세운 뒤, 바이러스가 퍼질 수 없는 곳을 안전 영역
         * 연구소의 지도가 주어졌을 때 얻을 수 있는 안전 영역 크기의 최댓값
         *
         *  접근
         *  이차원배열 받고... 모든 가능한 경우만큼 벽을 세우고
         *  바이러스를 퍼뜨려보고 안전영역을 구한다...
         *
         */

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lab = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bfr.readLine());
            for (int j = 0; j < m; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 이차원 배열 받기

        BuildWall(0,0,0); // 벽 세우기
        bfw.write(result + "");
        bfw.flush();
    }

    public static int BuildWall(int starti, int startj, int dep){
        if (dep == 3) return BFS(); //3개의 벽을 세웠다면 BFS로 바이러스 퍼뜨리기
        else { // 아니라면 계속 벽을 세우기
            for (int i = starti; i < n; i++) {
                if(i!=starti) startj = 0; // 다음 행으로 넘어갔다면 j는 0부터 시작
                for (int j = startj; j < m; j++) {
                    if (lab[i][j] == 0) {
                        lab[i][j] = 1;
                        BuildWall(i,j,dep + 1);
                        lab[i][j] = 0; // 다시 원상복구
                    }
                }
            }
        }
        return 0;
    }

    private static int BFS() {
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] lab2 = new int[n][m]; // 바이러스 퍼뜨릴 때마다 원본을 보존하기 위한 배열
        for (int i = 0; i < n; i++) { // 원본 복사
            for (int j = 0; j < m; j++) {
                lab2[i][j] = lab[i][j];
                if (lab2[i][j] == 2) { // 바이러스 위치 파악
                    queue.add(new int[]{i, j}); // 바이러스 위치 큐에 넣기
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] virus = queue.poll();
            int y = virus[0];
            int x = virus[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    if (lab2[ny][nx] == 0) {
                        lab2[ny][nx] = 2;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) { // 안전영역 구하기
            for (int j = 0; j < m; j++) {
                if (lab2[i][j] == 0) cnt++;
            }
        }

        return result = Math.max(result, cnt);
    }
}

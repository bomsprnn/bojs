import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class no2573 {
    static int[][] arr;
    static int[][] arr2;
    static boolean[][] visited;
    static int n, m;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        /**
         *  조건
         *  빙산을 2차원 배열에 표시한다고 하자. 빙산의 각 부분별 높이 정보는 배열의 각 칸에 양의 정수로 저장
         *  빙산 이외의 바다에 해당되는 칸에는 0이 저장
         *  배열에서 빙산의 각 부분에 해당되는 칸에 있는 높이는 일년마다 그 칸에 동서남북 네 방향으로 붙어있는 0이 저장된 칸의 개수만큼 줄어든다.
         *  단, 각 칸에 저장된 높이는 0보다 더 줄어들지 않는다.
         *
         *  2차원 배열에서 동서남북 방향으로 붙어있는 칸들은 서로 연결되어 있다고 말한다
         *  한 덩어리의 빙산이 주어질 때, 이 빙산이 두 덩어리 이상으로 분리되는 최초의 시간(년) 구하기
         *  만일 전부 다 녹을 때까지 두 덩어리 이상으로 분리되지 않으면 프로그램은 0을 출력한다.
         *
         *  접근
         *  bfs를 사용하여 빙산 덩어리 개수를 구한다.?
         *
         */
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        arr2 = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bfr.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 이차원 배열 받기

        int result = 0;

        while (true) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] != 0 && !visited[i][j]) {
                        //dfs(i, j);
                        cnt++;
                    }
                }

            }
            if (cnt >= 2) {
                bfw.write(result + "");
                break;
            } else if (cnt == 0) {
                bfw.write("0");
                break;
            }

            result++;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] != 0) {
                        int c = arr[i][j];

                    }


                }
            }


        }
    }
}

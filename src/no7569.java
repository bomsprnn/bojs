import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no7569 {//126848	740ms
    static int[] dn = {-1, 1, 0, 0, 0, 0}; // m
    static int[] dm = {0, 0, -1, 1, 0, 0}; // n
    static int[] dh = {0, 0, 0, 0, -1, 1}; // h
    static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int day;
    static int unripe;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int m = Integer.parseInt(st.nextToken()); // 가로
        int n = Integer.parseInt(st.nextToken()); // 세로
        int h = Integer.parseInt(st.nextToken()); // 높이
        int[][][] box = new int[h][n][m];
        int[][][] visited = new int[h][n][m];

        Queue<Tomato> queue = new LinkedList<>();
        day = 0;
        unripe = 0; // 익지 않은 토마토의 개수 초기화

        for (int z = 0; z < h; z++) {
            for (int y = 0; y < n; y++) {
                StringTokenizer st2 = new StringTokenizer(bfr.readLine());
                for (int x = 0; x < m; x++) {
                    box[z][y][x] = Integer.parseInt(st2.nextToken());
                    if (box[z][y][x] == 1) {
                        queue.add(new Tomato(z, y, x)); // 익은 토마토
                        visited[z][y][x] = 1;
                    } else if (box[z][y][x] == 0) {
                        unripe++; // 익지 않은 토마토의 개수 증가
                    }
                }
            }
        }

        bfs(queue, visited, box, n, m, h);

        bfw.write(unripe == 0 ? String.valueOf(day) : "-1");
        bfw.flush();
    }

    private static void bfs(Queue<Tomato> queue, int[][][] visited, int[][][] box, int n, int m, int h) {
        while (!queue.isEmpty() && unripe > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Tomato tomato = queue.poll();
                for (int j = 0; j < 6; j++) {
                    int nz = tomato.h + dh[j];
                    int ny = tomato.n + dn[j];
                    int nx = tomato.m + dm[j];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && nz >= 0 && nz < h && box[nz][ny][nx] == 0 && visited[nz][ny][nx] == 0) {
                        visited[nz][ny][nx] = 1;
                        queue.add(new Tomato(nz, ny, nx));
                        box[nz][ny][nx] = 1;
                        unripe--;
                    }
                }
            }
            day++;
        }
    }

    private static class Tomato {
        int h;
        int n;
        int m;

        public Tomato(int h, int n, int m) {
            this.h = h;
            this.n = n;
            this.m = m;
        }
    }
}
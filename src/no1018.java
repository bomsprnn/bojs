import java.io.*;
import java.util.StringTokenizer;

public class no1018 { //14404	132
    public static boolean[][] origin;
    public static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        origin = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String str = bfr.readLine();
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == 'W') origin[i][j] = true;
                else origin[i][j] = false;
            }
        } // origin 체스판 bool로 만들기

        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                chess(i, j);
            }
        }
        bfw.write(min + "");
        bfw.flush();

    }

    private static void chess(int x, int y) {
        boolean start = origin[x][y];//8x8 체스판 첫번째
        int change = 0;
        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (origin[i][j] != start) change++;
                start = (!start);
            }
            //줄변경시 tf 바뀜
            start = (!start);
        }
        change = (change < (64 - change)) ? change : (64 - change);
        min = (min < change) ? min : change;
    }
}


import java.io.*;
import java.util.StringTokenizer;

public class no16926 { //302352	940
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int times = (n < m ? n : m) / 2;

        int[][] a = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bfr.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < r; i++) {
            int[][] arr = new int[n][m];
            for (int j = 0; j < times; j++) {
                for (int h = j; h < n - 1 - j; h++) {
                    arr[h + 1][j] = a[h][j]; //down
                }
                for (int h = j; h < m - 1 - j; h++) {
                    arr[n - 1 - j][h + 1] = a[n - 1 - j][h]; //>>>>
                }
                for (int h = n - 1 - j; h > j; h--) {
                    arr[h - 1][m - 1 - j] = a[h][m - 1 - j]; //^^^
                }
                for (int h = m - 1 - j; h > j; h--) {
                    arr[j][h - 1] = a[j][h]; //<<<<
                }
            }
            a = arr;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bfw.write(a[i][j] + " ");
            }
            bfw.write("\n");
        }
        bfw.flush();

    }
}
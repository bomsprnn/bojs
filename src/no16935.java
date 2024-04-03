import java.io.*;
import java.util.StringTokenizer;

public class no16935 { //64552	532
    static int[][] a;
    static int n, m, r;

    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bfr.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(bfr.readLine());
        for (int i = 0; i < r; i++) {
            int num = Integer.parseInt(st.nextToken());
            switch (num) {
                case 1:
                    case1();
                    break;
                case 2:
                    case2();
                    break;
                case 3:
                    case3();
                    break;
                case 4:
                    case4();
                    break;
                case 5:
                    case5();
                    break;
                case 6:
                    case6();
                    break;
            }
        }
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                bfw.write(a[j][k] + " ");
            }
            bfw.write("\n");
        }


        bfw.flush();

    }

    private static void case1() {
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                arr[n - 1 - i][j] = a[i][j];
        }
        a = arr;
    }

    private static void case2() {
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                arr[i][m - 1 - j] = a[i][j];
        }
        a = arr;

    }

    private static void case3() {
        int[][] arr = new int[m][n];
        int v = n - 1;
        for (int i = 0; i < n; i++, v--) {
            for (int j = 0; j < m; j++)
                arr[j][v] = a[i][j];

        }
        int tmp = n;
        n = m;
        m = tmp;
        a = arr;
    }

    private static void case4() {
        int[][] arr = new int[m][n];
        int v = n - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                arr[m - 1 - j][i] = a[i][j];
        }
        int tmp = n;
        n = m;
        m = tmp;
        a = arr;

    }

    private static void case5() {
        int[][] arr = new int[n][m];
        int nmid = n / 2;
        int mmid = m / 2;

        for (int i = 0; i < nmid; i++) {
            for (int j = 0; j < mmid; j++) {
                arr[i][j + mmid] = a[i][j];
            }
        } //1-2
        for (int i = 0; i < nmid; i++) {
            for (int j = mmid; j < m; j++) {
                arr[i + nmid][j] = a[i][j];
            }
        } //2-3
        for (int i = nmid; i < n; i++) {
            int k = 0;
            for (int j = mmid; j < m; j++, k++) {
                arr[i][k] = a[i][j];
            }
        } //3-4
        int init = 0;
        for (int i = nmid; i < n; i++, init++) {
            for (int j = 0; j < mmid; j++) {
                arr[init][j] = a[i][j];
            }
        }//4-1
        a = arr;
    }

    private static void case6() {
        int[][] arr = new int[n][m];
        int nmid = n / 2;
        int mmid = m / 2;
        for (int i = 0; i < nmid; i++) {
            for (int j = 0; j < mmid; j++) {
                arr[i + nmid][j] = a[i][j];
            }
        }//1-4
        for (int i = nmid; i < n; i++) {
            for (int j = 0; j < mmid; j++) {
                arr[i][j + mmid] = a[i][j];
            }
        }//4-3
        int k = 0;
        for (int i = nmid; i < n; i++, k++) {
            for (int j = mmid; j < m; j++) {
                arr[k][j] = a[i][j];
            }
        }// 3-2
        for (int i = 0; i < nmid; i++) {
            int init = 0;
            for (int j = mmid; j < m; j++, init++) {
                arr[i][init] = a[i][j];
            }
        }
        a = arr;
    }
}

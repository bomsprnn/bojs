import java.io.*;
import java.util.StringTokenizer;

public class no15650 {//15856	144

    static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static boolean[] check;
    public static int[] arr;
    static int n, m;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(bfr.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m]; //depth 를 체크하는 용도
        dfs(0, 0);

    }

    private static void dfs(int s, int dep) throws IOException {
        if (dep == m) {
            int k = arr.length;
            for (int i = 0; i < k; i++) bfw.write(arr[i] + " ");
            bfw.write("\n");
            return;
        }
        for (int i = s; i < n; i++) {
            arr[dep] = i + 1;
            dfs(i + 1, dep + 1);
        }
        bfw.flush();
    }
}

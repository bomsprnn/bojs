import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no15663 {
    static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    public static boolean[] check;
    public static int[] arr, obj;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        obj = new int[n];
        st = new StringTokenizer(bfr.readLine());
        for (int i = 0; i < n; i++) {
            obj[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(obj);
        arr = new int[m]; //m개 고른 배열
        check = new boolean[n];
        dfs(0, 0);
    }

    private static void dfs(int s, int dep) throws IOException {
        if (dep == m) {
            int k = arr.length;
            for (int i = 0; i < k; i++) bfw.write(arr[i] + " ");
            bfw.write("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                if (i > 0 && obj[i - 1] == obj[i] && !check[i - 1]) continue;
                check[i] = true;
                arr[dep] = obj[i];
                dfs(i, dep + 1);
                check[i] = false;

            }
        }

        bfw.flush();
    }
}

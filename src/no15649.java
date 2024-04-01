import java.io.*;
import java.util.StringTokenizer;

public class no15649 { ///44668	884
    static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static boolean[] check;
    public static int[] arr;

    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bfr.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        check = new boolean[n]; //방문했는지 확인하는 용도
        arr = new int[m]; //depth 를 체크하는 용도

        dfs(0);
        bfw.flush();

    }

    private static void dfs(int depth) throws IOException {

        if (depth == m) { //m개의 숫자를 모두 방문
            int k = arr.length;
            for (int i = 0; i < k; i++) {
                bfw.write(arr[i] + " ");
            }
            bfw.write("\n");

            return;
        }

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                check[i] = true;
                arr[depth] = i + 1; //배열에 저장

                dfs(depth + 1);

                check[i] = false;
            }
        }

    }
}

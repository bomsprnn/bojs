import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class no10816 { //189172	1288
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bfr.readLine());
        int[] narr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(bfr.readLine());
        for (int i = 0; i < n; i++) {
            narr[i] = Integer.parseInt(st.nextToken());
            if (map.get(narr[i]) == null) map.put(narr[i], 1);
            else map.put(narr[i], map.get(narr[i]) + 1);
        }

        int m = Integer.parseInt(bfr.readLine());
        st = new StringTokenizer(bfr.readLine());
        for (int i = 0; i < m; i++) {
            int k = Integer.parseInt(st.nextToken());
            if (map.get(k) == null) bfw.write(0 + " ");
            else bfw.write(map.get(k) + " ");
        }
        bfw.flush();
    }
}

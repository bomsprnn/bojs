import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class no1764 {//26764	300
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(bfr.readLine());
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String name = bfr.readLine();
            if (set.contains(name)) list.add(name);
        }
        Collections.sort(list);
        int size = list.size();
        bfw.write(size+"\n");
        for (int i = 0; i < size; i++){
            bfw.write(list.get(i)+"\n");
        }
        bfw.flush();

    }
}
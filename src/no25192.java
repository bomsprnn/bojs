import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class no25192 {//25580	282
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bfr.readLine());
        Set<String> set = new HashSet<>();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String name = bfr.readLine();
            if (name.equals("ENTER")) {
                cnt += set.size();
                set.clear();
            } else set.add(name);
        }
        bfw.write(cnt+ set.size()+"");
        bfw.flush();

    }
}

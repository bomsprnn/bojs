import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class no2002 { //14412	152
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<String> in = new LinkedList<>();
        int n = Integer.parseInt(bfr.readLine());
        for (int i = 0; i < n; i++) {
            in.add(bfr.readLine());
        }
        Queue<String> out = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            out.add(bfr.readLine());
        }
        int cnt = 0;
        while (!in.isEmpty()) {
            String o = out.poll();
            if (in.peek().equals(o)) in.poll();
            else {
                in.remove(o);
                cnt++;
            }
        }
        bfw.write(cnt + "");
        bfw.flush();
    }
}

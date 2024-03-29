import java.io.*;
import java.util.StringTokenizer;

public class no24313 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());

        int c = Integer.parseInt(bfr.readLine());
        int n0 = Integer.parseInt(bfr.readLine());

        if ((a1 * n0 + a2) <= (c * n0) &&c>=a1) bfw.write(1 + "");
        //a1이 음수일경우 ? c-a1<0 부등식 항상 성립하지않는다
        else bfw.write(0 + "");

        bfw.flush();
    }
}

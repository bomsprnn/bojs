import java.io.*;
import java.util.StringTokenizer;

public class no2566 { //16264	152
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int max = -1;
        int r = 0;
        int c = 0;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(bfr.readLine());
            for (int j = 0; j < 9; j++) {
                int a = (Integer.parseInt(st.nextToken()));
                if (a > max) {
                    max = a;
                    r = i + 1;
                    c = j + 1;
                }
            }
        }
        bfw.write(max + "\n" + r + " " + c);


        bfr.close();
        bfw.flush();
    }
}
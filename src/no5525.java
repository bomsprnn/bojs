import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class no5525 {
    public static void main(String[] args) throws Exception { //20088	284
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bfr.readLine());
        int m = Integer.parseInt(bfr.readLine());
        String s = bfr.readLine();

        int cnt = 0;
        int ioi = 0;
        for (int i = 0; i < m - 2; i++) {

            if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'O' && s.charAt(i + 2) == 'I') {
                ioi++;
                if (ioi >= n) cnt++;
                i++; //i다음은 무조건 o
            }else ioi =0;
        }
        bfw.write(cnt + "");
        bfw.flush();


    }
}

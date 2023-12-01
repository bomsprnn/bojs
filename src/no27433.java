import java.io.*;

public class no27433 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bfr.readLine());
        long result =1;
        for (int i =1; i<=n ;i++){
            result *=i;
        }
        bfr.close();
        bfw.write(result+"");
        bfw.flush();
        bfw.close();
    }
}

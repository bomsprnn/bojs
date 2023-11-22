import java.io.*;

public class no15439 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bfr.readLine());

        int result = n*(n-1);
        bfw.write(result+" ");
        bfr.close();
        bfw.flush(); bfw.close();
    }
}

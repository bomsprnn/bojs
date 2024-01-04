import java.io.*;
import java.util.StringTokenizer;

public class no11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        st= new StringTokenizer(bfr.readLine());
        for(int i=1; i<=n;i++){
            arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(bfr.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int result = arr[to]-arr[from-1];
            bfw.write(result+"\n");
        }
        bfw.flush();


    }
}

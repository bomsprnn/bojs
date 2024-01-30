import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bfr.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        for(int i=0;i<n;i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int result = arr[0];
        for(int i=1;i<n;i++){
            arr[i]+=arr[i-1];
            result+=arr[i];
        }

        bfw.write(result+" ");
        bfw.flush();

    }
}

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no2559 {
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bfr.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        StringTokenizer st2 = new StringTokenizer(bfr.readLine());
        for(int i=0;i<n;i++){
            arr[i]= Integer.parseInt(st2.nextToken());
        }

        for(int i=0;i<n-k+1;i++){
            int a = arr[i];
            for(int j=i;j<k+i-1;j++){
                a+=arr[j+1];
            }

            max = Math.max(a,max);
        }

        bfw.write(max +" ");
        bfw.flush();



    }
}

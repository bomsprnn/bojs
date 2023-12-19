import java.io.*;
import java.util.StringTokenizer;

public class no1912 {
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bfr.readLine());

        int[] arr = new int[n];
        int[] arr2 = new int[n];


        StringTokenizer st = new StringTokenizer(bfr.readLine());
        for(int i =0; i<n ; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }

        arr2[0]= arr[0];
        int max = arr[0];

        for(int i=1; i<n ; i++){
            arr2[i]= Math.max(arr[i],arr2[i-1]+arr[i]);
            max = Math.max(arr2[i],max);
        }
        bfw.write(max+" ");
        bfw.flush();
        bfw.close();
        bfr.close();


    }
}

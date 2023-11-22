import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int n = Integer.parseInt(bfr.readLine());

        int[] arr = new int[n];
        st= new StringTokenizer(bfr.readLine());
        for(int i=0;i<n;i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }
        bfr.close();
        Arrays.sort(arr);
        int result = arr[0]*arr[arr.length-1];
        bfw.write(result+"");
        bfw.flush();
        bfw.close();
    }
}


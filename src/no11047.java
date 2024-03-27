import java.io.*;
import java.util.StringTokenizer;

public class no11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bfr.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int cnt =0;
        // 동전 개수 최소로 k 만들기
        for(int i=0; i<n ;i++){
            arr[i]= Integer.parseInt(bfr.readLine()); // 동전 입력
        }

        for(int i=n-1;i>=0;i--){
            if(arr[i]<=k) {
                while(arr[i]<=k){
                    k = k - arr[i];
                    cnt++;
                }
            }
        }
        bfw.write(cnt+" ");
        bfw.flush();
    }
}

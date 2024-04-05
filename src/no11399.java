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
            arr[i]= Integer.parseInt(st.nextToken()); //순서대로 입력
        }
        Arrays.sort(arr); //그리디하게 가장 작은 수를 먼저 처리하기 위해 소팅
        int result = arr[0]; //정답 배열에 가장 작은 값 넣기
        for(int i=1;i<n;i++){
            arr[i]+=arr[i-1];
            result+=arr[i]; //이전 값에 더해서 더하기
        }

        bfw.write(result+" ");
        bfw.flush();

    }
}

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class no1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(bfr.readLine());
        int arr[][] = new int[n][2];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(bfr.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0]-o2[0];
                }
                return o1[1]-o2[1];
            } //종료 시간이 이른 순서대로 소팅
        });

        int count =0;
        int tmpend=0;

        for(int i=0; i<n;i++){
            if(tmpend <= arr[i][0]){ //종료 시간이 시작 시간보다 작으면
                tmpend = arr[i][1]; //태스크 수행 횟수 추가
                count++;
            }
        }
        bfw.write(count+" ");
        bfw.flush();
        bfr.close();
        bfw.close();


    }
}

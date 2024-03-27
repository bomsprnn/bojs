import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no2480 {
    public static void main(String[] args) throws IOException {
        /**
         * 3개의 주사위
         * 같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다.
         * 같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.
         * 모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.
         *
         *
         * 예를 들어, 3개의 눈 3, 3, 6이 주어지면 상금은 1,000+3×100으로 계산되어 1,300원을 받게 된다.
         * 또 3개의 눈이 2, 2, 2로 주어지면 10,000+2×1,000 으로 계산되어 12,000원을 받게 된다.
         * 3개의 눈이 6, 2, 5로 주어지면 그중 가장 큰 값이 6이므로 6×100으로 계산되어 600원을 상금으로 받게 된다.
         */

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));


        int arr[] = new int[3];

        StringTokenizer st = new StringTokenizer(bfr.readLine());
        for(int i=0;i<3;i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }

        int reward = 0;
        if(arr[0]==arr[1] && arr[1]==arr[2]){
            reward = 10000+arr[0]*1000;
        } else if (arr[0]==arr[1]||arr[0]==arr[2]) {
            reward = 1000+arr[0]*100;
        } else if (arr[1]==arr[2]) {
            reward = 1000+arr[1]*100;
        }else{
            Arrays.sort(arr);
            reward = arr[2]*100;
        }

        bfw.write(reward+" ");
        bfw.flush();

    }

    // 메모리 14688
    // 144ms

}

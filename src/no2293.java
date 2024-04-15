import java.io.*;
import java.util.*;
public class no2293 { //14272	140
    /**
     * 조건
     * n가지 종류의 동전을 사용해 가치의 합이 k원이 되도록 하는 경우의 수 구하기
     * <p>
     * 접근
     * 일단 코인 소팅하기.
     * 총 누적 경우의 수 = 이전 동전을 사용한 경우의 수 누적 + 현재 동전을 사용한 경우의 수
     * 예시에서 점화식 만들기 1,2,5원으로 10원 만들기
     *    1 2 3 4 5 6 7 8 9 10
     * 1  1 1 1 1 1 1 1 1 1 1
     * 2  0 1 1 2 2 3 3 4 4 5
     * 5  0 0 0 0 1 1 2 2 3 4
     *tot 1 2 2 3 4 5 6 7 8 10
     *
     * 동전 종류 순서대로 누적합 구하기
     * i를 만들고 싶을 때 ! coin-1까지 누적합 + i-coin 누적합
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n]; // 동전 종류
        int[] sum = new int[k + 1]; // 경우의 수 저장
        sum[0] = 1; // 0원 만드는 경우의 수는 1
        for(int i = 0; i < n; i++){
            coin[i] = Integer.parseInt(bfr.readLine());
        } // 동전 종류 입력

        for(int i = 0; i < n; i++){ // 동전 종류
            for(int j = coin[i]; j <= k; j++){ // 경우의수 누적
                sum[j] += sum[j - coin[i]]; //tot
            }
        } // 동전 종류별로 경우의 수 누적

        bfw.write(sum[k] + "");
        bfw.flush();

    }
}

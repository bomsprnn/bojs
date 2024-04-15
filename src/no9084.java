import java.util.*;
import java.io.*;
public class no9084 {
    /**
     * 조건
     * 동전에는 1원, 5원, 10원, 50원, 100원, 500원
     * 동전의 종류가 주어질 때에 주어진 금액을 만드는 모든 방법을 세는 프로그램
     *
     * 접근
     * ?? 3번 문제랑 똑같은데요...
     *
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(bfr.readLine()); // 테스트 케이스

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(bfr.readLine()); // 동전의 가지 수
            int[] coin = new int[n]; // 동전 종류
            StringTokenizer st = new StringTokenizer(bfr.readLine());
            for(int j = 0; j < n; j++){
                coin[j] = Integer.parseInt(st.nextToken());
            } // 동전 종류 입력
            int m = Integer.parseInt(bfr.readLine()); // 만들어야 하는 금액

            int[] sum = new int[m + 1]; // 경우의 수 저장
            sum[0] = 1; // 0원 만드는 경우의 수는 1
            for(int j = 0; j < n; j++){ // 동전 종류
                for(int k = coin[j]; k <= m; k++){ // 경우의수 누적
                    sum[k] += sum[k - coin[j]]; //tot
                }
            } // 동전 종류별로 경우의 수 누적

            bfw.write(sum[m] + "\n");

        }

        bfw.flush();
    }
}

import java.io.*;
import java.util.*;
public class no2133 {
    /**
     * 조건
     *  3×N 크기의 벽을 2×1, 1×2 크기의 타일로 채우는 경우의 수
     *
     * 접근
     *
     * 타일의 종류가 2개밖에 없으니까 1x2 기준으로 끼워넣을 수 있는 경우 구하기
     * n이 홀수? 1x2 타일로 채울 수 없음 !!!
     * n이 짝수? 1x2 타일로 채울 수 있음
     * 3x2 타일 기준으로 붙여나가는 경우 + 하기 ( 홀수는 어차피 제외)
     *
     * 예를들어 3x2 크기의 벽을 채우는 경우의 수
     * 12타일 ->  (1개사용) 2가지 + (3개사용) 1가지
     *  tot 3가지
     *  3x4 크기의 벽을 채우는 경우의 수
     *  12타일 -> 3x2 경우의 수 ^2 + 2     tot 11가지
     * ??????
     *   이어지는 부분에 가능한 경우의 수가 또있음..
     *
     *  3x6 크기의 벽을 채우는 경우 6을 2,4로 나누기 (혹은 4,2)
     *
     *  3x8 크기의 벽을 채우는 경우
     *  8을 2,6으로 나누기 -- 얘는 그냥 F[6] * F[2]
     *  4,4로 나누기 --> 가장 마지막 3x2 타일에서 예외모양 사용 (F[4] * 2)
     *  6,2로 나누기 --
     *  = 123+22+6+2 = 153
     *       *  n이 2씩 늘어날 때 마다 예외케이스모양(?)이 2개씩 늘어남
     *  점화식으로 표혀ㅑㄴ하면
     *  F[8] = ( F[6] * F[2] ) + ( F[4] * 2 ) + ( F[2] * 2 ) + ( F[0] * 2 )
     *  -> F[n] = F[n-2] * F[2] + F[n-4] * 2 + F[n-6] * 2 + ... + F[0] * 2
     *
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bfr.readLine());
        if (n % 2 != 0) bfw.write("0");

        else { //짝수인 경우
            int[] dp = new int[31];
            dp[0] = 1;
            dp[1] = 0;
            dp[2] = 3; //F[n] = F[n-2] * F[2]
            for (int i = 4; i <= n; i += 2) {
                dp[i] = dp[i - 2] * dp[2];
                for (int j = i - 4; j >= 0; j -= 2) {
                    dp[i] += dp[j] * 2; //+ F[n-4] * 2 + F[n-6] * 2 + ... + F[0] * 2
                }
            }
            bfw.write(dp[n] + "");
        }

        bfw.flush();
    }
}

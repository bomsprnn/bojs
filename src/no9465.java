import java.io.*;
import java.util.*;

public class no9465 {
    /**
     * 스티커
     * 스티커 2n개를 구매. 스티커는 그림 (a)와 같이 2행 n열로 배치
     * 스티커 한 장을 떼면, 그 스티커와 변을 공유하는 스티커는 모두 찢어져서 사용할 수 없게 된다.
     * 각 스티커에 점수를 매기고, 뗄 수 있는 스티커의 점수의 최댓값
     * <p>
     * 접근
     * 2차원 배열에 저장, dp?
     * 가장 많이 떼는 방법 - 지그재그로 떼기
     * dp[0][i] = dp[1][i-1] + grid[0][i]
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(bfr.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bfr.readLine());
            int[][] sticker = new int[2][n + 2];
            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(bfr.readLine());
                for (int k = 1; k <= n; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            sticker[0][2] += sticker[1][1];
            sticker[1][2] += sticker[0][1];

            for (int j = 3; j <= n; j++) {
                sticker[0][j] += Math.max(sticker[1][j - 1], sticker[1][j - 2]);
                sticker[1][j] += Math.max(sticker[0][j - 1], sticker[0][j - 2]);
            }
            bfw.write(Math.max(sticker[0][n], sticker[1][n]) + "\n");
        }
        bfw.flush();
    }
}

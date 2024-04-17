import java.io.*;
import java.util.*;

public class no2212 {
    /**
     * 센서
     * 고속도로 위에 N개의 센서, 최대 K개의 집중국
     * N개의 센서가 적어도 하나의 집중국과는 통신이 가능해야 하며,
     * 각 집중국의 수신 가능 영역의 길이의 합을 최소화
     * 각 센서의 좌표는 정수 하나로 표현
     * <p>
     * 접근
     *
     * 유치원문제랑 똑같음 !!!!!!!!!!
     *
     * 센서 좌표를 정렬하고 각 센서 사이의 거리를 구하기
     * 가장 긴 거리부터 K-1개를 제거
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bfr.readLine());
        int k = Integer.parseInt(bfr.readLine());
        int[] sen = new int[n];
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        for (int i = 0; i < n; i++) {
            sen[i] = Integer.parseInt(st.nextToken());
        } // 센서 좌표 입력받고

        Arrays.sort(sen); // 소트때리기

        int[] diff = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diff[i] = sen[i + 1] - sen[i];
        } // 센서 사이 거리

        Arrays.sort(diff);

        int result = 0;
        for (int i = 0; i < n - k; i++) {
            result += diff[i];
        }

        bfw.write(result + "");
        bfw.flush();
    }
}

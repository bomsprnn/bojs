import java.io.*;
import java.util.StringTokenizer;

public class no2805 {//	119296	516ms 시간 복잡도는
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bfr.readLine());
        int[] arr = new int[n];
        long max = 0; //나무의 최대 높이
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());//나무의 높이 배열
            if (arr[i] > max) {
                max = arr[i]; //나무의 최대 높이 찾기
            }
        }

        /**
         * 접근
         * 나무들을 자를 높이 값을 잡고, 나무 순회하며
         *
         *(나무높이-자르는 높이) 의 합이 m보다 크거나 같을 때 성립
         * 나무 높이가 자ㄹ는 높이보다 낮아 음수일때 처리하기
         * 1. while 문으로 max-- 하면서 값 찾기 -> 시간 초과!!!
         * 2. 이분탐색으로 찾기
         */

        long start = 0;
        long end = max;

        while (start <= end) {
            long mid = (end + start) / 2; //이분탐색
            long sum = 0; //m보다 크거나 같은지 확인하기 위한 변수
            for (int i = 0; i < n; i++) {
                if (arr[i] > mid) {
                    sum += arr[i] - mid; //나무 높이가 자르는 높이보다 클 때만 더하기
                }
            }
            if (sum >= m) {
                start = mid + 1; //m보다 크거나 같을 때 (자르는 높이를 높여야함)
            } else {
                end = mid - 1; //m보다 작을 때 (자르는 높이를 낮춰야함)
            }
        }
        bfw.write(end + "");
        bfw.flush();

    }
}

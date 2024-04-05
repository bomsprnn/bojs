import java.io.*;
import java.util.StringTokenizer;

public class no3079 {//23828	320
    public static void main(String[] args) throws IOException {

        /**
         * 접근
         *  모든 경우를 구하면 .. 씨피유터짐 m이 10^9임;;
         *  임의의 시간 mid로 잡고, 이 때 심사대에서의 수용 인원이 m보다 크거나 같으면 시간을 줄이고
         *  m보다 작으면 시간을 늘려야함
         *
         *
         */

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int n = Integer.parseInt(st.nextToken()); //심사대 개수
        int m = Integer.parseInt(st.nextToken()); //사람 수
        int[] time = new int[n];
        long max = 0;
        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(bfr.readLine());//심사대 시간 배열에 저장
            if (time[i] > max) max = time[i]; //심사대 시간 중 최대값 찾기
        }

        long start = 0;
        long end = max * m; //최대값

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;
            for (int i = 0; i < n&& sum<=m; i++) {
                //자꾸 ..오버플로우 나는 것 같아서 sum<=m 조건 추가
                sum += mid / time[i]; //심사대 소요 시간으로 나누면 인원 도출 가능
            }
            if (sum >= m) { //이 인원이 m보다 크거나 같을 때 -> 더 많은 인원을 수용하는상태 -> 시간을 더 단축할 수 있다
                end = mid - 1; //mid 보다 작은 구간 절반 잘라 탐색
            } else {
                start = mid + 1; //mid 보다 큰 구간 절반 잘라 탐색
            }
        }
        bfw.write(start + "");
        bfw.flush();

    }
}

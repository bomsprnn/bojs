import java.io.*;
import java.util.StringTokenizer;

public class no1072 {//14308	124ms
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        /**
         * 조건
         * 게임 횟수 x와 이긴 게임 y가 주어진다.
         * 승률은 y/x로, 소수점은 버린다.
         * 최소 몇 판을 더 해야  승률이 변하는가?
         *
         * 접근
         * 승률이 절대 변하지 않는 경우 : 승률이 99% 이상일 때 ? (이미 진 게임이 있으니까)
         * 이분탐색으로 앞으로 해야 할 게임의 최소 값을 구한다..
         * 오버플로우 조심!!!!!!!!!!!11
         *
         */

        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int x = Integer.parseInt(st.nextToken()); //게임 횟수
        int y = Integer.parseInt(st.nextToken()); //이긴 게임 수
        long z = (y * 100L) / x; //현재 승률 (소수점 버리고) --> 이자식 long 안해주면 percent랑 비교할 때 문제생김니다

        if (z >= 99) bfw.write("-1"); //승률 변화가 없는 경우 -1 출력
        else {
            long low = 0;
            long high = 1000000000;
            while (low <= high) {
                long mid = (low + high) / 2;
                long percent = ((y + mid) * 100) / (x + mid); //mid판 더 했을 때 승률 구해보고

                if (percent > z) high = mid - 1; //만약 현재 승률보다 높으면 high값 조정
                else low = mid + 1; //현재 승률보다 낮으면 low값 조정
            }
            int i=38;
            bfw.write(i);
            bfw.write(low + "");
        }
        bfw.flush();
    }
}

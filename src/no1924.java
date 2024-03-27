import java.io.*;
import java.util.StringTokenizer;

public class no1924 {

    /**
     * 오늘은 2007년 1월 1일 월요일이다. 그렇다면 2007년 x월 y일은 무슨 요일일까?
     * 첫째 줄에 빈 칸을 사이에 두고 x(1 ≤ x ≤ 12)와 y(1 ≤ y ≤ 31)이 주어진다.
     * 참고로 2007년에는 1, 3, 5, 7, 8, 10, 12월은 31일까지,
     * 4, 6, 9, 11월은 30일까지,
     * 2월은 28일까지 있다.
     * <p>
     * 첫째 줄에 x월 y일이 무슨 요일인지에 따라 SUN, MON, TUE, WED, THU, FRI, SAT중 하나를 출력한다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // count of days 1월 to 12월
        String[] day = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

        int passday = 0;

        for (int i = 0; i < x - 1; i++) {
            passday += month[i];
        }
        passday = passday + y - 1;

        bfw.write(day[passday % 7]);
        bfw.flush();
    }
}
//14220	124
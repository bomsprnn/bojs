import java.io.*;
import java.util.StringTokenizer;

/**
 * 세 자리 수가 주어지고, 수를 뒤집기
 * 그 중 더 큰 수 출력하기
 */
public class no2908 { //15776	144
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int ra = a % 10 * 100 + (a % 100 / 10) * 10 + a / 100;
        int rb = b % 10 * 100 + (b % 100 / 10) * 10 + b / 100;

        bfw.write(Math.max(ra, rb) + " ");
        bfw.flush();
    } //
}

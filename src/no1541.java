import java.io.*;
import java.util.StringTokenizer;

public class no1541 {
    public static void main(String[] args) throws IOException {
        int chk = Integer.MAX_VALUE; // 첫번째 수 인지 테스트 하기 위해 설정
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer sub = new StringTokenizer(bfr.readLine(), "-");
        while (sub.hasMoreTokens()) {
            int tmp = 0;
            StringTokenizer add = new StringTokenizer(sub.nextToken(), "+");
            while (add.hasMoreTokens()) {
                tmp += Integer.parseInt(add.nextToken());
            }
            if (chk == Integer.MAX_VALUE)
                chk = tmp; //만약 처음 값과 같다면 (아직 tmp 값을 빼기 전이므로 처음 수라는 의미임
            else
                chk -= tmp;
        }
        bfr.close();
        bfw.write(chk+" ");
        bfw.flush();
        bfw.close();
    }
}

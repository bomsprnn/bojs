import java.io.*;
import java.util.StringTokenizer;

public class no2675 {
    public static void main(String[] args) throws IOException {
        /**
         * 문자열 S를 입력받은 후에,
         * 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램
         *
         * 첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다.
         * 각 테스트 케이스는 반복 횟수 R(1 ≤ R ≤ 8), 문자열 S가 공백으로 구분되어 주어진다.
         * S의 길이는 적어도 1이며, 20글자를 넘지 않는다.
         */

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bfr.readLine());
        for (int i=0;i<t;i++){
            StringTokenizer st = new StringTokenizer(bfr.readLine());
            int r = Integer.parseInt(st.nextToken(" "));
            String s=st.nextToken();
            for(int j=0;j<s.length();j++){
                for(int k=0;k<r;k++){
                    bfw.write(s.charAt(j));
                }
            }
            bfw.write("\n");
        }
        bfw.flush();

    }
}

//13980kb 128ms

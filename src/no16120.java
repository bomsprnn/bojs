import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class no16120 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        /**
         * 조건
         *  PPAP 문자열 : P -> PPAP 로 바꾸는 과정을 반복하여 만들 수 있는 문자열로 정의
         *  첫 번째 줄에 주어진 문자열이 PPAP 문자열이면 PPAP를, 아닌 경우 NP를 출력
         *
         *  접근
         *  문자열 속 PPAP를 P로 다시 바꾸는 과정을 반복하면?
         *  P로만 이루어진 문자열이 나올 것 .....같은데
         *  A가 남으면 np  ---> 시간초과!!!!!!!!!
         *  왜 ㅜㅜㅜㅜ...
         *
         */
        String str = bfr.readLine();
        boolean ppap = false;
        int len = str.length();

        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == 'A') {
                if (i + 1 < len && i - 2 >= 0) {
                    if (str.charAt(i - 1) == 'P' && str.charAt(i - 2) == 'P' && str.charAt(i + 1) == 'P') {
                        ppap = true;
                        i++;
                    } else {
                        ppap = false;
                        break;
                    }
                } else {
                    ppap = false;
                    break;
                }
            } else if (str.charAt(i) == 'P') {
                ppap = true;
            }


        }
        if (ppap) {
            bfw.write("PPAP");
        } else {
            bfw.write("NP");
        }
        bfw.flush();
    }
}
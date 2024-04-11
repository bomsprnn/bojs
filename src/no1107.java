import java.io.*;
import java.util.StringTokenizer;

public class no1107 { //16036	192ms
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        /**
         * 조건
         * 리모컨에는 버튼이 0부터 9까지, +와 -가 있다.
         * +를 누르면 현재 채널에서 +1 이동, -를 누르면 -1 이동
         * 채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다.
         * 수빈이가 지금 이동하려고 하는 채널은 N, 수빈이가 지금 보고 있는 채널은 100
         * 어떤 버튼이 고장났는지 주어졌을 때, 채널 N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지?
         *
         * 접근
         * 고장난 버튼이 없으면 +-버튼으로만 이동 / 숫자 버튼 이동 중 작은 값
         * 있으면 접근 후 +-버튼으로 이동
         *
         */
        int n = Integer.parseInt(bfr.readLine()); // 이동하려는 채널
        int m = Integer.parseInt(bfr.readLine()); // 고장난 버튼의 개수

        if (m == 0) { // 고장난 버튼이 없을 때 처리
            int min = n - 100 > 0 ? n - 100 : 100 - n; // +-버튼으로만 이동 
            min = Math.min(min, String.valueOf(n).length());  // 숫자 버튼으로만 이동과 비교해 작은 것 min
            bfw.write(min + "");
        } else {
            StringTokenizer st = new StringTokenizer(bfr.readLine());
            boolean[] failBtn = new boolean[10]; // 고장난 버튼 0~9
            for (int i = 0; i < m; i++) {
                failBtn[Integer.parseInt(st.nextToken())] = true;
            } // 고장난 버튼 체크


            int min = n - 100 > 0 ? n - 100 : 100 - n; // +-버튼으로만 이동

            for (int i = 0; i < 1000000; i++) {
                int press = 0; // 버튼 누르는 횟수
                int k = i; // 이동할 채널
                if (k == 0) {
                    if (failBtn[0]) press = -1; //이동할 수 없음
                    else press = 1; // 0일때 고장난 버튼이 아니면 1
                }
                while (k > 0) { // 이동할 채널이 0이 아닐때 버틑ㄴ을 통해 이동할 수 있는지 확인
                    if (failBtn[k % 10]) { // 오른쪽 부터 확인
                        press = -1; // 이동할 수 없음
                        break;
                    }
                    press++;
                    k /= 10; // 다음 자리수
                }
                if (press == -1) continue; // 고장난 버튼이 있어

                int result = press + Math.abs(n - i); // 숫자버튼 횟수+이동한 채널에서 + +-버튼으로 이동한 길이
                min = Math.min(min, result); // 최소값 갱신
            }

            bfw.write(min + "");
        }

        bfw.flush();
    }
}

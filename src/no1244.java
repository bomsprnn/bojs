import java.io.*;
import java.util.StringTokenizer;

public class no1244 {//15868	140
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bfr.readLine());
        int[] sw = new int[n];
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        for (int i = 0; i < n; i++) {
            sw[i] = Integer.parseInt(st.nextToken());
        } // 스위치 배열
        int k = Integer.parseInt(bfr.readLine());
        for (int i = 0; i < k; i++) { //학생수만큼 반복
            st = new StringTokenizer(bfr.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            //남학생일경우
            if (sex == 1) {
                for (int j = num; j <= n; j += num) { //배수
                    sw[j - 1] = sw[j - 1] == 1 ? 0 : 1;
                }
            } else { //여학생일경우
                int idx = num - 1;
                sw[idx] = sw[idx] == 1 ? 0 : 1;
                for (int j = 1; j < n; j++) {
                    if (idx - j < 0 || idx + j >= n) break;
                    if (sw[idx + j] != sw[idx - j]) break;
                    sw[idx + j] = sw[idx + j] == 1 ? 0 : 1;
                    sw[idx - j] = sw[idx - j] == 1 ? 0 : 1;

                }
            }
        }
        for (int i = 0; i < n; i++) {
            bfw.write(sw[i] + " ");
            if ((i+1) % 20 == 0) bfw.write("\n");

        } // 스위치 배열 출력
        bfw.flush();
    }
}

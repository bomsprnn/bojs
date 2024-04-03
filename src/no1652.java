import java.io.*;
import java.util.StringTokenizer;

public class no1652 { //17720	216
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        int w = 0;
        int h = 0;
        //x 기준으로 나누고 . 이 2이상이먄 카운ㅌ
        int n = Integer.parseInt(bfr.readLine());
        String[] vert = new String[n];

        for (int i = 0; i < n; i++) { //가로로 누울 자리
            String room = bfr.readLine();

            StringTokenizer st = new StringTokenizer(room, "X");
            int cnt = st.countTokens();
            for (int j = 0; j < cnt; j++) {
                if (st.nextToken().length() >= 2) w++;
            }


            for (int j = 0; j < n; j++) {
                if (vert[j] == null) vert[j] = "" + room.charAt(j);
                else vert[j] += room.charAt(j);

            }
        }
        for (int i = 0; i < n; i++) { //가로로 누울 자리
            String room = vert[i];
            StringTokenizer st = new StringTokenizer(room, "X");
            int cnt = st.countTokens();
            for (int j = 0; j < cnt; j++) {
                if (st.nextToken().length() >= 2) h++;
            }
        }
        bfw.write(w + " " + h);
        bfw.flush();

    }
}

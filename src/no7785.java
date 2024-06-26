import java.io.*;
import java.util.*;

public class no7785 { // 51256	768
    public static void main(String[] args) throws IOException {
        /**
         * 첫째 줄에 로그에 기록된 출입 기록의 수 n이 주어진다.(2 ≤ n ≤ 106)
         * 다음 n개의 줄에는 출입 기록이 순서대로 주어지며,
         *  각 사람의 이름이 주어지고 "enter"나 "leave"가 주어진다.
         *  "enter"인 경우는 출근, "leave"인 경우는 퇴근이다.
         *
         * 회사에는 동명이인이 없으며, 대소문자가 다른 경우에는 다른 이름이다.
         * 사람들의 이름은 알파벳 대소문자로 구성된 5글자 이하의 문자열이다.
         *
         * 출력
         * 현재 회사에 있는 사람의 이름을 사전 순의 역순으로 한 줄에 한 명씩 출력한다.
         */


        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bfr.readLine());
        Set<String> name = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bfr.readLine());
            String empl = st.nextToken();
            String log = st.nextToken();
            if (log.equals("leave")) name.remove(empl);
            else name.add(empl);
        }

        String[] result = name.toArray(new String[name.size()]);
        Arrays.sort(result, Collections.reverseOrder());
        for (int i = 0; i < result.length; i++) {
            bfw.write(result[i] + "\n");
        }
        bfw.flush();
    }
}
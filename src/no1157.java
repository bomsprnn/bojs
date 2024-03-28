import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class no1157 { //39612	420
    public static void main(String[] args) throws IOException {
        /**
         * 알파벳 대소문자로 된 단어가 주어지면,
         * 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오.
         *
         * 단, 대문자와 소문자를 구분하지 않는다.
         * 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
         */
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] arr = bfr.readLine().toUpperCase().toCharArray();

        int cnt = 0;
        int maxcnt = 0;
        char result = '?';

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        for (char key : map.keySet()) {
            cnt = map.get(key);
            if (cnt > maxcnt) {
                maxcnt = cnt;
                result = key;
            } else if (cnt == maxcnt) {
                result = '?';
            }
        }

        bfw.write(result + " ");
        bfw.flush();
    }
}

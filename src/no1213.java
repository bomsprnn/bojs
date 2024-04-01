import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class no1213 {//14288	128
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = bfr.readLine();
        char[] ans = new char[str.length()];

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        boolean cnt = true; // 홀수개인 요소 체크
        for (int val : map.values()) {
            if (val % 2 != 0 && !cnt) {
                bfw.write("I'm Sorry Hansoo");
                bfw.flush();
                return;
            }
            if (val % 2 != 0) cnt = false; // 홀수개 요소가 한 번만 나타날 때 체크
        }
        // 홀수인 요소가 1개를 초과하면 x

        char[] arr = new char[map.size()];
        int idx = 0;
        for (Character key : map.keySet()) {
            arr[idx++] = key;
        }
        Arrays.sort(arr); // 알파벳 개수 배열

        int start = 0;
        int end = str.length() - 1;
        char tmp = 'a';
        for (int i = 0; i < arr.length; i++) {
            char k = arr[i];
            if (map.get(k) % 2 == 0) {
                for (int j = 0; j < map.get(k); j += 2) {
                    ans[start++] = k;
                    ans[end--] = k;
                }
            } else {
                // 홀수인 경우
                for (int j = 1; j < map.get(k); j += 2) {
                    ans[start++] = k;
                    ans[end--] = k;
                }
                tmp = k; // 홀수인 문자 저장
            }
        }
        if (tmp != 'a') ans[start] = tmp; // 중간에 홀수인 문자 삽입
        for (int i = 0; i < ans.length; i++) {
            bfw.write(ans[i]);
            if (i != ans.length - 1) bfw.write("");
        }
        bfw.flush();
    }
}
import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class no28432 { //14268	128
    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bfr.readLine());
        String[] arr = new String[n];
        Set<String> used = new HashSet<>(); //이미 나온 단어

        char start = ' ', end = ' ';
        int endidx = -1;

        for (int i = 0; i < n; i++) {
            String word = bfr.readLine();
            if (word.equals("?")) {
                if (i == 0) endidx = i + 1; //처음으로 나온 경우//다음 단어의 첫글자 idx 저장
                else if (i == n - 1) { //마지막으로 나온 경우 전 단어의 마지막 글자 저장

                    start = arr[i - 1].charAt(arr[i - 1].length() - 1);
                } else {
                    endidx = i + 1;
                    start = arr[i - 1].charAt(arr[i - 1].length() - 1);
                }
            } else {
                arr[i] = word;
                used.add(word);
            }
        }

        if (endidx >= 0 && endidx < n) {
            end = arr[endidx].charAt(0);
        }

        int m = Integer.parseInt(bfr.readLine());
        for (int i = 0; i < m; i++) {
            String opt = bfr.readLine();
            if (used.contains(opt)) continue;

            if ((start == ' ' || opt.charAt(0) == start) && (end == ' ' || opt.charAt(opt.length() - 1) == end)) {
                bfw.write(opt);
                break;
            }
        }

        bfw.flush();
    }
}
import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class no11478ver2 { //230892	908
    static String str;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        /**
         * 문자열 S가 주어졌을 때, S의 서로 다른 부분 문자열의 개수를 구하는 프로그램을 작성하시오.
         *
         * 부분 문자열은 S에서 연속된 일부분을 말하며, 길이가 1보다 크거나 같아야 한다.
         *
         * 예를 들어, ababc의 부분 문자열은 a, b, a, b, c, ab, ba, ab, bc, aba, bab, abc, abab, babc, ababc가 있고, 서로 다른것의 개수는 12개이다.
         *
         * 입력
         * 첫째 줄에 문자열 S가 주어진다. S는 알파벳 소문자로만 이루어져 있고, 길이는 1,000 이하이다.
         *
         * 출력
         * 첫째 줄에 S의 서로 다른 부분 문자열의 개수를 출력한다.
         */
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        str = bfr.readLine();

        for (int i = 0; i < str.length(); i++) {
            makeCharSet(str.charAt(i) + "", i);
        }
        bfw.write(set.size() + " ");
        bfw.flush();
    }

    private static void makeCharSet(String s, int depth) {
        set.add(s);
        if (depth >= str.length() - 1) {
            return;
        }
        makeCharSet(s + str.charAt(depth + 1), depth + 1);

    }
}

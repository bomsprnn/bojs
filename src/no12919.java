import java.io.*;

public class no12919 {
    /**
     * 두 문자열 S와 T가 주어졌을 때, S를 T로 바꾸는 게임
     * - 문자열의 뒤에 A를 추가한다.
     * - 문자열의 뒤에 B를 추가하고 문자열을 뒤집는다.
     * 위를 활용해 S를 T로 바꿀 수 있는지 없는지 구하는 프로그램
     * <p>
     * 접근
     * s 에서 t로 가는 방법은 늘리는 연산밖에 없으므로
     * t의 길이에서 s를 뺸 만큼 연산하기
     * <p>
     * t에 연산을 역으로 적용하면서 s와 같아지는지 확인
     */

    static int times;
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String S = bfr.readLine();
        String T = bfr.readLine();

        times = T.length() - S.length(); // 두 문자열의 길이 차이 (몇 번의 연산을 수행해야하는지)
        if (recur(S, T, 0)) {
            System.out.println(1);
        } else System.out.println(0);

    }

    private static boolean recur(String s, String t, int depth) {
        if (depth==times) { // 두 문자열의 개수 차이
            if (s.equals(t)) { // 두 문자열이 같은지 확인
                return true; // 같으면 true
            } else {
                return false; // 다르면 false (더이상 연산의 여지 없음)
            }
        }
        if (t.charAt(t.length() - 1) == 'A') { // t의 마지막 문자가 A인 경우 : t의 마지막 문자를 제거
            return recur(s, t.substring(0, t.length() - 1), depth + 1);
        } else {
            return recur(s, new StringBuilder(t.substring(1)).reverse().toString(), depth + 1);
            // t의 마지막 문자를 제거하고 뒤집음
        }
    }
}

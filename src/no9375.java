import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class no9375 {//15844	148ms
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(bfr.readLine()); //테스트 케이스


        for (int i = 0; i < t; i++) {
            Map<String, Integer> map = new HashMap<>();
            int n = Integer.parseInt(bfr.readLine()); //옷의 개수
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(bfr.readLine());
                String name = st.nextToken(); //옷의 이름
                String cate = st.nextToken(); //옷의 종류
                if (map.containsKey(cate)) map.put(cate, map.get(cate) + 1); //맵에 존재하면 기존값 +1
                else map.put(cate, 1); //없다면 1로 초기화

            }
            int result = 1;
            for (int k : map.values()) result *= k + 1; // 마지막을 null로 취급해서 조합
                /*
                 * hat headgear
                 * sunglasses eyewear
                 * turban headgear 가 주어졌을 때,
                 *
                 * [hat, turban, null]
                 * [headgear, null] 로 조합 만들기 --> 3 * 2 = 6 가지 경우의 수
                 * 단, 모두 안입는 경우는 없으므로 -1 (null, null) 조합 제외
                 */

            bfw.write(result - 1 + "\n");
        }

        bfw.flush();
    }
}

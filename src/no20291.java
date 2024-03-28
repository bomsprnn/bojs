import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class no20291 { //53536	836
    /**
     * 파일을 확장자 별로 정리해서 몇 개씩 있는지 알려줘
     * 보기 편하게 확장자들을 사전 순으로 정렬해 줘
     * 첫째 줄에 바탕화면에 있는 파일의 개수 $N$이 주어진다.
     * ($1 \leq N \leq 50\ 000$)
     * <p>
     * 둘째 줄부터 $N$개 줄에 바탕화면에 있는 파일의 이름이 주어진다.
     * 파일의 이름은 알파벳 소문자와 점(.)으로만 구성되어 있다.
     * 점은 정확히 한 번 등장하며, 파일 이름의 첫 글자 또는 마지막 글자로 오지 않는다.
     * 각 파일의 이름의 길이는 최소 $3$, 최대 $100$이다.
     * <p>
     * 출력
     * 확장자의 이름과 그 확장자 파일의 개수를 한 줄에 하나씩 출력한다.
     * 확장자가 여러 개 있는 경우 확장자 이름의 사전순으로 출력한다.
     */
    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bfr.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bfr.readLine(), ".");
            String name = st.nextToken();
            String ext = st.nextToken();
            if (map.containsKey(ext)) map.put(ext, map.get(ext) + 1);
            else map.put(ext, 1);
        }
        Object[] arr = map.keySet().toArray();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            bfw.write(arr[i] + " " + map.get(arr[i]) + "\n");
        }
        bfw.flush();
    }
}

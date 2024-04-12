import java.io.*;
import java.util.*;

public class no13164 { ///52852	632
    /**
     * 조건
     * N명의 원생들을 키 순서대로 일렬로 줄 세우고, 총 K개의 조로 나누기
     * 각 조에는 원생이 적어도 한 명 있어야 하며, 같은 조에 속한 원생들은 서로 인접
     * 조마다 티셔츠를 맞추는 비용은 조에서 가장 키가 큰 원생-가장 키가 작은 원생의 키
     * K개의 조에 대해 티셔츠 만드는 비용의 합을 최소로 하기
     * <p>
     * 접근
     * 제일 큰 수 - 작은 수 = 키차이 합
     * 키차이가 최대한 적어야하므로 인접한 애들사이의 키차이 모두 구하고     n-1회
     * k조로 나누어야한다.. k-1개의 키차이를 큰것부터 쳐내기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] kids = new int[n];
        int[] diff = new int[n - 1]; // 키차이
        st = new StringTokenizer(bfr.readLine());
        for (int i = 0; i < n; i++) {
            kids[i] = Integer.parseInt(st.nextToken());
        } // 유치원생 키 저장

        for (int i = 0; i < n - 1; i++) {
            diff[i] = kids[i + 1] - kids[i];
        } // 키차이 저장

        Arrays.sort(diff); // 키차이 정렬
        for (int i = 0; i < k - 1; i++) {
            diff[n - 2 - i] = 0;
        }// k개의 그룹을 만들어야 하므로 인접한 원생간의 키차이가 큰 경우부터 제외 ! (k-1)개
        // 큰 키차이가 한 그룹 안에 들어가지 않도록...

        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += diff[i];
        } // 남은 키차이 합 구하기

        bfw.write(sum + "");
        bfw.flush();
    }
}

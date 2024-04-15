import java.io.*;
import java.util.*;

public class no2565 { //14352	128
    /**
     * 조건
     * 전깃줄이 전봇대에 연결되는 위치는 전봇대 위에서부터 차례대로 번호가 매겨진다.
     * 두 전봇대 A와 B 사이에 하나 둘씩 전깃줄을 추가하다 보니 전깃줄이 서로 교차하는 경우가 발생
     * 전깃줄의 개수와 전깃줄들이 두 전봇대에 연결되는 위치의 번호가 주어질 때,
     * 남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수
     * <p>
     * 접근
     * a-b차이값 배열 구해서 소팅한다음 큰 애들부터 쳐내기  --> 실패~!!!!!!!
     *
     * a전봇대의 인덱스보다 b가 더 크거나 작은 경우가 반복되어야함
     * 일단  a 전봇대를 기준으로 소팅때리기
     * 전깃줄 위치 하나씩 비교하면서 이전과 겹치는지 확인
     * 겹치지 않으면 최대 전깃줄 수 갱신 ( 이 때 구하는 것은 겹치치 않는 전깃줄이므로 나중에 전체에서 빼줄것)
     *
     * a  1 2 3 4 5 6 7 8 9 10
     * b  8 2 9 1   4 6   7 10
     *tot 1 1 1 1   1 1   1 1
     *tot 1 1 2 1   2 3   4 5
     */     //39, 22 //76, 22, 64
                  //64, 22
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bfr.readLine()); // 전선 개수
        StringTokenizer st;
        int[][] wire = new int[n][2];
        int[] sum = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bfr.readLine());
            wire[i][0] = Integer.parseInt(st.nextToken()); // a 전봇대 인덱스
            wire[i][1] = Integer.parseInt(st.nextToken()); // b 전봇대 인덱스
        }
        Arrays.sort(wire, (a, b) -> Integer.compare(a[0], b[0])); // a 전봇대 인덱스 기준으로 소팅

        int result = 0;
        for (int i = 0; i < n; i++) { //a 전봇대 인덱스 기준 비교
            sum[i] = 1; // 1개일 때에는 무조건 겹치지 않음
            for (int j = 0; j < i; j++) { // 현재 보고있는 전선 인덱스보다 작은 경우탐색
                if (wire[i][1] > wire[j][1]) {
                    // 겹치지 않는 경우 (그림 상에서 현재 이어진 전깃줄보다 위 공간에서 이어지는 경우)
                    sum[i] = Math.max(sum[i], sum[j] + 1); // 겹치지 않는 전선 수 갱신
                }
            }
            result = Math.max(result, sum[i]);
        }
        bfw.write(n - result + ""); // 전체 전선 개수 - 가장 많이 겹치는 전선 개수
        bfw.flush();

    }

}

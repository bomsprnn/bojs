import java.io.*;
import java.util.StringTokenizer;

public class no2477 {
    public static void main(String[] args) throws IOException {
        /**
         * m2의 넓이에 자라는 참외의 개수는 헤아렸고, 이제 참외밭의 넓이만 구하면 된다.
         * 참외밭은 ㄱ-자 모양이거나 ㄱ-자를 90도, 180도, 270도 회전한 모양(┏, ┗, ┛ 모양)의 육각형
         * 밭의 한 모퉁이에서 출발하여 밭의 둘레를 돌면서 밭경계 길이를 모두 측정하였다.
         *
         * 첫 번째 줄에 1m2의 넓이에 자라는 참외의 개수를 나타내는 양의 정수 K (1 ≤ K ≤ 20)가 주어진다.
         * 참외밭을 나타내는 육각형의 임의의 한 꼭짓점에서 출발하여 반시계방향으로 둘레를 돌면서 지나는 변의 방향과 길이 (1 이상 500 이하의 정수) 가 둘째 줄부터 일곱 번째 줄까지 한 줄에 하나씩 순서대로 주어진다.
         * 변의 방향에서 동쪽은 1, 서쪽은 2, 남쪽은 3, 북쪽은 4로 나타낸다.
         */
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(bfr.readLine());
        int[][] arr = new int[6][2];
        int[] dir = new int[5];

        int maxh = 0;
        int maxw = 0;

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(bfr.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

            if (arr[i][0] == 1 || arr[i][0] == 2) { //가로일때
                if (maxw < arr[i][1]) {
                    maxw = arr[i][1];
                }
            } else if (maxh < arr[i][1]) {
                maxh = arr[i][1];

            }
        }

    }
}

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no2304 { //14608	140ms

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bfr.readLine());
        /**
         * 조건
         * 직선상에 서있는 n개의 막대
         * 막대의 높이는 1이상 1000이하
         * 막대의 솟은 부분이 지붕, 양 끝의 높이가 벽
         *
         * 접근
         * 빌딩이 좌표순서대로 주어지는 것이 아니므로 일단 정렬..
         * 일단 가장 높은 막대를 찾고 그 막대를 기준으로 좌 우 나누기
         * 좌 우에서 가장 높은 막대를 찾아서 그 높이로 채우기
         * 오->오 왼->왼으로 ++ -- 하며 인덱스의 종점까지 높은 건물 찾
         *
         * ...하 ....
         */

        Building[] buildings = new Building[n]; //빌딩 배열

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bfr.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            buildings[i] = new Building(x, y);

            //막대 배열에 저장
        }

        Arrays.sort(buildings, (a, b) -> a.x - b.x); //x좌표 기준으로 정렬
        int maxidx = 0; //가장 높은 막대 인덱스
        int max = 0; //가장 높은 막대 높이
        for (int i = 0; i < n; i++) { //가장 높은 막대 찾기
            if (buildings[i].y > max) {
                max = buildings[i].y;
                maxidx = i;
            }
        }
        int area = 0; //넓이

        int left = 0; //왼쪽 인덱스
        for (int i = 0; i <= maxidx; i++) {
            if (buildings[left].y <= buildings[i].y) { //왼쪽 끝에서부터
                area += buildings[left].y * (buildings[i].x - buildings[left].x);
                left = i;
            }
        }
        int right = n - 1; //오른쪽 인덱스
        for (int i = n - 1; i >= maxidx; i--) {
            if (buildings[right].y <= buildings[i].y) { //오른쪽 끝에서부터
                area += buildings[right].y * (buildings[right].x - buildings[i].x);
                right = i;
            }
        }

        area += max; //가장 높은 막대 높이 더하기 (밑면 1)

        bfw.write(area + "");
        bfw.flush();
    }

    public static class Building {
        int x; //막대 x좌표
        int y; //막대 높이

        public Building(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}

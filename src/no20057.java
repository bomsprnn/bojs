import java.io.*;
import java.util.StringTokenizer;

public class no20057 {
    /**
     * 크기가 N×N인 격자로 나누어진 모래밭
     * 토네이도가 x에서 y로 이동하면, y의 모든 모래가 비율과 α가 적혀있는 칸으로 이동
     * 비율이 적혀있는 칸으로 이동하는 모래의 양은 y에 있는 모래의 해당 비율만큼이고,
     * 계산에서 소수점 아래는 버린다.
     * α로 이동하는 모래의 양은 비율이 적혀있는 칸으로 이동하지 않은 남은 모래의 양과 같다.
     * 모래가 이미 있는 칸으로 모래가 이동하면, 모래의 양은 더해진다. 위의 그림은 토네이도가 왼쪽으로 이동할 때이고,
     * 다른 방향으로 이동하는 경우는 위의 그림을 해당 방향으로 회전하면 된다.
     * <p>
     * 토네이도는 (1, 1)까지 이동한 뒤 소멸한다. 모래가 격자의 밖으로 이동할 수도 있다. 토네이도가 소멸되었을 때,
     * 격자의 밖으로 나간 모래의 양을 구해보자.
     * <p>
     * 접근
     * 토네이도는 가운데부터 시작 (n/2, n/2)
     * 퍼져나가는 방향과 값은 배열 정의
     *
     * ㅜ.ㅜ 결국 못 풀어서 컨닝해ㅔ씁니다 .....
     * ㅡㅡ
     */

    static int n;
    static long out;
    static int[][] map;
    //모래 퍼지는 위치

    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {-1, 0, 1, 0};

    // 좌측 상단부터 1 234  4567  89 순서로
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bfr.readLine());

        map = new int[n][n];
        out = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bfr.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 이차원 배열 받기

        int start = n / 2; // 소용돌이 출발 지점
        spin(0, 0, 1, 0, start, start);
        System.out.println(out);

    }

    private static void spin(int cor, int cnt, int size, int dir, int x, int y) {
        if (x == 0 && y == 0) return; // 소용돌이 끝!
        int nx = x + dx[dir]; // 소용돌이 다음 좌표
        int ny = y + dy[dir];
        wind(x, y, dir, nx, ny); // 모래 퍼뜨리기
        cnt++;
        if (cnt == size) { // 한바퀴 돌았다면
            cor++;
            dir++;
            cnt = 0;
            dir %= 4;
        }
        if (cor == 2) {
            cor = 0;
            size++; // 한바퀴 돌때마다 사이즈 증가
        }
        spin(cor, cnt, size, dir, nx, ny);


    }

    public static void wind(int x, int y, int direction, int nx, int ny) {
        int now = map[nx][ny];
        int s1 = (int) (now * 0.01);
        int s2 = (int) (now * 0.02);
        int s5 = (int) (now * 0.05);
        int s7 = (int) (now * 0.07);
        int s10 = (int) (now * 0.1);
        int a = now - 2 * (s1 + s2 + s7 + s10) - s5;
        map[nx][ny] = 0;
        if (direction == 0 || direction == 2) {
//1%
            for (int i = 0; i < 2; i++) {
                int sx = x + dx[1 + 2 * i];
                int sy = y + dy[1 + 2 * i];
                if (check(sx, sy))
                    map[sx][sy] += s1;
                else
                    out += s1;
            }
//2%
            for (int i = 0; i < 2; i++) {
                int sx = nx + dx[1 + 2 * i] * 2;
                int sy = ny + dy[1 + 2 * i] * 2;
                if (check(sx, sy))
                    map[sx][sy] += s2;
                else
                    out += s2;
            }
//7%
            for (int i = 0; i < 2; i++) {
                int sx = nx + dx[1 + 2 * i];
                int sy = ny + dy[1 + 2 * i];
                if (check(sx, sy))
                    map[sx][sy] += s7;
                else
                    out += s7;
            }
//10%
            for (int i = 0; i < 2; i++) {
                int sx = nx + dx[direction] + dx[1 + 2 * i];
                int sy = ny + dy[direction] + dy[1 + 2 * i];
                if (check(sx, sy))
                    map[sx][sy] += s10;
                else
                    out += s10;
            }
            int sx = nx + dx[direction] * 2;
            int sy = ny + dy[direction] * 2;
            if (check(sx, sy))
                map[sx][sy] += s5;
            else
                out += s5;
            sx = nx + dx[direction];
            sy = ny + dy[direction];
            if (check(sx, sy))
                map[sx][sy] += a;
            else
                out += a;
        } else {
//1%
            for (int i = 0; i < 2; i++) {
                int sx = x + dx[2 * i];
                int sy = y + dy[2 * i];
                if (check(sx, sy))
                    map[sx][sy] += s1;
                else
                    out += s1;
            }
//2%
            for (int i = 0; i < 2; i++) {
                int sx = nx + dx[2 * i] * 2;
                int sy = ny + dy[2 * i] * 2;
                if (check(sx, sy))
                    map[sx][sy] += s2;
                else
                    out += s2;
            }
//7%
            for (int i = 0; i < 2; i++) {
                int sx = nx + dx[2 * i];
                int sy = ny + dy[2 * i];
                if (check(sx, sy))
                    map[sx][sy] += s7;
                else
                    out += s7;
            }
//10%
            for (int i = 0; i < 2; i++) {
                int sx = nx + dx[direction] + dx[2 * i];
                int sy = ny + dy[direction] + dy[2 * i];
                if (check(sx, sy))
                    map[sx][sy] += s10;
                else
                    out += s10;
            }
            int sx = nx + dx[direction] * 2;
            int sy = ny + dy[direction] * 2;
            if (check(sx, sy))
                map[sx][sy] += s5;
            else
                out += s5;
            sx = nx + dx[direction];
            sy = ny + dy[direction];
            if (check(sx, sy))
                map[sx][sy] += a;
            else
                out += a;
        }
    }

    public static boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}

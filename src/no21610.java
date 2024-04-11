import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class no21610 {
    /**
     * 조건
     * 크기가 N×N인 격자, 격자의 각 칸에는 바구니, 바구니 안에 물이 담겨있다.
     * 격자는 무한으로 이어지는 형태 (행과 열 모두)
     * 비바라기를 시전하면 (N, 1), (N, 2), (N-1, 1), (N-1, 2)에 비구름이 생긴다.
     * <p>
     * 구름에 이동을 M번 명령
     * 방향은 총 8개의 방향이 있으며, 8개의 정수로 표현한다. 1부터 순서대로 ←, ↖, ↑, ↗, →, ↘, ↓, ↙
     * 모든 구름이 di 방향으로 si칸 이동, 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가 -> 구름 소멸
     * 물이 증가한 칸에 물복사버그 시전 (대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼 (r, c)에 있는 바구니의 물이 양이 증가)
     * --> 물복사버그는 그리드 경계를 넘지 않음
     * 이동이 끝난 후 물이 2 이상인 모든 칸의 물의 양 -2 (구름 소멸 칸 제외)
     * m번의 이동이 끝난 후 바구니에 들어있는 물의 양의 합은?
     * <p>
     * 접근
     * 바구니의 위치는 이차원 배열로 받고, 구름은 자주 바뀌기 때문에 배열 말고 큐 사용
     */

    static int[][] map;
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int n, m;
    static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException { //23240	224
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bfr.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> cloud = new ArrayDeque<>();
        cloud.add(new int[]{n - 1, 0});
        cloud.add(new int[]{n - 1, 1});
        cloud.add(new int[]{n - 2, 0});
        cloud.add(new int[]{n - 2, 1});  // 비구름 생성

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bfr.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1; // 방향 (방향 인덱스는 0부터)
            int s = Integer.parseInt(st.nextToken()); // 거리

            // 구름 이동 및 비 내리기 / 소멸ㄱ
            boolean[][] prevCloud = new boolean[n][n];
            int cloudSize = cloud.size();
            for (int j = 0; j < cloudSize; j++) {
                int[] now = cloud.poll();
                int ny = ((now[0] + dy[d] * s) % n + n) % n; // +n 음수 케이스 처리
                int nx = ((now[1] + dx[d] * s) % n + n) % n;
                map[ny][nx]++; // 비 내려서 물 양 ++
                prevCloud[ny][nx] = true; // 구름 위치 저장
            }

            // 물복사버그
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    if (prevCloud[y][x]) { // 구름이 있던 바구니
                        int cnt = 0;
                        for (int k = 1; k < 8; k += 2) { //
                            int ny = y + dy[k];
                            int nx = x + dx[k];
                            if (ny >= 0 && nx >= 0 && ny < n && nx < n && map[ny][nx] > 0) cnt++;
                        }
                        map[y][x] += cnt;
                    }
                }
            }

            // 새로운 구름 생성
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    if (map[y][x] >= 2 && !prevCloud[y][x]) {
                        cloud.add(new int[]{y, x});
                        map[y][x] -= 2;
                    }
                }
            }
        }

        // 결과 계산
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result += map[i][j];
            }
        }

        bfw.write(result + "");
        bfw.flush();
    }

}

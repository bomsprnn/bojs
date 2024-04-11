import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no20056 {//맞았습니다!!	31372	336ms
    /**
     * 조건
     * 크기가 N×N인 격자에 파이어볼 M개를 발사
     * i번 파이어볼의 위치는 (ri, ci), 질량은 mi이고, 방향은 di, 속력은 si
     * 그리드 조건은 비바라기랑 동일
     * 파이어볼 명령 시
     * 모든 파이어볼이 자신의 di로 si칸 만큼 이동
     * 이동이 모두 끝난 뒤, 2개 이상의 파이어볼이 있는 칸에서
     * - 같은 칸에 있는 파이어볼은 모두 하나로 합쳐진다.
     * - 파이어볼은 4개의 파이어볼로 나누어진다.
     * - 나누어진 파이어볼의 질량, 속력, 방향은 다음과 같다.
     * 질량은 ⌊(합쳐진 파이어볼 질량의 합)/5⌋이다.
     * 속력은 ⌊(합쳐진 파이어볼 속력의 합)/(합쳐진 파이어볼의 개수)⌋이다.
     * 합쳐지는 파이어볼의 방향이 모두 홀수이거나 모두 짝수이면, 방향은 0, 2, 4, 6이 되고,
     * 그렇지 않으면 1, 3, 5, 7이 된다.
     * - 질량이 0인 파이어볼은 소멸되어 없어진다.
     * 마법사 상어가 이동을 K번 명령한 후, 남아있는 파이어볼 질량의 합을 구해보자
     */
    static Fireball[][] map;
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int sumM, result;

    //  ↑, ↗, →, ↘, ↓, ↙ ←, ↖, 0~7
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int n = Integer.parseInt(st.nextToken()); //그리드 크기
        int M = Integer.parseInt(st.nextToken()); // 파이어볼 개수
        int k = Integer.parseInt(st.nextToken()); // 명령 횟수


        Queue<Fireball> fireball = new ArrayDeque<>();
        map = new Fireball[n][n];
        result = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bfr.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1; // 1부터 시작
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireball.add(new Fireball(r, c, m, s, d));
        }

        for (int i = 0; i < k; i++) { // 명령 수행
            while (!fireball.isEmpty()) {
                Fireball now = fireball.poll(); // 큐에서 꺼내기
                int ny = ((now.r + dy[now.d] * now.s) % n + n) % n;
                int nx = ((now.c + dx[now.d] * now.s) % n + n) % n; //이동 후 좌표 계산

                if (map[ny][nx] == null) { // 이동할 위치에 파이어볼이 없다면
                    map[ny][nx] = new Fireball(ny, nx, now.m, now.s, now.d);
                } else { // 이동할 위치에 파이어볼이 있다면
                    map[ny][nx].m += now.m; // 질량 합
                    map[ny][nx].s += now.s; // 속력 합
                }
                map[ny][nx].size++; // 합쵸진 파이어볼 개수 증가
                if (now.d % 2 == 1) map[ny][nx].oddcnt++; // 방향이 홀수면 oddcnt 증가
            }

            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    if (map[j][l] != null) { // 맵이 재구성되므로 파이어볼 큐에 담고 map 초기화
                        fireball.add(map[j][l]);
                        map[j][l] = null;
                    }
                }
            }

            int size = fireball.size();
            while (size-- > 0){
                Fireball fireBall = fireball.poll();

                if(fireBall.size < 2) {
                    fireball.add(fireBall);
                    continue;
                }
                fireBall.m /= 5;
                fireBall.s /= fireBall.size;
                if (fireBall.m == 0) {
                    continue;
                }
                if (fireBall.oddcnt == 0 || fireBall.oddcnt == fireBall.size) {
                    for (int j = 0; j < 4; j++) {
                        fireball.add(new Fireball(fireBall.r, fireBall.c, fireBall.m, fireBall.s, j * 2));
                    }
                } else {
                    for (int j = 0; j < 4; j++) {
                        fireball.add(new Fireball(fireBall.r, fireBall.c, fireBall.m, fireBall.s, j * 2 + 1));
                    }
                }
            }

        }


        while (!fireball.isEmpty()) {
            result += fireball.poll().m;
        }
        bfw.write(result + "");
        bfw.flush();


    }

    private static class Fireball {
        int r, c, m, s, d;
        int size = 0;
        int oddcnt = 0;

        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}

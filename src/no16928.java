import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no16928 { //14580	132ms
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws IOException {
        /**
         * 조건
         * 크기가 10×10, 총 100개의 칸으로 나누어져 있는 보드판에서 진행
         * 보드판에는 1부터 100까지 수가 하나씩 순서대로 적혀져 있다.
         * 주사위를 굴려 나온 수만큼 이동
         * 만약 주사위를 굴린 결과가 100번 칸을 넘어간다면 이동할 수 없다.
         * 도착한 칸이 사다리면, 사다리를 타고 위로 올라간다.
         * 뱀이 있는 칸에 도착하면, 뱀을 따라서 내려가게 된다.
         *
         * 즉, 사다리를 이용해 이동한 칸의 번호는 원래 있던 칸의 번호보다 크고,
         * 뱀을 이용해 이동한 칸의 번호는 원래 있던 칸의 번호보다 작아진다.
         *
         * 게임의 목표는 1번 칸에서 시작해서 100번 칸에 도착하는 것
         * 게임판의 상태가 주어졌을 때, 100번 칸에 도착하기 위해 주사위를 굴려야 하는 횟수의 최솟값 구하기
         *
         * 접근
         * 일단 뱀과 사다리 상태를 그래프로 표현하고 bfs로 최단거리 구하기
         * 걍 배열 하나에 싹 ~~~~~~~!~~!~ 때려넣고 값을 포인터로 취급하고 관리
         *
         * 왜
         * 자꾸 메모리
         * 초과 ?           --> 방문 처리 안 해주어서 발생 (해ㅔ결)
         *
         */

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int n = Integer.parseInt(st.nextToken()); //사다리의 수
        int m = Integer.parseInt(st.nextToken()); //뱀의 수
        int[] board = new int[101];

        for (int i = 1; i <= n + m; i++) {
            st = new StringTokenizer(bfr.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x] = y; //x에서 y로 이동
        }

        bfw.write(bfs(board) + "");
        bfw.flush();


    }

    private static int bfs(int[] board) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0}); //시작점, 이동횟수
        visited[1] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 1; i <= 6; i++) {
                int next = cur[0] + i; //다이스 굴려서 이동할 위치 계산
                if (next == 100) return cur[1] + 1; //도착
                if (next < 0 || next > 100) continue; //범위 벗어나면 컨티뉴
                if (board[next] == 0) { //사다리나 뱀이 없는 경우
                    if (!visited[next]){
                        visited[next] = true;
                        queue.offer(new int[]{next, cur[1] + 1});
                    }
                } else if (board[next] != 0) {
                    next = board[next];
                    if (next == 100) return cur[1] + 1;
                    if (!visited[next]) visited[next] = true;
                    queue.offer(new int[]{next, cur[1] + 1});
                }
            }
        }
        return -1;
    }
}

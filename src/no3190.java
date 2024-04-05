import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class no3190 {
    /**
     * 게임은 NxN 정사각 보드위에서 진행,
     * 몇몇 칸에는 사과가 놓여져 있다. 보드의 상하좌우 끝에 벽
     * 시작할때 뱀은 맨위 맨좌측에 위치하고 뱀의 길이는 1 이다.
     * 뱀은 처음에 오른쪽을 향한다.
     * <p>
     * 먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
     * 만약 벽이나 자기자신의 몸과 부딪히면 게임이 끝난다.
     * 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
     * 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
     * 사과의 위치와 뱀의 이동경로가 주어질 때 이 게임이 몇 초에 끝나는지 계산하라.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bfr.readLine()); //nxn보드
        int k = Integer.parseInt(bfr.readLine()); //사과 개수
        int[][] map = new int[n][n]; //맵
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(bfr.readLine());
            map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1; //사과가 위치한 곳에 1
        }
        int l = Integer.parseInt(bfr.readLine()); //뱀의 방향 변환 횟수
        int[] dir = new int[10001]; //방향 변환 정보
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(bfr.readLine());
            int x = Integer.parseInt(st.nextToken()); //게임 시작 x초 후
            char c = st.nextToken().charAt(0); //방향 왼쪽( 'L') 또는 오른쪽( 'D')
            if (c == 'L') dir[x] = 1; //왼쪽
            else dir[x] = 2; //오른쪽
        }/** 입력값 세팅 **/

        /**
         * 뱀이 벽에 닿는 경우
         *  1. 뱀의 머리가 벽에 닿는 경우
         *  2. 뱀의 머리가 몸통에 닿는 경우
         *  뱀의 몸은 좌표로 표현, 덱 활용
         */

        /**
         * 구현
         * 일단 무한 루프 안에 가둬놓고 sec 변수 하나 두고 1++
         * 뱀의 머리가 다음으로 위치할 곳 -> 머리방향 +1
         *      벽에 부딪힌다? -> break
         *      사과가 있다? -> 머리만 늘리기, 사과 없애기
         *      사과가 없다? -> 꼬리 줄이기
         *      방향 전환? -> 방향 전환
         *      몸에 부딪힌다? -> break
         */
        Deque<int[]> snake = new ArrayDeque<>(); //뱀
        snake.add(new int[]{0, 0});
        int head = 0; //머리 방향 (오, 아래, 왼, 위) -> (0, 1, 2, 3)

        int sec = 0; //시간
        while (true) {
            sec++;
            int[] headPosition = snake.peekFirst(); //머리
            int heady = headPosition[0]; //헤드 y좌표
            int headx = headPosition[1]; //헤드 x좌표

            //머리가 다음으로 위치할 곳
            if (head == 0) headx++; //x좌표 +1 오른쪽
            else if (head == 1) heady++; //y좌표 +1 아래
            else if (head == 2) headx--; //x좌표 -1 왼쪽
            else heady--; //y좌표 -1 위

            //벽에 부딪힌다?
            if (headx < 0 || heady < 0 || headx >= n || heady >= n) break;

            //사과가 있다?
            if (map[heady][headx] == 1) {
                map[heady][headx] = 0; //사과 먹었으니까 비우고
                snake.addFirst(new int[]{heady, headx}); //머리만 늘리기
            } else { //사과가 없다?
                snake.addFirst(new int[]{heady, headx}); //머리만 늘리기
                snake.pollLast(); //꼬리 줄이기
            }

            //몸에 부딪힌다?
            if (snake.size() > 1) {
                for (int i = 1; i < snake.size(); i++) {
                    int[] body = snake.toArray(new int[0][0])[i]; //몸통을 배열에다 싹 집어넣고
                    if (heady == body[0] && headx == body[1]) { //헤드 위치가 몸통 위치 중 하나라도 같으면
                        break;
                    }
                }
            }

            //방향 전환
            //머리 방향 (오, 아래, 왼, 위) -> (0, 1, 2, 3) 이므로
            // 왼쪽으로 회전시 --, 오른쪽으로 회전시 ++

            if (dir[sec] == 1) { //왼쪽
                head--;
                if (head < 0) head = 3; //오른쪽 방향을 보고 있는 상태에서 --를 하면 위를 보아야 함
            } else if (dir[sec] == 2) { //오른쪽
                head++;
                if (head > 3) head = 0; //왼쪽 방향을 보고 있는 상태에서 ++를 하면 오른쪽을 보아야 함
            }


        }
        bfw.write(sec + "");
        bfw.flush();
    }
}
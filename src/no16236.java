import java.util.*;
import java.io.*;

public class no16236 {
    /**
     * N×N 크기의 공간에 물고기 M마리와 아기 상어 1마리가
     * 가장 처음에 아기 상어의 크기는 2이고, 아기 상어는 1초에 상하좌우로 인접한 한 칸씩 이동
     * 아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없고,
     * 아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다.
     * 크기가 같은 물고기는 먹을 수 없지만, 그 물고기가 있는 칸은 지나갈 수 있다
     * 아기 상어가 어디로 이동할지 결정하는 방법은 아래와 같다.
     * <p>
     * 더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.
     * 먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.
     * 먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
     * 거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값이다.
     * 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면,
     * 가장 왼쪽에 있는 물고기를 먹는다.
     * <p>
     * 아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가한다
     * 공간의 상태가 주어졌을 때, 아기 상어가 몇 초 동안 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는지 구하는 프로그램
     * <p>
     * 접근
     * 이차원배열에 물고기의 위치를 저장
     * 아기상어의 위치를 저장하고 BFS로 물고기 탐색
     * 물고기를 먹으면 물고기의 위치를 0으로 바꾸고 아기상어의 위치를 물고기의 위치로 변경
     * 아기상어의 크기 ++
     * <p>
     * 종료조건 : 먹을 수 있는 물고기가 없을 때
     */
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n;
    static int[][] map;
    static int[] shark;
    static int size;
    static ArrayList<int[]> fishlist;

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bfr.readLine()); // 공간 크기
        map = new int[n][n];
        shark = new int[2];
        size = 2; // 아기 상어의 초기 크기
        fishlist = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bfr.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark[0] = i;
                    shark[1] = j;
                    map[i][j] = 0; // 상어 초기 위치 회수
                }
            }
        }

        int time = 0;
        int eaten = 0; // 먹은 물고기 수

        while (true) {
            fishlist.clear(); // 물고기 리스트 초기화
            int[] result = BFS();

            if (result == null) break; // 먹을 수 있는 물고기가 없으면 종료
            time += result[2]; // 이동 시간 더하기
            eaten++;
            if (eaten == size) { // 아기 상어 크기만큼 물고기를 먹었으면 크기 증가
                size++;
                eaten = 0; // 크기 키웠으니 다시 초기화
            }
            map[result[0]][result[1]] = 0; // 먹은 물고기 0으로 변경
            shark[0] = result[0];
            shark[1] = result[1]; // 아기 상어 위치 업데이트
        }

        bfw.write(time + "");
        bfw.flush();

    }

    private static int[] BFS() {
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{shark[0], shark[1], 0}); // 아기 상어 위치와 이동 시간(0)
        visited[shark[0]][shark[1]] = true;
        int minDist = Integer.MAX_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new FishComparator());
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int y = now[0];
            int x = now[1];
            int dist = now[2]; // 시간

            if (map[y][x] != 0 && map[y][x] < size) { // 상어보다 작은 물고기
                pq.offer(new int[]{y, x, dist});
                minDist = Math.min(minDist, dist); // 최소 거리 갱신
                continue;
            }

            for (int i = 0; i < 4; i++) { // 상하좌우 탐색
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n
                        && !visited[ny][nx] && map[ny][nx] <= size) {
                    visited[ny][nx] = true;
                    dist = dist + 1;
                    q.add(new int[]{ny, nx, dist});
                }
            }
        }
        if (pq.isEmpty()) return null; // 먹을 물고기가 없는 경우
        int[] fish = pq.poll();
        return fish;
    }
}

// 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 
// 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.

class FishComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] o1, int[] o2) {
        if (o1[2] == o2[2]) { // 거리가 같다면
            if (o1[0] == o2[0]) { //
                return Integer.compare(o1[1], o2[1]);  //가장 위에 있는 물고기
            }
            return Integer.compare(o1[0], o2[0]); // 가장 왼쪽에 있는 물고기
        }
        return Integer.compare(o1[2], o2[2]); // 거리순
    }
}


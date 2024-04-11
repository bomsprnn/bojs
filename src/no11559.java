import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class no11559 { //14316	128ms
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] field;
    static List<int[]> group;

    public static void main(String[] args) throws IOException {
        /**
         * 조건
         * 필드에 여러 가지 색깔의 뿌요, 뿌요는 아래로 떨어진다.
         *
         * 같은 색 뿌요가 4개 이상 상하좌우로 연결되어 있으면 연결된 같은 색 뿌요들이 터짐 - 1연쇄
         * 뿌요들이 없어지고 나서 위에 다른 뿌요들이 있다면, 아래로 떨어지
         * 아래로 떨어지고 나서 다시 같은 색의 뿌요들이 4개 이상 모이게 되면 또 터지게 되는데,
         * 터진 후 뿌요들이 내려오고 다시 터짐을 반복할 때마다 1연쇄씩 늘어난다.
         *
         * 터질 수 있는 뿌요가 여러 그룹이 있다면 동시에 터져야 하고
         * 여러 그룹이 터지더라도 한번의 연쇄가 추가된다.
         *
         * 12*6 필드에 뿌요가 존재한다.
         * 이때 .은 빈공간이고 .이 아닌것은 각각의 색깔의 뿌요를 나타낸다.
         * R은 빨강, G는 초록, B는 파랑, P는 보라, Y는 노랑이다.
         * 입력으로 주어지는 필드는 뿌요들이 전부 아래로 떨어진 뒤의 상태.
         *
         * 접근
         * 배열에 때려넣고 dfs
         * 1. 인접한 뿌요들 구해서 리스트 넣고
         * 2. 리스트가 4개 이상이면 터뜨리기
         * 3. 터뜨린 후에는 뿌요들을 아래로 내리기...
         *
         */
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        field = new char[12][6];
        for (int i = 0; i < 12; i++) {
            String str = bfr.readLine();
            for (int j = 0; j < 6; j++) {
                field[i][j] = str.charAt(j);
            }
        } // 뿌요뿌요맵 입력받기
        int answer = 0; // 연쇄 횟수

        while (true) {
            boolean[][] visited = new boolean[12][6];
            int pop = 0; // 한 그룹이 터질때마다 ++
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (field[i][j] == '.') continue;
                    group = new ArrayList<>();
                    dfs(i, j, field[i][j], visited);
                    if (group.size() >= 4) { // 4개 이상이면 터뜨리기
                        for (int k = 0; k < group.size(); k++) {
                            field[group.get(k)[0]][group.get(k)[1]] = '.';
                            // 터뜨리고나서 .로 빈공간 나타내기
                        }
                        pop++;
                    }
                }
            }

            //몇개의 그룹이 터졌는지 확인하는 작업 시작
            if (pop == 0) break; // 터뜨릴게 없는경우
            else { //만약 1그룹 이상 터진 경우 뿌요를 내려야함!
                for (int i = 0; i < 6; i++) {
                    for (int j = 11; j >= 0; j--) { // 맨 아래부터 시작
                        if (field[j][i] == '.') continue;
                        for(int k=11; k>j; k--){
                            if(field[k][i]=='.'){ // 빈공간이면
                                field[k][i] = field[j][i]; // 뿌요 내리기
                                field[j][i] = '.'; // 내린 자리는 다시 빈공간
                                break;
                            }
                        }
                    }
                }
                answer++; // 연쇄 횟수 증가
            }
        }
        bfw.write(answer + "");
        bfw.flush();
    }


    private static void dfs(int i, int j, char c, boolean[][] visited) {
        visited[i][j] = true;
        group.add(new int[]{i, j});

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k]; //사방 좌표 구하기
            if (nx >= 0 && ny >= 0 &&
                    nx < 12 && ny < 6 &&
                    field[nx][ny] == c && !visited[nx][ny])
                dfs(nx, ny, c, visited);
        }
    }
}


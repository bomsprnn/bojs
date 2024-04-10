import java.io.*;

public class no10026 { //16344	156ms
    static int[][] pos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char[][] grid;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        /**
         * 조건
         * N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림
         * 적록색약이 아닌 사람이 봤을 때와 적록색약인 사람이 봤을 때 구역의 수
         *
         * 접근
         * 일단 일반인의 시선에서의 구역 수 구하기
         * 적록색약은 녹색와 빨간색을 같은 구역으로 포함하므로 적->녹으로 변환해버리기
         * 인접한..dfs로 구역 구하기!
         *
         */
        int n = Integer.parseInt(bfr.readLine()); //그리드의 크기
        visited = new boolean[n][n]; //방문 여부
        grid = new char[n][n]; //그리드
        for (int i = 0; i < n; i++) {
            String str = bfr.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = str.charAt(j);
            }
        }//그리드 입력

        int normal = 0; //일반인 구역 수
        int abnormal = 0; //적록색약 구역 수
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    dfs(i,j);
                    normal++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j]=false;
                if(grid[i][j]=='R') grid[i][j]='G';
            }
        }//적록색약을 위한 그리드 변환

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    dfs(i,j);
                    abnormal++;
                }
            }
        }//적록색약 구역 수 구하기
        bfw.write(normal+" "+abnormal);
        bfw.flush();
    }

    private static void dfs(int i, int j) {
        visited[i][j]=true;
        for(int k=0;k<4;k++){ //상하좌우 탐색
            int x = i+pos[k][0];
            int y = j+pos[k][1];
            if(x>=0 && y>=0 && x<grid.length && y<grid.length && !visited[x][y] && grid[x][y]==grid[i][j]){
                dfs(x,y);
            }
        }
    }

}

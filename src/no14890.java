import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class no14890 {
    /**
     * 조건
     * 크기가 N×N인 지도, 지도의 각 칸에는 그 곳의 높이
     * 경사로는 낮은 칸에 놓으며, L개의 연속된 칸에 경사로의 바닥이 모두 접해야 한다.
     * 낮은 칸과 높은 칸의 높이 차이는 1이어야 한다.
     * 경사로를 놓을 낮은 칸의 높이는 모두 같아야 하고, L개의 칸이 연속되어 있어야 한다.
     *
     * 아래와 같은 경우에는 경사로를 놓을 수 없다.
     *
     * 경사로를 놓은 곳에 또 경사로를 놓는 경우
     * 낮은 칸과 높은 칸의 높이 차이가 1이 아닌 경우
     * 낮은 지점의 칸의 높이가 모두 같지 않거나, L개가 연속되지 않은 경우
     * 경사로를 놓다가 범위를 벗어나는 경우
     *
     * 지도가 주어졌을 때, 지나갈 수 있는 길의 개수를 구하
     *
     * 접근
     * 일단 가로세로 한줄 단위로 분리
     * 1 차이 나면 경사로를 놓을 수 있는지 확인
     *
     */
    static int[][] map;
    static int n,l, result;
    static Queue<int[]> q;
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i=0;i<n;i++){
            st=new StringTokenizer(bfr.readLine());
            for (int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            ver(i);
            hor(i);
        }
        bfw.write(result+"");
        bfw.flush();

    }

    private static void ver(int i) {
        q.add(new int[]{i,0});
        boolean[] visited = new boolean[n];
        for(int j=1;j<n;j++){
            if(map[i][j] == map[i][j-1]) q.add(new int[]{i,j});
            else if(map[i][j] == map[i][j-1]+1){
                if(j-l<0) return;
                for(int k=j-1;k>=j-l;k--){
                    if(map[i][k] != map[i][j-1] || visited[k]) return;
                    visited[k] = true;
                }
                q.add(new int[]{i,j});
            }else if(map[i][j] == map[i][j-1]-1){
                if(j+l>n) return;
                for(int k=j;k<j+l;k++){
                    if(map[i][k] != map[i][j] || visited[k]) return;
                    visited[k] = true;
                }
                q.add(new int[]{i,j+l-1});
            }else return;
        }
        result++;
        q.clear();
    }

    private static void hor(int h){
        q.add(new int[]{0,h});
        boolean[] visited = new boolean[n];
        for(int i=1;i<n;i++){
            if(map[i][h] == map[i-1][h]) q.add(new int[]{i,h});
            else if(map[i][h] == map[i-1][h]+1){
                if(i-l<0) return;
                for(int k=i-1;k>=i-l;k--){
                    if(map[k][h] != map[i-1][h] || visited[k]) return;
                    visited[k] = true;
                }
                q.add(new int[]{i,h});
            }else if(map[i][h] == map[i-1][h]-1){
                if(i+l>n) return;
                for(int k=i;k<i+l;k++){
                    if(map[k][h] != map[i][h] || visited[k]) return;
                    visited[k] = true;
                }
                q.add(new int[]{i+l-1,h});
            }else return;
        }
        result++;
        q.clear();

    }
}

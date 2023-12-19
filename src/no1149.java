import java.io.*;
import java.util.StringTokenizer;

public class no1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(bfr.readLine());

        int[][] cost = new int[n][3];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(bfr.readLine());
            cost[i][0]= Integer.parseInt(st.nextToken()); //red
            cost[i][1]= Integer.parseInt(st.nextToken()); //green
            cost[i][2]= Integer.parseInt(st.nextToken()); //blue
        }

        for(int i=1;i<n;i++){
            cost[i][0] += Math.min(cost[i-1][1],cost[i-1][2]);
            cost[i][1] += Math.min(cost[i-1][0],cost[i-1][2]);
            cost[i][2] += Math.min(cost[i-1][0],cost[i-1][1]);
        }

        int result = Math.min(cost[n-1][0], cost[n-1][1]);
        result = Math.min(result, cost[n-1][2]);
        bfw.write(result+" ");
        bfw.flush();

    }
}

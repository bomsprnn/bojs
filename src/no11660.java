import java.io.*;
import java.util.StringTokenizer;

public class no11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][n+1];

        for(int i=1;i<n+1;i++){
            st = new StringTokenizer(bfr.readLine());
            for(int j=1; j<n+1;j++){
                arr[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<m;i++){
           st = new StringTokenizer(bfr.readLine());
           int x1 = Integer.parseInt(st.nextToken());
           int y1 = Integer.parseInt(st.nextToken());
           int x2 = Integer.parseInt(st.nextToken());
           int y2 = Integer.parseInt(st.nextToken());
           for(int j=x1;j<=x2;j++){

           }
        }




        for(int i=1;i<n+1;i++){
            for(int j=1; j<n+1;j++){
                bfw.write(arr[i][j]+" " );
            }
        }


        bfw.flush();






    }
}

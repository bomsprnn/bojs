import java.io.*;

public class no10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bfr.readLine());
        int[][] arr = new int[n+1][10];
        for(int i=0;i<10;i++){
            arr[1][i]=1;
        }

        for(int i=2; i<=n;i++){
            arr[i][0]= arr[i-1][1];
            for (int j=1;j<10;j++){
                if(j == 9)
                    arr[i][j]= arr[i-1][8]%1000000000;
                else arr[i][j] = (arr[i-1][j-1]%1000000000+arr[i-1][j+1]%1000000000)%1000000000;
            }
        }

        long result =0;
        for(int i=1;i<10;i++){
            result= (result + arr[n][i])%1000000000;

        }
        bfw.write(result+"");
        bfw.flush();

    }
}
import java.io.*;

public class no2445 {
    /**
     * 첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력한다.
     * 5
     * *        *   //1  //10-1*2
     * **      **   //2  //10-2*2
     * ***    ***   //3  //10-3*2
     * ****  ****
     * **********
     * ****  ****
     * ***    ***
     * **      **
     * *        *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bfr.readLine());

        for(int i=1;i<n+1;i++){
            for(int j=0;j<i;j++){
                bfw.write("*");
            }
            for(int j=0;j<2*n-2*i;j++){
                bfw.write(" ");
            }
            for(int j=0;j<i;j++){
                bfw.write("*");
            }
            bfw.write("\n");
        }

        for(int i=n-1;i>0;i--){
            for(int j=0;j<i;j++){
                bfw.write("*");
            }
            for(int j=0;j<2*n-2*i;j++){
                bfw.write(" ");
            }
            for(int j=0;j<i;j++){
                bfw.write("*");
            }
            bfw.write("\n");
        }
        bfw.flush();


    }
}//14360	148



import java.io.*;

public class no1904 {
    static int[] arr ;
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bfr.readLine());
        arr = new int[n];
        bfr.close();
        int k = casenum(n);
        bfw.write(k+" ");
        bfw.flush();
        bfw.close();

    }

    static int casenum(int n){
        arr[0]=1; arr[1]=2;
        if(n>1) {
            for(int i=2;i<n;i++){
                arr[i]=(arr[i-1]+arr[i-2])%15746;
            }
        }
        return (arr[n-1]);
    }
}

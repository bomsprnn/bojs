import java.io.*;
import java.util.StringTokenizer;

public class no1735 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int[][] arr = new int[2][2];

        for (int i=0; i<2;i++){
            st = new StringTokenizer(bfr.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int parent = arr[0][1]*arr[1][1];
        int child = arr[1][1]*arr[0][0]+arr[0][1]*arr[1][0];

        //ma x common factor (parent, child)
        int cf= euc(parent,child);
        parent=parent/cf;
        child=child/cf;

        bfr.close();
        bfw.write(child+" "+parent);
        bfw.flush();
        bfw.close();
    }

    private static int euc(int a, int b){
        if (b > a) {
            int c = a;
            a = b;
            b = c;
        }
        while(b!=0){
            int c = a%b;
            a=b; b=c;
        }
        return a;
    }
}

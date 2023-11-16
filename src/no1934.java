import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class no1934 {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(bfr.readLine()); //count of test
        int[] result = new int[t];

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(bfr.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (b < a) {
                int c = a;
                a = b;
                b = c;
            }

            //최대공약수 구하기
            // 두 수를 곱해서 최소공배수로 나누기

            //int k = b;  //Euclidean algorithm
            int ca = euc(a,b);
            result[i]= a*b/ca;
        }
        bfr.close();
        for(int i = 0; i<t ; i++){
            bfw.write(result[i]+"\n");
        }
        bfw.flush();
        bfw.close();
    }

    private static int euc(int a, int b){
        while (b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}

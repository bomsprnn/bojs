import java.io.*;

public class no4134 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bfr.readLine()); //count of test case
        Long[] arr = new Long[n];

        for (int i =0; i<n ; i++){
            arr[i]= Long.parseLong(bfr.readLine());
            while(!primetest(arr[i])){
                arr[i]++;
            }
        }
        bfr.close();
        for (int i =0;i<n;i++)
            bfw.write(arr[i]+"\n");
        bfw.flush();
        bfw.close();
    }

    private static boolean primetest(long a){
        for(long i=2; i*i<=a;i++){ //i*i 로 표현되면 무조건 소수가 아니기 때문에 절반만 순회하도록 최적화 가능하다.
            if(a%i==0)
                return false;
        }
        return true;
    }

}

import java.io.*;

public class no24416 {
    static int fib1=1;
    static int fib2=0;
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bfr.readLine());
        fib1(n);
        fib2(n);
        bfw.write(fib1+" "+fib2);
        bfw.flush();
    }

    static Long fib1(int n){
        if(n==1 || n==2) return 1L;
        else {
            fib1++;
            return (fib1(n-1)+fib1(n-2));
        }
    }

    static int fib2(int n){
        int[] arr = new int[n];
        arr[0]=1; arr[1]=1;
        for(int i=2 ; i<n; i++){
            fib2++;
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n-1];
    }

}

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class no13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bfr.readLine());
        BigInteger[] dis = new BigInteger[n-1];
        BigInteger[] fee = new BigInteger[n];

        StringTokenizer st= new StringTokenizer(bfr.readLine());
        for(int i=0;i<n-1;i++){
            dis[i]= BigInteger.valueOf(Integer.parseInt(st.nextToken()));
        }

        StringTokenizer st2= new StringTokenizer(bfr.readLine());
        for(int i=0;i<n;i++){
            fee[i]= BigInteger.valueOf(Integer.parseInt(st2.nextToken()));
        }

        BigInteger min= fee[0];
        BigInteger sum = dis[0].multiply(min);

        for(int i=1;i<n-1;i++){
            if(fee[i].compareTo(min)<0){
                min = fee[i];
            }
            sum = sum.add(dis[i].multiply(min));
        }

        bfw.write(sum+" ");
        bfw.flush();

        bfr.close();
        bfw.close();


    }
}

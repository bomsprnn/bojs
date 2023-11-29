import java.io.*;
import java.util.StringTokenizer;

public class no15649 {
    public static boolean[] check;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st= new StringTokenizer(bfr.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        check = new boolean[n]; //방문했는지 확인하는 용도
        arr = new int[m]; //depth 를 체크하는 용도

        dfs(n,m,0);
    }

    private static void dfs(int n, int m, int depth){

        if(depth==m){
            BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int i =0; i<arr.length;i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0;i<n;i++){
            if(check[i]==false){
                check[i]=true;

                arr[depth]=i+1;
                dfs(n,m,depth+1);

                check[i]=false;
            }
        }

    }
}

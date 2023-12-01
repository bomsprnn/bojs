import java.io.*;
import java.util.StringTokenizer;

public class no15652 {
    public static int n, m;
    public static boolean[] check;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        check = new boolean[n]; //방문했는지 확인하는 용도
        arr = new int[m]; //depth 를 체크하는 용도

        dfs(0,0);


    }
    private static void dfs(int k, int depth){
        if(depth==m){ // 끝까지 탐색했다면
            BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int i =0; i<arr.length;i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=k;i<n;i++){
            arr[depth]=i+1; //출력할 배열인 arr에 i+1 추가
            dfs(i,depth+1); //depth를 +1하여 다음 탐색. arr[0]~arr[m-1]
            }
        }

    }
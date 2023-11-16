import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class no18870 {
    public static void main(String[] args) throws IOException {

        BufferedReader bfr= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
            StringTokenizer st;

        int n = Integer.parseInt(bfr.readLine()); // count of input
        int[] arr = new int[n];


        st = new StringTokenizer((bfr.readLine()));
        for (int i = 0; i<n ; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }
        int[] arr2 = arr.clone(); //make arrays
        Arrays.sort(arr); //sort array
        int indx =0;
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i<n ; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],indx++);
            }
        }

        for(int i = 0; i<n;i++){
            arr2[i]= map.get(arr2[i]);
        }

        bfr.close();
        for(int i = 0; i<n ; i++){
            bfw.write(arr2[i]+" ");
        }

        bfw.flush();
        bfw.close();
    }
}
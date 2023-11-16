import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
public class no10815 {
    static int[] arr;
    static int[] arr2;
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int n = Integer.parseInt(bfr.readLine());
        arr = new int[n]; //own cards
        st = new StringTokenizer(bfr.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); //sort arr2 to compare w.binarySearch

        int m = Integer.parseInt(bfr.readLine());
        int[] arr2 = new int[m]; //cards to compare
        st = new StringTokenizer(bfr.readLine());
        for (int i = 0; i < m; i++) {
            int result = BinarySearch(Integer.parseInt(st.nextToken()));
            if (result ==-1)
                bfw.write(0+" ");
            else
                bfw.write(1+" ");
        }
        bfr.close();

        bfw.flush();
        bfw.close();
    }

    private static int BinarySearch(int target){
        int left=0;
        int right = arr.length -1;
        int mid;

        while (left <= right) {
            mid =(left+right)/2;
            if (arr[mid]<target)
                left = mid +1;
            else if(arr[mid]>target)
                right=mid-1;
            else return mid;
        }
        return -1; //if not find
    }
}

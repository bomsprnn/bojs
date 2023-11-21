import java.util.ArrayDeque;
import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class no2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bfr.readLine()); //count of balloons

        Deque<int[]> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(bfr.readLine()); //value of each balloons

        for(int i =0; i<n ;i++){
            int[] arr = {i+1, Integer.parseInt(st.nextToken())};
            deque.add(arr);
        } //store

        int[] a = deque.pollFirst();
        bfw.write(1 +" ");

        while(!deque.isEmpty()){
            if(a[1]>0){
                for(int i =1;i<a[1];i++){
                    deque.addLast(deque.pollFirst());
                }
                a = deque.pollFirst();
                bfw.write(a[0]+" ");
            }
            else if (a[1]<0){
                for(int i=1;i<Math.abs(a[1]);i++){
                    deque.addFirst(deque.pollLast());
                }
                a= deque.pollLast();
                bfw.write(a[0]+" ");
            }
            else {
                a= deque.pollFirst();
                bfw.write(a[0]+" ");
            }
        }
        bfr.close();
        bfw.flush();
        bfw.close();

    }
}
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bfr.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for(int i =1; i<=n ; i++) {
            queue.offer(i);
        }

        while(queue.size()>1){
            queue.poll();
            if(queue.size()==1) break;
            queue.offer(queue.poll());
        }

        bfw.write(queue.poll()+"");

        bfr.close();
        bfw.flush();
        bfw.close();
    }
}

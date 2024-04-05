import java.io.*;
import java.util.PriorityQueue;

public class no1715 { //25756	376ms
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bfr.readLine());


        /**
         * 어차피 더하기를 시행하는 횟수는 모두 같다.
         * 가장 작은 수를 먼저 처리하는것이 가장 효율적인듯
         * -> n의 상한선이 배열로 처리하기에는 너무 크기 때문에 tree로 처리
         */

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            queue.offer(Integer.parseInt(bfr.readLine()));
        }
        int sum = 0;
        while(queue.size()>1){
            int a = queue.poll(); //가장 작은 수
            int b = queue.poll(); //두번째로 작은 수
            sum += a+b;
            queue.offer(a+b); // 다시 큐에 넣기
        }
        bfw.write(sum+"");
        bfw.flush();

    }
}

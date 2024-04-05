import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class no2075 {//276544	896ms

    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bfr.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1); // maxtree로 만들기
        for(int i=0;i<n;i++){ //그냥 이진 트리에 싹.다 때려 넣고 위에서부터 뽑기
            StringTokenizer st = new StringTokenizer(bfr.readLine());
            for(int j=0;j<n;j++){
                queue.offer(Integer.parseInt(st.nextToken()));  //add는 큐 꽉 차면 에러, offer은 꽉차면 false
            }
        }
        for(int i=0;i<n-1;i++){ //n번째 큰 수가 트리의 최상단에 오도록 n-1번 뽑기
            queue.poll();
        }
        bfw.write(queue.poll()+"");
        bfw.flush();

    }
}
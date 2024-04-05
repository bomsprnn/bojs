import java.io.*;
import java.util.PriorityQueue;

public class no11286 {//26156	356ms
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bfr.readLine()); //테스트 케이스
        /**
         * 절댓값 힙은 다음과 같은 연산을 지원하는 자료구조이다.
         *
         * 배열에 정수 x (x ≠ 0)를 넣는다.
         * 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
         * 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
         */

        PriorityQueue<Integer> queue = new PriorityQueue<>( //조건에 맞는 우선순위 큐 만들기
                ((o1, o2) -> {
                    if(Math.abs(o1) == Math.abs(o2)) return o1-o2; //절댓값이 같으면 작은 수 출력
                    return Math.abs(o1)-Math.abs(o2); //절댓값이 다르면 작은 절댓값 출력
                })
        );

        for(int i=0;i<n;i++){
            int x = Integer.parseInt(bfr.readLine());
            if(x==0) {
                if (queue.isEmpty()) bfw.write("0\n"); //비어있는데 가장 작은 값을 출력하라고 하는 경우
                else bfw.write(queue.poll() + "\n"); //가장 작은 값을 출력하고 제거
            }else{
                queue.offer(x); //0이 아닌 경우 큐에 삽입
            }
        }
        bfw.flush();
    }
}

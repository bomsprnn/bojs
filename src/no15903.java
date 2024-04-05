import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class no15903 {//15300	176ms
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int n = Integer.parseInt(st.nextToken()); //카드의 개수
        int m = Integer.parseInt(st.nextToken()); //카드 합체 횟수

        /**
         * 가장 작은 수를 만들어야 하기 때문에
         * 합체하는 카드 두 개도 가장 작은 애들만 골라야함..
         * 1. 배열에서 정렬하기 --> 시간복잡도가 에바임!!!!!!
         * 2. min 트리에서 뽑기
         */

        st = new StringTokenizer(bfr.readLine());
        PriorityQueue<Long> queue = new PriorityQueue<>(); //우선순위 큐 만들기 (디폴트가 min tree)
        for (int i = 0; i < n; i++) {
            queue.offer(Long.parseLong(st.nextToken())); //카드 입력
        }

        for (int i = 0; i < m; i++) {
            long a = queue.poll(); //가장 작은 카드
            // 1 ≤ ai ≤ 1,000,000 이고 m(0 ≤ m ≤ 15×n)이라서 int 사용시 오버플로우 발생 위험
            long b = queue.poll(); //두번째로 작은 카드
            queue.offer(a + b); //두 카드 합쳐서 다시 넣기
            queue.offer(a + b);
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += queue.poll(); //카드 다시 뽑아서 합치기
        }
        bfw.write(sum + "");
        bfw.flush();

    }
}

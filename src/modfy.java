import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class modfy {
    public static void main(String[] args) throws IOException {
        // x,y번 카드들 골라 그 도장에 쓰여진 수를 더한 값 계산
        // 계산한 값을 x,y번 카드 두장 모두에 덮어씀
        // 이 점수를 가장 작게 만드는 것이 놀이의 목표
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> cards = new PriorityQueue<>(); // 우선순위 큐
        long temp = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());; // 카드 개수
        int m = Integer.parseInt(st.nextToken()); // 카드 합체 횟수


        st = new StringTokenizer(br.readLine()); // n개의 카드 번호 입력 받음
        while (st.hasMoreTokens()) {
            cards.offer(Long.valueOf((st.nextToken())));  // 큐에 데이터 삽입
        }

//        while(m-- > 0) {
//            st = new StringTokenizer(br.readLine()); // n개의 카드 번호 입력 받음
//            while(n-- > 0) {
//                cards.offer(Integer.parseInt(st.nextToken()));  // 큐에 데이터 삽입
//            }
//        }


        // 합체 횟수
        for(int i=0; i<m; i++) {
            temp = cards.remove() + cards.remove();
            cards.offer(temp);
            cards.offer(temp);
        }
        long sum = 0; // 총 합계

        // 우선순위 큐가 비어있지 않을 때까지 요소를 더합니다.
        while (!cards.isEmpty()) {
            sum += cards.poll(); // 우선순위 큐에서 요소를 꺼내어 더함
        }
        System.out.println(sum);

    }
}
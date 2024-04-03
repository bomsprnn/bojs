import java.util.ArrayDeque;
import java.io.*;
import java.util.Deque;
import java.util.StringTokenizer;

public class no2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 풍선 갯수
        Deque<Balloon> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            deque.add(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        // deque을 이용해서 순서를 바꿈
        Balloon poll = deque.pollFirst(); ///여기서 하나 뽑고 시작하기 때문에 n-1개 풍선이 남음
        for (int j =0; j<N; j++) { ///지연님이 쓰신대로 n번 반복하면 마지막 풍선 x
            int next = poll.next;
            sb.append(poll.seq+" ");

            if(deque.size()<=1){
                sb.append(deque.pollFirst().seq);
                break;
            } ///그래서 큐에 하나 남았을 때 마지막 출력하고 break;

            if (next > 0) {
                for (int i = 1; i < next; i++) {
                    deque.offerLast(deque.pollFirst());
                }
                poll = deque.pollFirst();
            } else {
                for (int i = 1; i < Math.abs(next); i++) {
                    deque.offerFirst(deque.pollLast());
                }
                poll = deque.pollLast();
            }
        }


        //sb.deleteCharAt(sb.length()-1);
        System.out.print(sb);
        br.close();
    }

    static class Balloon {
        int seq, next;

        public Balloon(int seq, int next) {
            this.seq = seq;
            this.next = next;
        }
    }
}
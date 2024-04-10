import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class no13975 {
    public static void main(String[] args) throws IOException {
        /**
         *두 개의 파일을 합쳐서 하나의 임시파일을 만들고,
         * 이 임시파일이나 원래의 파일을 계속 두 개씩 합쳐서 파일을 합쳐나가고,
         * 최종적으로는 하나의 파일로 합친다
         *두 개의 파일을 합칠 때 필요한 비용(시간 등)이 두 파일 크기의 합이라고 가정할 때,
         * 최종적인 한 개의 파일을 완성하는데 필요한 비용의 총 합을 계산
         *
         * T개의 테스트 데이터, m입력의 맨 첫 줄에 주어진다.
         * 각 테스트 데이터는 두 개의 행으로 주어지는데,
         * 첫 행에는 소설을 구성하는 장의 수를 나타내는 양의 정수 K (3 ≤ K ≤ 1,000,000)가 주어진다.
         * 두 번째 행에는 1장부터 K장까지 수록한 파일의 크기를 나타내는 양의 정수 K개
         *
         * pq에 때려박고 출력 ㄱㄱ
         *
         */
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(bfr.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bfr.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(bfr.readLine());
            for (int j = 0; j < n; j++) {
                pq.add(Long.parseLong(st.nextToken()));
            }
            long sum = 0;
            while (pq.size() > 1) {
                long a = pq.poll();
                long b = pq.poll();
                pq.add(a + b);
                sum += (a + b);
            }
            bfw.write(sum + "\n");

        }
        bfw.flush();

    }
}

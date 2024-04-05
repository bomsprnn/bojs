import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class no7662 {//449568	2828ms
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bfr.readLine());
        for (int i = 0; i < t; i++) { //테스트 케이스만큼 반복
            int k = Integer.parseInt(bfr.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            // priority queue를 이용하여 최댓값과 최솟값 힙을 두 개 만들어 진행하였으나 시간초과 ...
            // tree map을 이용하여 간소화

            for (int j = 0; j < k; j++) { //연산 개수만큼 반복
                StringTokenizer st = new StringTokenizer(bfr.readLine());
                String cal = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if (cal.equals("I")) { //삽입
                    if (map.containsKey(num)) map.put(num, map.get(num) + 1);
                    else map.put(num, 1); //만약 맵에 있는 수라면 기존값 +1, 없으면 1로 초기화하여 삽입
                } else if (cal.equals("D")) { //삭제
                    if (map.isEmpty()) continue; //맵이 비어있다면 다음 연산으로 넘어감
                    else {
                        if (num == 1) { //최댓값 삭제
                            int m = map.lastKey(); //맵의 마지막 키값을 가져옴( 가장 큰 값)
                            if (map.get(m) == 1) map.remove(m); // 최대값이 하나라면 제거
                            else map.put(m, map.get(m) - 1); // 아니라면 기존값 -1
                        } else {
                            int m = map.firstKey(); //맵의 첫번째 키값을 가져옴(가장 작은 값)
                            if (map.get(m) == 1) map.remove(m); // 최소값이 하나라면 제거
                            else map.put(m, map.get(m) - 1); // 아니라면 기존값 -1
                        }
                    }
                }

            }
            if (map.isEmpty()) bfw.write("EMPTY\n");
            else bfw.write(map.lastKey() + " " + map.firstKey() + "\n");

        }
        bfw.flush();
    }
}

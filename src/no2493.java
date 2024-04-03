import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class no2493 { //94108	848
    public static void main(String[] args) throws IOException {
        /**
         * 일직선상에 놓여있는 높이가 다른 건물
         * 건물에서 왼쪽으로 레이저 발사!!!!!!!!!!!!!1
         * 가장 먼저 닿는 (현 건물보다 높거나 같은 건물)의 번호 출력
         */

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bfr.readLine()); //탑의 개수
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        /*
         * 가장 가까운 건물만 알면 됨 .. 더 왼쪽에 있는 친구들은 무시 ooo
         * 스택에 저장, 더이상 쓰임이 없으면 pop 해버리기
         * 쓸모 없는 건물 선별 : 가장 왼쪽 건물이 다음 건물보다 낮으면 pop
         *
         */

        Stack<building> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            building building = new building(i + 1, Integer.parseInt(st.nextToken()));
            while (!stack.isEmpty()) {
                if (stack.peek().height < building.height) {
                    // 맨 위의 탑이 현재보다 낮다면 버리기
                    stack.pop();
                }else {
                    bfw.write(stack.peek().posx + " ");
                    break;
                }
            }
            if(stack.isEmpty()) bfw.write( "0 "); //레이저가 닿을 건물이 없으면 0 출력
            stack.push(building); //현재 건물 추가

        }
        bfw.flush();

    }

    static class building {
        int height;
        int posx; //x좌표상 위치

        public building(int posx, int height) {
            this.height = height;
            this.posx = posx;
        }
    }
}

import java.io.*;

public class no2447 {
    static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bfr.readLine());
        for(int i=0; i<n; i++){ // 정사각형 탐색
            for(int j=0; j<n; j++){
                star(i,j,n);
            }
            bfw.write("\n");
        }
        bfw.flush();
        bfw.close();
    }



    public static void star(int i, int j, int n) throws IOException {

        if ((i / n) % 3 == 1 && (j / n) % 3 == 1) { // 조건에 맞으면 빈칸
            bfw.write(" ");
        } else { // 빈칸이 아니라면
            if (n == 1) bfw.write("*"); // 3으로 더이상 나눠지지 않는 1이 되었을 때 * 출력
            else star(i, j, n / 3); // 정사각형 사이즈를 3으로 나눠가면서 검사
        }

    }
}
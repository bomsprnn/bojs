import java.io.*;

public class no1193 {
    /**
 *     2      #3  4    #5  6
     1/1	1/2	1/3	1/4	1/5	…
     2/1	2/2	2/3	2/4	…	…   #은 분모감소 분자증가
     3/1	3/2	3/3	…	…	…    각 대각선 열의 개수 -> 1씩 증가
     4/1	4/2	…	…	…	…
     5/1	…	…	…	…	…
     …	…	…	…	…	…

     */
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(bfr.readLine());

        int line =0;
        int result =0;
        int i=1;
        while(true){
            if(x <= i* (i+1)/2){
                line = i; // 몇번째 대각라인에 속했는지
                result = x-(i-1)*i/2;
                break;
            }
            i++;
        }
        if(line % 2 == 0){
            bfw.write(result+"/"+(line-result+1));
        } else bfw.write((line-result + 1)+"/"+result);
        bfw.flush();
    }
}

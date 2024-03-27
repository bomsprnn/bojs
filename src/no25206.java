import java.io.*;
import java.util.StringTokenizer;

public class no25206 {
    public static void main(String[] args) throws IOException {
        /**
         * 전공평점은 전공과목별 (학점 × 과목평점)의 합을 학점의 총합으로 나눈 값
         *
         * 인하대학교 컴퓨터공학과의 등급에 따른 과목평점
         * A+	4.5
         * A0	4.0
         * B+	3.5
         * B0	3.0
         * C+	2.5
         * C0	2.0
         * D+	1.5
         * D0	1.0
         * F	0.0
         *
         * 20줄에 걸쳐 치훈이가 수강한 전공과목의 과목명, 학점, 등급이 공백으로 구분되어 주어진다.
         * 치훈이의 전공평점을 출력한다.
         *
         * 정답과의 절대오차 또는 상대오차가 \(10^{-4}\) 이하
         */

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        double credsum =0; //크레딧 합
        double sumgrade=0; //평점 합
        for(int i=0;i<20;i++){
            StringTokenizer st = new StringTokenizer(bfr.readLine());
            String title = st.nextToken(); //제목
            double credit = Double.parseDouble(st.nextToken()); //학점
            String grade = st.nextToken(); //평점
            credsum+=credit; //이수학점 증가
            switch(grade){
                case "A+":
                    sumgrade +=  credit * 4.5;
                    break;
                case "A0":
                    sumgrade +=  credit * 4.0;
                    break;
                case "B+":
                    sumgrade += credit * 3.5;
                    break;
                case "B0":
                    sumgrade += credit *3.0;
                    break;
                case "C+":
                    sumgrade += credit * 2.5;
                    break;
                case "C0":
                    sumgrade += credit * 2.0;
                    break;
                case "D+":
                    sumgrade += credit * 1.5;
                    break;
                case "D0":
                    sumgrade += credit * 1.0;
                    break;
                case "F":
                    sumgrade += credit * 0;
                    break;
                case "P":
                    credsum-=credit;
                    break;
            }
        }

        bfw.write(sumgrade/credsum+" ");
        bfw.flush();


    }
}

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        /**
         * 직선상에 위치하는 n개의 집 (모두 도현이의 것이구나 부럽다)
         * 공유기 c개 설치, 한 집에 하나 제한
         * 가장 인접한 두 공유기 사이의 거리를 최대로 하여
         * 최대 거리 출력!
         */

        /**
         * 접근
         * 인접한 집에 ㅈ공유기를 설치하면 안된다는 조건 같은게 없어서
         * 그냥 소트 때리고 이분탐색
         */
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] house = new int[n];
        for(int i=0;i<n;i++){
            house[i]= Integer.parseInt(bfr.readLine());
        }
        int start = 0;
        int end = house[n-1]-house[0];
        int result = 0;
        Arrays.sort(house); //
        while(start<=end){
            int mid = (start+end)/2; //최대 간격
            int cnt = 1;
            int value = house[0];
            for(int i=1;i<n;i++){ //집 순회하며
                if(house[i]-value>=mid){ //거리가 mid보다 크면
                    cnt++; //공유기 설치 수 증가
                    value = house[i]; //설치된 집의 위치 갱신
                }
            }
            if(cnt>=c){ //설치된 공유기 수가 c보다 크거나 같으면
                result = mid; //결과값 갱신
                start = mid+1; //mid보다 큰 구간 탐색
            }else{
                end = mid-1;
            }
        }
        bfw.write(result+"");
        bfw.flush();



    }
}

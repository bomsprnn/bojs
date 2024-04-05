import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class no18870 {
    public static void main(String[] args) throws IOException {
        /**
         * 1. 배열 2개에 값을 넣고 하나에만 정렬, 해쉬맵에 넣어서 키값으로 찾기
         * 2. 객체 배열에 값과 인덱스 넣고 값 기준으로 정렬
         *
         * 원 배열이 정렬 상태라면 압축한 값 역시 정렬 상태가 되어야 한다.
         * -> 자신보다 작은 값이 몇 개인지 찾는 문제이므로!!
         */

        BufferedReader bfr= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
            StringTokenizer st;

        int n = Integer.parseInt(bfr.readLine());
        Obj[] arr = new Obj[n];


        st = new StringTokenizer((bfr.readLine()));
        for (int i = 0; i<n ; i++){
            arr[i]= new Obj(Integer.parseInt(st.nextToken()),i);
        } //객체 배열에 값과 인덱스 넣기
        Arrays.sort(arr,Comparator.comparingInt(o->o.value)); //값 기준으로 정렬

        int[] arr2 = new int[n]; //정답 배열

        int cnt = 0;
        int prev = arr[0].value;
        for(int i = 0; i<n ; i++){ //객체 배열 순회
            if(prev != arr[i].value){ //만약 이전 값과 같지 않다면 (Xi > Xj를 만족해야하므로 같은 수는 중복 필터링)
                cnt++; //개수 증가
            }
            arr2[arr[i].index] = cnt; //정답 배열에 인덱스에 맞게 넣기
            prev = arr[i].value; //이전 값 갱신
        }


        for(int i = 0; i<n ; i++){
            bfw.write(arr2[i]+" ");
        }

        bfw.flush();
    }

    private static class Obj{
        int value; //값
        int index;  //순서
        public Obj(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
}
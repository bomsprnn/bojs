import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class no20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st= new StringTokenizer(bfr.readLine());
        int n = Integer.parseInt(st.nextToken()); // count of input
        int m = Integer.parseInt(st.nextToken()); // length of word

        HashMap<String,Integer> arr = new HashMap<>();

        for(int i =0;i<n;i++) {
            String word = bfr.readLine();
            if (word.length() >= m && arr.containsKey(word)) {
                int count = arr.getOrDefault(word, 0);
                arr.put(word, count + 1);
            } else if (word.length() >= m && !arr.containsKey(word)) {
                arr.put(word, 1);
            }
        }
        bfr.close();
        List<String> list = arr.keySet().stream().collect(Collectors.toList());
        list.sort((o1, o2) -> {
            int c1 = arr.get(o1);
            int c2 = arr.get(o2); //빈도수 get
            if(c1==c2){ //빈도수가 같으면
                if(o1.length() == o2.length()){ //길이가 같으면
                    return o1.compareTo(o2);
                }
                return o2.length()-o1.length();
            }
            return c2-c1;
        });
        for (int i=0;i<arr.size();i++){
            bfw.write(list.get(i)+"\n");
        }



        bfw.flush();
        bfw.close();


    }
}

package ch6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최솟값을만드는괄호배치찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        String[] list = s.split("-");
        int result = 0;
        String[] split1 = list[0].split("[+]");
        int first = 0;
        for (String s1 : split1) {
            first += Integer.parseInt(s1);
        }
        result = first;
        for(int i = 1; i<list.length; i++){
            String[] split = list[i].split("[+]");
            int smallResult = 0;
            for (int j =0; j<split.length; j++){
                int i1 = Integer.parseInt(split[j]);
                smallResult += i1;
            }
            result -= smallResult;
        }

        System.out.println(result);
    }
}

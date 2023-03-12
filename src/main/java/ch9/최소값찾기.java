package ch9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 최소값찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numberOfNode = Integer.parseInt(st.nextToken());
        int numberOfQuestion = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for(int i =0; i<numberOfNode; i++){
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            list.add(number);
        }



    }
}

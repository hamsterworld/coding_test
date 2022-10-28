package ch3.PrefixSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class 구간합구하기 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        long[] sumList = new long[N+1];
        //5 4 3 2 1
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<N+1; i++){
            int k = Integer.parseInt(st.nextToken());
            sumList[i] = k + sumList[i-1];
        }

        for(int i = 0; i<S; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(sumList[b]-sumList[a-1]);
        }



    }

}

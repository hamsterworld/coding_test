package ch3.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주몽의명령 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] list = new int[N];

        for(int i = 0;i<N;i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);
        int count = 0;
        int i=0;
        int j=N-1;


        while( i < j ){
            if( (list[i]+list[j]) < M ){
                i++;
            } else if((list[i]+list[j]) > M ){
                j--;
            } else if((list[i]+list[j]) == M){
                j--;
                count++;
            }
        }

        System.out.println(count);

    }
}

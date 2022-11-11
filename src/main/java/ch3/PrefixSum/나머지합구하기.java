package ch3.PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나머지합구하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] sumlist = new long[N+1];
        long[] C = new long[M];
        long result = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<N+1;i++){
            sumlist[i] = Integer.parseInt(st.nextToken()) + sumlist[i-1];
            sumlist[i] = (sumlist[i]%M);
            int r = (int)sumlist[i];
            if(sumlist[i] == 0){
                result++;
            }
            C[r]++;
        }
        for(int i =0;i<M; i++){
            if(C[i]>1){
                result = result + ((C[i]*(C[i]-1))/2);
            }
        }
        System.out.println(result);
    }

}

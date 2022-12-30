package ch7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나머지합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long start = Long.parseLong(st.nextToken());
        long end = Long.parseLong(st.nextToken());
        long[] list = new long[1_0_000_001];
        for(int i = 2; i<1_0_000_001;i++){
            if(i == ((int)Math.sqrt(list.length)*(int)Math.sqrt(list.length))){
                list[i] = 0;
                continue;
            }
            list[i] = i;
        }

        for(int i =0;i<Math.sqrt(list.length); i++){
            if(list[i] == 0){
                continue;
            }
            for(int j = i+i; j<1_0_000_001; j+=i){
                list[j] = 0;
            }
        }

        int count = 0;
        for(int i =2; i<1_0_000_001;i++){
            if(list[i] != 0){
                long temp = list[i];
                while((double)list[i]<= (double)end/(double)temp){
                    if((double)list[i] >= (double)start/(double)temp){
                        count++;

                    }
                    temp = list[i] * temp;
                }
            }
        }
        System.out.println(count);

    }
}

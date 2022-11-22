package ch4.insertionsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ATM인출시간계산하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        int[] list = new int[P];
        int[] sumlist = new int[P+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i =0; i<P; i++){
            list[i] = Integer.parseInt(st.nextToken());
            sumlist[i+1] = list[i] + sumlist[i];
        }

        for(int i=0; i<P-1; i++){
            for(int j = i; j>=0; j--){
                if(list[j]>list[j+1]){
                    int k = list[j+1];
                    list[j+1] = list[j];
                    list[j] = k;
                }
            }
        }

        for(int i =0; i<P; i++){
            sumlist[i+1] = list[i] + sumlist[i];
        }

        int result = 0;
        for (int i =1; i<P+1; i++){
            result += sumlist[i];
        }

        System.out.println(result);


    }

}

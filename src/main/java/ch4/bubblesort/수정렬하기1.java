package ch4.bubblesort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기1 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        int[] list = new int[P];

        for(int i = 0; i<P; i++){
            list[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i<P; i++){
            int r = 0;
            for(int j = 1; j<P-i;j++){

                int k = 0;

                if(list[r] <= list[j]){

                } else if( list[r] > list[j]){
                    k = list[j];
                    list[j] = list[r];
                    list[r] = k;
                }
                r++;
            }

        }

        for(int i = 0; i<P; i++){
            System.out.println(list[i]);
        }

    }

}

package ch4.selectionsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 내림차순으로수정렬하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] list = new int[s.length()];

        boolean swapstate = false;

        for(int i =0; i<list.length; i++){
            int k = list[i];
            int t = 0;
            for(int j = i; j<list.length-1; j++){
                if(k < list[j+1]) {
                    k = list[j+1];
                    t = j+1;
                    swapstate = true;
                }
            }
            if(swapstate){
                int r = list[i];
                list[i] = k;
                list[t] = r;
            }
            swapstate = false;
        }

        for (int i =0; i<list.length; i++){
            System.out.print(list[i]);
        }
    }

}

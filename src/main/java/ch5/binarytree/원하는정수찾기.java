package ch5.binarytree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 원하는정수찾기 {

    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        list = new int[N];
        for (int i =0;i<N;i++){
            int i1 = Integer.parseInt(st.nextToken());
            list[i] = i1;
        }
        Arrays.sort(list);

        st= new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        st= new StringTokenizer(br.readLine());
        for(int  i =0; i<M; i++){
            int result = 0;
            int T = Integer.parseInt(st.nextToken());
            int startIndex = 0;
            int endIndex = list.length-1;
            while(startIndex <= endIndex){
                int middleIndex = (startIndex + endIndex)/2;
                int middleValue = list[middleIndex];
                if( T > middleValue ){
                    startIndex = middleIndex + 1;
                } else if(T < middleValue){
                    endIndex = middleIndex - 1;
                } else {
                    result = 1;
                    break;
                }
            }
            System.out.println(result);
        }
    }


}

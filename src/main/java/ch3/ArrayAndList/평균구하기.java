package ch3.ArrayAndList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class 평균구하기 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Max = 0;
        int sum = 0;
        for(int i =0; i <N; i++){
            int s = Integer.parseInt(st.nextToken());
            if( s > Max){
                Max = s;
            }
            sum += s;
        }

        System.out.println(sum/(float)Max*100/N);
        // A B C에서 최고점수 ((A / A * 100) + (B / A * 100) + (C / A * 100))/3 = (A+B+C) / A * 100 / 3




    }


}

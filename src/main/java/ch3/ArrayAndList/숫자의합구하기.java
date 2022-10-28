package ch3.ArrayAndList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class 숫자의합구하기 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] charArray = (br.readLine()).toCharArray();
        int sum = 0;
        // char[]로 변경한다.
        // 10987654321
        for(int i = 0; i<N; i++){
            sum += (charArray[i]-'0');
        }
        System.out.println(sum);
    }

}

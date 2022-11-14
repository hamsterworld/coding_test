package ch3.twopointer;


import java.io.IOException;
import java.util.Scanner;

public class 연속된자연수의합구하기 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        int count = 1;
        int start_index = 1;
        int end_index = 1;
        int sum = 1;

        while(i != end_index){
            if( i == sum){
                count ++;
                end_index++;
                sum = sum + end_index;
            } else if( i > sum){
                end_index++;
                sum = sum + end_index;
            } else if( i < sum){
                sum = sum - start_index;
                start_index++;
            }
        }

        System.out.println(count);

    }

}

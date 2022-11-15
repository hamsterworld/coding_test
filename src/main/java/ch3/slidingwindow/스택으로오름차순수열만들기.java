package ch3.slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class 스택으로오름차순수열만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] list = new int[P];
        for(int i =0; i<P; i++){
            list[i] = Integer.parseInt(br.readLine());
        }
        int i = 1;
        boolean result = true;
        StringBuffer sb = new StringBuffer();

        for(int j = 0;j<list.length;j++){
            if(list[j] >= i){
                while(list[j] >= i){
                    stack.push(i);
                    i++; //(i+1);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else if(list[j] < i){
                Integer k = stack.pop();
                if(list[j] != k){
                    result = false;
                    System.out.println("NO");
                    break;
                }
                sb.append("-\n");
            }
        }

        if(result){
            System.out.println(sb);
        }


    }
}


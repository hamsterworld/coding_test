package ch7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수팰린드롬수중에서최솟값찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] list = new int[1_0_000_001];
        for(int i =2; i<1_0_000_001; i++){
            list[i] = i;
        }
        for(int i = 2; i<=Math.sqrt(1_0_000_000); i++){
            if(list[i] ==0){
                continue;
            }
            for(int j = i+i; j<1_0_000_001; j+=i){
                list[j] = 0;
            }
        }
        int result = 0;
        for(int i = N; i<1_0_000_001; i++){
            if(list[i] != 0){
                String s = Integer.toString(list[i]);
                char[] chars = s.toCharArray();
                int startIndex = 0;
                int endIndex = chars.length-1;
                boolean checked = true;
                while(startIndex <= endIndex){
                    if(chars[startIndex] == chars[endIndex]){
                        startIndex +=1;
                        endIndex -=1;
                    } else{
                        checked = false;
                        break;
                    }
                }
                if(checked){
                    System.out.println(list[i]);
                    break;
                }
            }
        }
    }
}

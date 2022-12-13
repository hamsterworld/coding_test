package ch5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 신기한소수찾기 {

    static int[] firstList;
    static int[] resultList;
    static int P;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        P = Integer.parseInt(st.nextToken());
        // P = 1

//        dfs(P);
        dfs(2,1);
        dfs(3,1);
        dfs(5,1);
        dfs(7,1);

    }

    static void dfs(int 소수,int 자리수){
        if(자리수 == P){
            if(isPrime(소수)){
                System.out.println(소수);
            }
            return;
        }
        for (int i = 1; i<=10; i++){
            if(i%2 == 0){
                continue;
            }
            if(isPrime(소수 * 10 + i)){
                dfs(소수 * 10 + i,자리수+1);
            }
        }
    }

    private static boolean isPrime(int 소수) {
        for(int i = 2; i<소수/2; i++){
            if(소수%i==0){
                return false;
            }
        }
        return true;
    }


}

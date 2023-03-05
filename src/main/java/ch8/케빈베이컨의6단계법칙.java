package ch8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 케빈베이컨의6단계법칙 {
    private static int[][] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new int[N+1][N+1];

        for(int i =1; i<=N; i++){
            for(int j =1; j<=N; j++){
                if(i == j){
                    list[i][j] = 0;
                } else {
                    list[i][j] = 10000000;
                }
            }
        }

        for(int i =0;i<M; i++){
            st = new StringTokenizer(br.readLine());
            int N1 = Integer.parseInt(st.nextToken());
            int N2 = Integer.parseInt(st.nextToken());
            list[N1][N2] = 1;
            list[N2][N1] = 1;
        }

        for(int k =1; k<=N; k++){
            for(int i =1; i<=N; i++){
                for(int j =1; j<=N; j++){
                    list[i][j] = Math.min(list[i][j],list[i][k]+list[k][j]);
                }
            }
        }

        int answer = 100000000;
        int index = 0;
        for(int i =1; i<=N; i++){
            int result = 0;
            for(int j =1; j<=N; j++){
                result += list[i][j];
            }
            if(answer > result){
                answer = result;
                index = i;
            }
        }

        System.out.println(index);
    }
}

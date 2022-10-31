package ch3.PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringtokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringtokenizer.nextToken());
        int tryNumber = Integer.parseInt(stringtokenizer.nextToken());
        int[][] A = new int[N+1][N+1];
        for(int i = 1; i<=N; i++){
            stringtokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=1;j<=N;j++){
                A[i][j] = Integer.parseInt(stringtokenizer.nextToken());
            }
        }
        int[][] D = new int[N+1][N+1];
        for(int i = 1; i<=N;i++){
            for(int j = 1; j<=N;j++){
                D[i][j] = D[i][j-1] + D[i-1][j] -D[i-1][j-1] + A[i][j];
            }
        }

        for(int i = 0; i<tryNumber; i++){
            stringtokenizer = new StringTokenizer(bufferedReader.readLine());
            int x1 = Integer.parseInt(stringtokenizer.nextToken());
            int y1 = Integer.parseInt(stringtokenizer.nextToken());
            int x2 = Integer.parseInt(stringtokenizer.nextToken());
            int y2 = Integer.parseInt(stringtokenizer.nextToken());

            int result = D[x2][y2]-D[x1-1][y2]-D[x2][y1-1] +D[x1-1][y1-1];
            System.out.println(result);
        }
    }
}
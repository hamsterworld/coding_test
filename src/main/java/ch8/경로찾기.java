package ch8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경로찾기 {
    private static int[][] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        list = new int[N][N];
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N; j++){
                int i1 = Integer.parseInt(st.nextToken());
                list[i][j] = i1;
            }
        }

        for(int k = N-1; k>=0; k--){
            for(int i = 0; i<N; i++){
                for(int j = 0; j<N; j++){
                    if(list[i][k] == 1 && list[k][j] == 1){
                        list[i][j] = 1;
                    }
                }
            }
        }

        for(int i =0; i<N; i++){
            for(int j =0; j<N; j++){
                System.out.print(list[i][j]+" ");
            }
            System.out.println();
        }
    }
}

package ch8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장빠른버스노선구하기 {

    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        graph = new int[N+1][N+1];


        for(int i=1; i<=N; i++){
            for (int j=1; j<=N; j++){
                if(i==j){
                    continue;
                }
                graph[i][j]=99999999;
            }
        }

        for(int i =1; i<=E; i++){
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            int i3 = Integer.parseInt(st.nextToken());
            if(graph[i1][i2] > i3) graph[i1][i2] = i3;
//            graph[i1][i2] = i3;
        }

        floyd(N);

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(graph[i][j] == 99999999) System.out.print(0+" ");
                else System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }

    }

    private static void floyd(int N) {
        for(int i =1; i<=N; i++){
            for(int j=1;j<=N;j++){
                for(int k=1;k<=N;k++){
                    graph[j][k] = Math.min(graph[j][k],graph[j][i]+graph[i][k]);
                }
            }
        }
    }


}

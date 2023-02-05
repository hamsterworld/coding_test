package ch8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 벨만포드 {

    private static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int startIndex = Integer.parseInt(st.nextToken());


        List<edge> list = new ArrayList<>();
        dist = new int[N+1];
        int INF = Integer.MAX_VALUE;

        for (int i = 1; i<=N; i++){
            dist[i] = INF;
        }

        dist[startIndex] = 0;

        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            list.add(new edge(A,B,C));
        }

        for (int i =0; i<N; i++){
            for (int j = 0; j<M; j++){
                edge edge = list.get(j);
                if(dist[edge.v] != INF && dist[edge.w] > dist[edge.v] + edge.cost){
                    dist[edge.w] = dist[edge.v] + edge.cost;
                }
            }
        }

        for (int j = 0; j<M; j++){
            edge edge = list.get(j);
            if(dist[edge.v] != INF && dist[edge.w] > dist[edge.v] + edge.cost){
                dist[edge.w] = dist[edge.v] + edge.cost;
                System.out.println("음수사이클 존재");
                return;
            }
        }

        for (int i : dist) {
            System.out.print(i + " ");
        }

    }

    static class edge{
        private int v;
        private int w;
        private int cost;

        public edge(int v, int w, int cost) {
            this.v = v;
            this.w = w;
            this.cost = cost;
        }

        public int getV() {
            return v;
        }

        public int getW() {
            return w;
        }

        public int getCost() {
            return cost;
        }
    }
}

package ch8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최단경로 {

    private static List<Node>[] list;
    private static boolean[] visited;
    private static int[] dist;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new List[N+1];
        visited = new boolean[N+1];
        dist = new int[N+1];


        for (int i = 1; i<=N; i++){
            list[i] = new ArrayList<Node>();
            dist[i] = INF;
        }

        st = new StringTokenizer(br.readLine());

        int startIndex = Integer.parseInt(st.nextToken());

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            list[A].add(new Node(B,C));
        }

        extra(startIndex);

        for (int i =1 ; i<=N; i++){
            if(dist[i] == INF){
                System.out.println("INF");
                continue;
            }
            System.out.println(dist[i]);
        }

    }

    private static void extra(int startIndex) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startIndex,0));
        dist[startIndex] = 0;
        visited[startIndex] = true;
        while(!pq.isEmpty()){
            Node poll = pq.poll();
            visited[poll.index] = true;
            for (Node item : list[poll.index]) {
                if(!visited[poll.index]){
                    continue;
                }
                int cost = item.cost + poll.cost;
                if( cost < dist[item.index]){
                    dist[item.index] = cost;
                    pq.add(new Node(item.index,cost));
                }
            }

        }

    }

    static class Node implements Comparable<Node>{
        private int index;
        private int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        public int getIndex() {
            return index;
        }

        public int getCost() {
            return cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost,o.cost);
        }
    }
}

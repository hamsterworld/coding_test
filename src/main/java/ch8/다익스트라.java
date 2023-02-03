package ch8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 모든 최단 경로를 구하는 알고리즘
 */
public class 다익스트라 {

    private static boolean[] visited;
    private static int[] dist;
    private static List<Node>[] list;
    private static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        dist = new int[N+1];
        list = new List[N+1];

        for (int i = 0; i<=N; i++){
            list[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for(int i = 1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            list[A].add(new Node(B,C));
        }

        st = new StringTokenizer(br.readLine());
        int startindex = Integer.parseInt(st.nextToken());

        extra(startindex);

        for (int i : dist) {
            System.out.println(i);
        }
    }

    static void extra(int startindex){
        dist[startindex] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startindex,0));
        while(!pq.isEmpty()){
            Node poll = pq.poll();
            if(visited[poll.index]){
                continue;
            }
            visited[poll.index] = true;
            for (Node node : list[poll.index]) {
                int cost = poll.cost + node.cost;
                if(cost < dist[node.index]){
                    dist[node.index] = cost;
                    pq.add(new Node(node.index,cost));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int index;
        int cost;

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
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", cost=" + cost +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost,o.cost);
        }
    }
}

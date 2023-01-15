package ch8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 효율적으로해킹하기2 {

    static List<Integer>[] list;
    static boolean[] visited;
    static int[] countList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new List[N+1];
        countList = new int[N+1];

        for (int i =1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[B].add(A);
        }

        for(int i =1; i<=N; i++){
            visited = new boolean[N+1];
            bfs(i);
        }

        int Max_value = 0;

        for(int i =1; i<=N; i++){
            Max_value = Math.max(Max_value,countList[i]);
        }

        for (int i =1; i<=N; i++){
            if(Max_value == countList[i]){
                System.out.print(i+" ");
            }
        }

    }

    private static void bfs(int index) {
        int count = 0;
        int checked = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(index,count));
        visited[index] = true;
        while(!queue.isEmpty()){
           Node poll = queue.poll();
            List<Integer> integerList = list[poll.getNumber()];
            for (Integer integer : integerList) {
                if(!visited[integer]){
                    Node node = new Node(integer, count++);
                    queue.add(node);
                    visited[integer] = true;
                    checked = node.getCount();
                }
            }
        }
        countList[index] = checked;
    }

    static class Node{
        private int number;
        private int count;

        public Node(int number, int count) {
            this.number = number;
            this.count = count;
        }

        public int getNumber() {
            return number;
        }

        public int getCount() {
            return count;
        }
    }
}

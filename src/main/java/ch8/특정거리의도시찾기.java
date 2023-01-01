package ch8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정거리의도시찾기 {
    private static List<Integer>[] list;
    private static boolean[] visited;
    private static List<Integer> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        answer = new ArrayList<>();
        for(int i =1;i<N+1;i++){
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            System.out.println("hi");
        }
        bfs(K,X);

    }

    private static void bfs(int k, int x) {
        Queue<Node> queue = new LinkedList<>();
        visited[x] = true;
        boolean result = false;
        int forsize = 0;
        queue.add(new Node(x,0));
        while(!queue.isEmpty()){
            Node poll = queue.poll();
            if(poll.count == k){
                answer.add(poll.numbers);
                forsize = queue.size();
                result = true;
                break;
            }

            List<Integer> integerList = list[poll.numbers];
            for (Integer integer : integerList) {
                if(!visited[integer]){
                    queue.add(new Node(integer, poll.count+1));
                    visited[integer] = true;
                }
            }
        }
        if(result){
            for (int i =0;i<forsize; i++){
                answer.add(queue.poll().numbers);
            }
            Collections.sort(answer);
            for (Integer integer : answer) {
                System.out.println(integer);
            }
        } else{
            System.out.println("-1");
        }

    }

    private static class Node{
        private int numbers;
        private int count;

        public Node(int numbers, int count) {
            this.numbers = numbers;
            this.count = count;
        }
    }
}

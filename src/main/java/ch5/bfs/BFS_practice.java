package ch5.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BFS_practice {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int startIndex = Integer.parseInt(st.nextToken());

        List<Integer>[] lists = new List[N+1];
        boolean[] visited = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();

        for(int i =0; i<=N; i++){
            lists[i] = new ArrayList<>();
        }

        for(int i = 1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            lists[i1].add(i2);
            lists[i2].add(i1);
        }

        queue.add(startIndex);
        visited[startIndex] = true;

        while(!queue.isEmpty()){
            Integer polledValue = queue.poll();
            System.out.print(polledValue + " ");
            for(int i = 0; i<lists[polledValue].size(); i++){
                Integer j1 = lists[polledValue].get(i);
                if(!visited[j1]){
                    visited[j1] = true;
                    queue.add(j1);
                }
            }
        }


    }


}

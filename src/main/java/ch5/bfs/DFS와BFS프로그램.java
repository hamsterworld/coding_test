package ch5.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS와BFS프로그램 {

    private static List<Integer>[] list;
    static int N;
    static int M;
    static int startIndex;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        startIndex = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];

        for(int i = 1; i<N+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());

            list[i1].add(i2);
            list[i2].add(i1);
        }
        for(int i = 1; i<N+1; i++){
            Collections.sort(list[i]);
        }

        boolean[] visited = new boolean[N+1];
        dfs(startIndex,1,visited);
        System.out.println();
        visited = new boolean[N+1];
        bfs(startIndex,1,visited);



    }

    private static void bfs(int index, int depth, boolean[] visited) {
        Queue<Integer> queuelist = new LinkedList<>();
        queuelist.add(index);
        if(!visited[index]){
            visited[index] = true;
        }

        while(!queuelist.isEmpty()){
            Integer poll = queuelist.poll();
            System.out.print(poll + " ");
            for(int i =0; i<list[poll].size(); i++){
                if(!visited[list[poll].get(i)]){
                    visited[list[poll].get(i)] = true;
                    queuelist.add(list[poll].get(i));
                }
            }
        }

    }

    private static void dfs(int Index,int depth,boolean[] visited) {
        if(startIndex == Index){
            System.out.print(startIndex+" ");
        }
        if(!visited[Index]){
            visited[Index] = true;
        }
        if(depth == N){
            return;
        }
        for(int i = 0; i<list[Index].size(); i++){
            if(!visited[list[Index].get(i)]){
                System.out.print(list[Index].get(i)+" ");
                dfs(list[Index].get(i),depth+1,visited);
            }
        }
    }
}

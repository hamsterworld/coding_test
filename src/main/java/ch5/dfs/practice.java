package ch5.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class practice {

    static ArrayList<Integer>[] A;
    static boolean visited[];
    static Integer result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        A = new ArrayList[n+1];
        visited = new boolean[n+1];
        result = 0;
        for(int i =1; i<n+1; i++){
            A[i] = new ArrayList<>();
        }

        for(int i =0; i< m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }

        for(int i =1; i<n+1; i++){
            if(!visited[i]){
                result++;
                bfs(i);
            }
        }

        System.out.println(result);
    }

    private static void bfs(int index) {
        LinkedList<Integer> queueList = new LinkedList<>();
        if(!visited[index]){
            visited[index] = true;
        }
        queueList.add(index);
        while(!queueList.isEmpty()){
            Integer poll = queueList.poll();
            for(int i =0; i<A[poll].size(); i++){
                if(!visited[A[poll].get(i)]){
                    visited[A[poll].get(i)] = true;
                    queueList.add(A[poll].get(i));
                }
            }
        }
    }



}

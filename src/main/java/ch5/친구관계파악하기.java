package ch5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class 친구관계파악하기 {

    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static boolean result = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N];
        visited = new boolean[N];

        for(int i =0; i<N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        for(int i =0; i<N; i++){
            dfs(i,1);
            if(result){
                break;
            }

        }
        if(result){
            System.out.println("1");
        } else{
            System.out.println("0");
        }

    }

    private static void dfs(int i, int depth) {
        if(depth == 5){
            result = true;
            return;
        }

        visited[i] = true;

        for(int j = 0; j < list[i].size(); j++){
            if(!visited[list[i].get(j)]){
                dfs(list[i].get(j),depth+1);
                if(result){
                    break;
                }
            }
        }
        visited[i] = false;
    }

}

package ch5.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 친구관계파악하기2 {

    static int[][] list;
    static boolean result = false;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new int[N][N];
        
        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x][y] = 1;
            list[y][x] = 1;
        }

        for(int i =0; i<N; i++){
            boolean[] visited = new boolean[N];
            int count = 1;
            dfs(i,visited,count);
            if(result) {
                break;
            }
        }

        if(result){
            System.out.println("1");
        } else{
            System.out.println("0");
        }
    }
    // visited = true 방문함 , false 방문안함
    private static boolean dfs(int i, boolean[] visited,int count) {
        if(count == 5){
            result = true;
            return true;
        }
        if(!visited[i]){
            visited[i] = true;
        }
        for(int j =0; j<list.length; j++){
            if(list[i][j] == 1 && !visited[j]){
                int count2 = count;
                count2++;
                dfs(i,visited,count2);
                if(result) {
                    break;
                }
            }
        }
        return false;
    }
}

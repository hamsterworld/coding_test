package ch8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 위상정렬DFS {

    private static List<Integer>[] list;
    private static boolean[] visited;
    private static int[] in_degree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new List[N];
        visited = new boolean[N];
        in_degree = new int[N];

        for(int i = 0; i<N; i++){
            list[i] = new ArrayList();
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            list[i1].add(i2);
            in_degree[i2] += 1;
        }

        int check = 0;

        for(int i = 0; i<N; i++){
            int i1 = in_degree[i];
            if(i1 == 0){
                check = i;
            }
        }
        StringBuffer sb = new StringBuffer();

        dfs(check,sb);

        System.out.println(sb.toString());
    }

    private static void dfs(int check,StringBuffer sb) {
        visited[check] = true;
        for (int i = 0; i<list[check].size() ; i++){
            Integer number = list[check].get(i);
            if(!visited[number]){
                in_degree[number] -= 1;
                dfs(number,sb);
            }
        }
        sb.append(check);
    }

}

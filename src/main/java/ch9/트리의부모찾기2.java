package ch9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의부모찾기2 {

    private static List<Integer>[] list;
    private static boolean[] visited;
    private static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        list = new List[N+1];
        visited = new boolean[N+1];
        answer = new int[N+1];

        for(int i = 1; i<=N; i++){
            list[i] = new ArrayList();
        }

        for (int i = 1; i<=(N-1); i++){
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            list[i1].add(i2);
            list[i2].add(i1);
        }

        dfs(1);

        for(int i = 2; i<=N; i++){
            System.out.println(answer[i]);
        }


    }

    private static void dfs(int i) {
        List<Integer> list1 = list[i];
        for (Integer k : list1) {
            if(!visited[k]){
                visited[k] = true;
                answer[k] = i;
                dfs(k);
            }
        }
    }
}

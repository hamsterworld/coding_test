package ch9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의부모찾기 {

    static List<Integer>[] list;
    static boolean[] visited;
    static int[] answer;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        list = new List[N+1];
        answer = new int[N+1];
        visited = new boolean[N+1];
        for (int i =1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i =0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[A].add(B);
            list[B].add(A);
        }

        dfs(1);
        for(int i = 2; i<=N; i++){
            System.out.println(answer[i]);
        }

    }

    private static void dfs(int i) {
        visited[i] = true;
        for (Integer integer : list[i]) {
            if(!visited[integer]){
                visited[integer] = true;
                answer[integer] = i;
                dfs(integer);
            }
        }
        visited[i] = false;
    }
}

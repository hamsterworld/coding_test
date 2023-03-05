package ch8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 최소신장트리 {
    private static List<Integer>[] list;
    private static boolean[] visited;
    private static int answer;
    private static int root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        list = new List[N];
        visited = new boolean[N];
        answer = 0;
        for(int i =0; i<N; i++){
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            int i1 = Integer.parseInt(st.nextToken());
            if(i1 == -1){
                root = i;
                continue;
            }
            list[i].add(i1);
            list[i1].add(i);
        }

        st = new StringTokenizer(br.readLine());
        int delete = Integer.parseInt(st.nextToken());
        visited[delete] = true;
        visited[root]= true;
        if(delete != root){
            dfs(root);
        }

        System.out.println(answer);
    }

    private static void dfs(int i) {
        List<Integer> integerList = list[i];
        int Pnode = 0;
        for (Integer integer : integerList) {
            if(!visited[integer]){
                visited[integer] = true;
                Pnode++;
                dfs(integer);
            }
        }
        if(Pnode == 0){
            answer++;
        }
    }
}

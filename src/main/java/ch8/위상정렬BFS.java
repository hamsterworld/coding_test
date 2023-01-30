package ch8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 위상정렬BFS {

    private static List[] list;
    private static int[] in_degree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new List[N];
        in_degree = new int[N];

        for(int i =0; i<N; i++){
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
        Queue<Integer> bfs = BFS(check);

        for (Integer bf : bfs) {
            System.out.print(bf+" ");
        }

    }

    private static Queue<Integer> BFS(int firstIndex) {
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();
        q.add(firstIndex);
        result.add(firstIndex);

        while(!q.isEmpty()){

            Integer poll = q.poll();

            for(int i =0; i<list[poll].size(); i++){
                in_degree[(Integer) list[poll].get(i)] -= 1;
                Integer value = (Integer) list[poll].get(i);
                q.add(value);
                if(in_degree[(Integer) list[poll].get(i)] == 0){
                    result.add(value);
                }
            }

        }

        return result;
    }

}

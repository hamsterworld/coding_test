package ch8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 효율적으로해킹하기1 {

    static List<Integer>[] list;
    static boolean[] visited;
    static int[] countList;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new List[N+1];
        countList = new int[N+1];
        answer = new int[N+1];
        visited = new boolean[N+1];

        for (int i =1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[B].add(A);
        }

        for(int i =1; i<=N; i++){
            int count = 0;
            int currentIndex = i;
            dfs(i,count,currentIndex);
        }

        for(int i =1; i<=N; i++){
            if(countList[i-1] <= countList[i]){
                answer[i] = countList[i];
            }
        }

        for (int i =1; i<=N; i++){
            if(answer[i] != 0){
                System.out.print(i+" ");
            }
        }

    }

    private static void dfs(int index,int count,int currentIndex) {
        visited[index] = true;
        for(int i =0; i<list[index].size(); i++){
            int integer = list[index].get(i);
            if(!visited[integer]){
                dfs(integer,count+1,currentIndex);
            }
        }
        if(countList[currentIndex] < count){
            countList[currentIndex] = count;
        }
        visited[index] = false;
    }
}

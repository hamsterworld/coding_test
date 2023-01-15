package ch8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 효율적으로해킹하기 {

    private static List<Integer>[] list;
    private static int[] answerlist;
    private static int first;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        answerlist = new int[N+1];

        for (int i =1;i<N+1; i++){
            list[i] = new ArrayList<>();
            answerlist[i] = 0;
        }

        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            list[i1].add(i2);
        }
        for (int i = 1; i<N+1; i++){
            first = i;

            dfs(i,1,new boolean[N+1]);
        }
        int t = 0;
        for(int i = 1; i<N+1; i++){
            if(answerlist[i] > t){
                t = answerlist[i];
            }
        }

        for(int i = 1; i <N+1; i++){
            if(answerlist[i] == t){
                System.out.print(i+" ");
            }
        }

    }
    // visited = true
    // not visited = false
    private static void dfs(int i,int c,boolean[] list1){
        list1[i] = true;
        List<Integer> integerList = list[i];
        if (integerList.isEmpty()){
            if(c > answerlist[i]){
                answerlist[i] = c;
            }
            return;
        }
        for (Integer integer : integerList) {
            if(list1[integer]){
                continue;
            }
            list1[integer] = true;
            dfs(integer,c+1,list1);
        }
    }
}

package ch8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 그래프문제 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        List<Integer>[] arrayLists = new List[N+1];
        for(int i =1; i<=N; i++){
            arrayLists[i] = new ArrayList<>();
        }
        for(int i =1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int startCity = Integer.parseInt(st.nextToken());
            int endCity = Integer.parseInt(st.nextToken());
            arrayLists[startCity].add(endCity);
        }
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);
        int[] ints = new int[N + 1];
        visited[X] = true;
        ints[X]++;
        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            List<Integer> arrayList1 = arrayLists[poll];
            for (Integer integer : arrayList1) {
                if(!visited[integer]){
                    queue.add(integer);
                    ints[integer]++;
                }
            }
        }
        ArrayList<Integer> objects = new ArrayList<>();
        for(int i =1;i<=N; i++){
            if(ints[i] == K){
                objects.add(i);
            }
        }

        if(objects.isEmpty()){
            System.out.println("-1");
        } else {
            Collections.sort(objects);
            for (Integer object : objects) {
                System.out.println(object);
            }
        }

    }

}

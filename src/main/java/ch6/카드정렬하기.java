package ch6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 카드정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cardCount = Integer.parseInt(st.nextToken());
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i=0;i<cardCount;i++){
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            priorityQueue.add(i1);
        }

        int a1 = 0;
        int a2 = 0;
        int result = 0;
        while(priorityQueue.size() != 1){
            a1 = priorityQueue.poll();
            a2 = priorityQueue.poll();
            result += a1 + a2;
            priorityQueue.add(a1+a2);
        }

        System.out.println(result);

    }
}

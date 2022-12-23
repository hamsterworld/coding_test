package ch6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 수를묶어서최댓값만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int positiveCount = 0;
        int negativeCount = 0;
        int ZeroCount = 0;
        int result = 0;
        PriorityQueue<Integer> positiveQueue= new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> NegativeQueue= new PriorityQueue<>();

        if( N == 1 ){
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            System.out.println(i1);
            return;
        }

        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            if(i1 > 0){
                positiveCount += 1;
                positiveQueue.add(i1);
            } else if(i1 < 0){
                negativeCount += 1;
                NegativeQueue.add(i1);
            } else {
                ZeroCount += 1;
            }
        }

        for(int i =0; i<N; i++){
            if(positiveCount > 1){
                int first = positiveQueue.poll();
                int second = positiveQueue.poll();
                if( first == 1 || second == 1){
                    result += first + second;
                    positiveCount -=2;
                    continue;
                }
                result += first * second;
                positiveCount -= 2;
            } else if(positiveCount == 1){
                result += positiveQueue.poll();
                positiveCount -= 1;
                break;
            }
        }

        for(int i =0; i<N; i++){
            if(negativeCount%2 == 0){
                if(negativeCount != 0){
                    int first = NegativeQueue.poll();
                    int second = NegativeQueue.poll();
                    result += first * second;
                    negativeCount -=2;
                } else {
                    break;
                }
            } else {
                if(negativeCount > 1){
                    int first = NegativeQueue.poll();
                    int second = NegativeQueue.poll();
                    result += first * second;
                    negativeCount -=2;
                } else if(negativeCount == 1){
                    if(ZeroCount != 0){
                        negativeCount -=1;
                        break;
                    } else {
                        result += NegativeQueue.poll();
                        negativeCount -=1;
                        break;
                    }
                }
            }
        }

        System.out.println(result);

    }
}

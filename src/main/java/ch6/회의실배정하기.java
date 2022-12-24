package ch6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회의실배정하기 {
    static int result = 1;
    static Map<Integer,Boolean> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

//        PriorityQueue<Time> TimeQueue = new PriorityQueue<>((t1,t2) -> {
//            int time = t1.startTime - t2.startTime;
//            if(time == 0){
//                return t1.endTime-t2.endTime;
//            }
//            return time;
//        } );

        list = new HashMap<>();
        LinkedList<Time> TimeQueue = new LinkedList<>();
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            if(startTime == endTime){
                list.put(startTime,true);
            }
            TimeQueue.add(new Time(startTime,endTime));
        }

        Time poll = TimeQueue.poll();
        int startTime = poll.startTime;
        int endTime = poll.endTime;
        int possibleRoom = -1;

        for (int i =0; i<N-1; i++) {
            Time poll1 = TimeQueue.poll();
            int secondStartTime = poll1.startTime;
            int secondEndTime = poll1.endTime;

            if(startTime == endTime){
                possibleRoom = startTime;
            }

            if(possibleRoom < secondEndTime && possibleRoom > secondStartTime){
                continue;
            }

            // 시간이 겹칠때
            if (secondStartTime >= startTime && secondStartTime < endTime) {
//                int secondEndTime = poll1.endTime;
//                int firstTimeLength = endTime - startTime;
//                int secondTimeLength = secondEndTime - secondStartTime;
//                if (firstTimeLength > secondTimeLength) {
//                    startTime = secondStartTime;
//                    endTime = secondEndTime;
//                }
            } else if(secondEndTime >= startTime && secondEndTime < endTime){

            } else {
                if(secondStartTime == secondEndTime && secondEndTime == endTime){
                    continue;
                }
                if (secondStartTime == secondEndTime && list.get(secondStartTime)){
                    list.put(secondStartTime,false);
                    continue;
                }
                startTime = secondStartTime;
                endTime = poll1.endTime;
                result += 1;
            }
        }

        System.out.println(result);
    }

    static class Time{
        private final int startTime;
        private final int endTime;

        public Time(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}

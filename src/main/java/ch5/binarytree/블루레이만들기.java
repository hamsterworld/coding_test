package ch5.binarytree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 블루레이만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int blueLayLimit = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] lessons = new int[N];
        int totalLessonsSumsLastIndex = 0;
        int startIndex = 0;
        for(int i =0; i<N; i++){
            lessons[i] = Integer.parseInt(st.nextToken());
            if(startIndex < lessons[i]) {
                startIndex = lessons[i];
            }
            totalLessonsSumsLastIndex += lessons[i];
        }

        int endIndex = totalLessonsSumsLastIndex;

        while(startIndex <= endIndex){

            int middle = (startIndex + endIndex)/2;
            int sum = 0;
            int count = 0;
            for(int i =0; i<N; i++){
                if(sum + lessons[i] > middle){
                    sum = 0;
                    count++;
                }
                sum += lessons[i];
            }

            if(sum != 0){
                count++;
            }


            if(blueLayLimit >= count){
                endIndex = middle - 1;
            } else {
                startIndex = middle + 1;
            }
        }

//        System.out.println(startIndex);
        System.out.println(endIndex+1);

    }
}

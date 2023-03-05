package ch9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합구하기3 {

    private static long[] list;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int height = 0;
        int len = N;
        while(len != 0){
            len /= 2;
            height++;
        }
        int size = (int)Math.pow(2,height+1);
        int startLeftIndex = (size/2) -1;
        list = new long[size+1];
        for(int i = startLeftIndex + 1; i<=startLeftIndex+N; i++){
            list[i] = Long.parseLong(br.readLine());
        }
        setTree(size-1);

        for(int i =0; i< M+K; i++){
            st = new StringTokenizer(br.readLine());
            int a =  Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            long e = Long.parseLong(st.nextToken());
            if(a == 1){
                changeVal(startLeftIndex+s,e);
            } else if( a == 2){
                s +=startLeftIndex;
                e +=startLeftIndex;
                long sum = getSum(s, e);
                System.out.println(sum);
            } else {
                return;
            }
        }
    }

    private static long getSum(int start,long end){
        long sum = 0;
        while(start<=end){
            if(start%2 ==1){
                sum += list[start];
                start++;
            }
            if(end%2 == 0){
                sum += list[(int)end];
                end--;
            }
            start /= 2;
            end /= 2;
        }
        return sum;
    }

    private static void changeVal(int index,long val){
        long diff = val - list[index];
        while(index != 0){
            list[index] += diff;
            index /= 2;
        }
    }

    private static void setTree(int index){
        while(index !=0){
            list[index/2] += list[index];
            index--;
        }
    }
}

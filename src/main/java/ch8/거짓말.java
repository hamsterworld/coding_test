package ch8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 거짓말 {

    private static int[] people;
    private static int[] knowPeople;
    private static int[] findPeople;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        people = new int[N+1];

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        knowPeople = new int[K];
        findPeople = new int[M];

        for (int i =1; i<=N; i++){
            people[i] = i;
        }

        for (int i=0; i<K; i++){
            knowPeople[i] = Integer.parseInt(st.nextToken());
        }

        if(K == 0){
            System.out.println(M);
            return;
        }

        for(int i= 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int[] ints = new int[i1];
            int i2 = Integer.parseInt(st.nextToken());
            ints[0] = i2;
            findPeople[i] = i2;
            for(int j = 1; j <i1; j++){
                int i3 = Integer.parseInt(st.nextToken());
                ints[j] = i3;
            }
            if(ints.length > 1){
                for (int k = 0; k<i1-1; k++){
                    union(ints[k],ints[k+1]);
                }
            }
        }

        int count = 0;
        for (int i = 0; i<M; i++){
            boolean lieFlag = true;
            for(int j = 0; j<knowPeople.length; j++){
                if(isunion(findPeople[i],knowPeople[j])){
                    lieFlag = false;
                    break;
                }
            }
            if(lieFlag){
                count++;
            }
        }

        System.out.println(count);
    }

    private static int find(int index){
        if(people[index] == index){
            return index;
        }
        return people[index] = find(people[index]);
    }
    private static void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if( a == b){
            return;
        }
        people[a] = b;
    }

    private static boolean isunion(int x, int y){
        int a = find(x);
        int b = find(y);
        if (a==b){
            return true;
        }
        return false;
    }
}

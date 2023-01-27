package ch8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집합표현하기 {

    private static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new int[N+1];
        for(int i =0; i <=N; i++){
            list[i] = i;
        }

        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            int i3 = Integer.parseInt(st.nextToken());
            if(i1 == 0){
                union(i2,i3);
            } else {
                if(isunion(i2,i3)){
                    System.out.println("YES");
                } else{
                    System.out.println("NO");
                }
            }
        }
    }
    private static int find(int index){
        if(index == list[index]){
            return index;
        }
        list[index] = find(list[index]);
        return list[index];
    }

    private static void union(int x,int y){
        int z = find(x);
        int k = find(y);
        if(z != k){
            list[k] = z;
        }
    }

    private static boolean isunion(int x, int y){
        int z = find(x);
        int k = find(y);
        if(z != k){
            return false;
        }
        return true;
    }
}

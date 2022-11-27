package ch4.quicksort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuickSort {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int P = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] list = new int[P];

        for(int i =0;i<P;i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        quicksortbyme(list,0,list.length-1);

        for(int i =0;i<P;i++){
            System.out.println(list[i]);
        }


    }

    private static void quicksortbyme(int[] list,int start,int end) {

        if(start >= end){
            return;
        }

        int pivotindex = partition(list,start,end);

        quicksortbyme(list,start,pivotindex-1);
        quicksortbyme(list,pivotindex+1,end);
    }


    public static int partition(int[] list,int start,int end){

        int pivotindex = start;
        int pivot = list[pivotindex];

        while(start < end){

            while(list[end] > pivot && start < end){
                end--;
            }

            while(list[start] <= pivot && start < end){
                start++;
            }

            swap(list,start,end);
        }

        swap(list,pivotindex,start);

        return start;
    }

    public static void swap(int[] list,int r, int y){
        int k = list[r];
        list[r] = list [y];
        list[y] = k;
    }
}

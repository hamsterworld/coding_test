import java.util.Scanner;

public class 평균구하기 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int 과목개수 = scanner.nextInt();
        int[] 과목별성적list = new int[과목개수];
        for(int i = 0;  i < 과목개수; i++) {
            과목별성적list[i] = scanner.nextInt();
        }

        long Max = 0;
        long Sum = 0;

        for(int i = 0; i<과목개수;i++){
            Sum += 과목별성적list[i];
            if(과목별성적list[i]>Max){
                Max = 과목별성적list[i];
            }
        }

        System.out.println(Sum*(100.0/(과목개수*Max)));



    }

}

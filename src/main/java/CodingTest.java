import java.util.Scanner;


public class CodingTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String sN = scanner.next();
        char[] chars = sN.toCharArray();
        int sum = 0;
        for(int i = 0;i<chars.length;i++){
            sum += chars[i] - '0';
        }
        System.out.println(sum);
    }
}

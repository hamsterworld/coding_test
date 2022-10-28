public class 시간복잡도 {

    public static void main(String[] args) {

        int random = (int)(Math.random()*100);
        for(int i = 0; i <100; i++){
            if(i == random){
                System.out.println(random);
                break;
            }
        }
    }

}

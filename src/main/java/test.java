import java.lang.reflect.Field;

public class test{

    static String myName;

    static{
        myName="hamster";
    }

    private String foo = "bar";

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> test1 = Class.forName("test");

        Class<? extends Class> aClass = test.class.getClass();
        Field[] fields = aClass.getFields();
        System.out.println(fields.getClass());
        String myName = test.myName;
        System.out.println(myName);
    }

}



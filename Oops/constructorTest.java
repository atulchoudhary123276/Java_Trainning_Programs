import java.sql.SQLOutput;

public class constructorTest {
    int age;
    String name;
    constructorTest(){

    }
    constructorTest(int age,String name){
        age=age;
        name=name;

    }
    constructorTest(int age){
        this.age=age;
    }
    public static void main(String[] args) {
        constructorTest t=new constructorTest();
        constructorTest t1=new constructorTest(11,"Atul");
        constructorTest t2=new constructorTest(11);
        //System.out.println(t1.name==null);
        //System.out.println(t1.name.equals("shiv"));
//        System.out.println(null.equals(null));
    }
}

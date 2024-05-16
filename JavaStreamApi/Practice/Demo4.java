package JavaStreamApi.Practice;

public class Demo4 {
    public static void main(String[] args)
    {
        Integer a = new Integer(6);
        System.out.println(a);
        a=11;
        change(a);
        System.out.println("A = " + a);

        Student s1=new Student();
        s1.n=20;
        System.out.println("A = " + s1.n);

        change1(s1);
        System.out.println("A = " + s1.n);
    }

    public static void change(Integer x)
    {
        x = 10;
        System.out.println("A = " + x);

    }
    public static void change1(Student a){
        a = new Student();
        a.n=30;
    }
}

class Student{
    Integer n;

}

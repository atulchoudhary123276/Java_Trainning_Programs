package Oops;

import java.util.Arrays;
import java.util.Objects;
class Auto{
    int rollnum;
    String name;
    Auto(int rollnum,String b){
        this.rollnum=rollnum;
        this.name=b;
    }
    @Override
    public boolean equals(Object o) {   //now it checks contents
        if (this == o) return true;
        System.out.println("1st");
        if (o == null || getClass() != o.getClass()) return false;
        System.out.println("2nd");
        Auto auto = (Auto) o;
        System.out.println("3rd");
        return this.rollnum == auto.rollnum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollnum);
    }
}
public class ObjectClassMethods {
    public static void main(String[] args) {
        Auto a=new Auto(120,"atul");
        Auto b=new Auto(120,"raman");
        System.out.println(a.equals(b));
        System.out.println(a.hashCode()+"  "+b.hashCode());
    }
}

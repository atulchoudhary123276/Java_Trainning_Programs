package Oops;

import java.util.HashMap;
import java.util.Map;

public class Cloning {
    public static void main(String[] args) throws CloneNotSupportedException {
        Emp e = new Emp();
        e.setA(1);
        e.setStr("sumit");
        Map<String, String> m = new HashMap<>();
        m.put("id", "10");
        m.put("add", "Noida");
        e.setMap(m);

        System.out.println(e.getA());
        System.out.println(e.getStr());
        System.out.println(e.getMap());
        System.out.println("__________________________________________");
        //---------------------------------------------------
        //shallow copy
        Emp e2 = (Emp) e.clone();
        System.out.println(e2.getStr());
        System.out.println(e2.getA());
        System.out.println(e2.getMap());
        System.out.println("+++++++++++++++++++");
        e2.getMap().put("PhoneNo", "8755524581");
        e2.setStr("Kasaundhan");
        e2.setA(3);
        System.out.println(e2.getStr());
        System.out.println(e2.getA());
        System.out.println(e2.getMap());

        System.out.println("---------------------E1");
        System.out.println(e.getA());

        System.out.println(e.getStr());
        System.out.println(e.getMap());

        Emp e3= (Emp) e.clone();
        System.out.println("###########3");
        System.out.println(e3.getA());
        System.out.println(e3.getStr());
        System.out.println(e3.getMap());
        e3.getMap().put("city","GZB");

        System.out.println(e3.getMap());
        System.out.println(e.getMap());


    }
}

class Emp implements Cloneable {
    private int a;
    private String str;  //immutable

    private Map<String, String> map;  //reference mutable

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Emp clone = (Emp) super.clone();
        clone.map=new HashMap<>(this.map);


        return clone;
    }
}


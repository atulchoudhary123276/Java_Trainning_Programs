package Company_Collection;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Demo{
    int rolln;
    String naam;
    Demo(int rolln,String naam){
        this.rolln=rolln;
        this.naam=naam;
    }

    @Override
    public String toString() {
        return "{" +
                "rolln=" + rolln +
                ", naam='" + naam + '\'' +
                '}';
    }
//this is for Hashing on the basis of roll number hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Demo demo = (Demo) o;
        return this.rolln == demo.rolln;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rolln);
    }
}
public class HashsetEx {
    public static void main(String[] args) {
        Set<Integer> set=new java.util.HashSet<>();
        System.out.println(set.add(4));
        System.out.println(set.add(5));
        System.out.println(set.add(3));
        System.out.println(set.add(2));
        System.out.println(set.add(0));
        System.out.println(set.add(3));

        set.remove(3);
        System.out.println(set);
//        Collections.sort(set);   //error
        //custom hashset
        Set<Demo> cSet=new HashSet<>();
        cSet.add(new Demo(121,"raam"));
        cSet.add(new Demo(122,"rohan"));
        cSet.add(new Demo(122,"robin"));
        cSet.add(new Demo(122,"Shivam"));

        System.out.println(cSet);
    }
}

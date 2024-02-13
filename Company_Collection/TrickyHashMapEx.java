package Company_Collection;
//hashmap best example for understanding
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

class emp{
    int id;
    String name;

    emp(int id,String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public String toString() {
        return "emp{" +
                "hc= "+this.hashCode()+
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    void setName(String name){
        this.name=name;
    }
    void setId(int id){
        this.id=id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        emp emp = (emp) o;
        return id == emp.id && Objects.equals(name, emp.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}

public class TrickyHashMapEx {
    public static void main(String[] args) {
        emp e1=new emp(1,"abc");
        emp e2=new emp(2,"xyz");

        Map<emp,String> map=new HashMap<>();
        map.put(e1,"abc");   //null
        map.put(e2,"xyz");  //null
        System.out.println("before");
        System.out.println("e1 = "+map.get(e1)+" hc = "+e1.hashCode());
        System.out.println("e2 = "+map.get(e2)+" hc = "+e2.hashCode());
        System.out.println(map);
        e2.setName("abc");
        e2.setId(1);
        System.out.println("after");
        map.put(e2,"hello");   //abc
        System.out.println("e1 = "+map.get(e1)+" hc = "+e1.hashCode());
        System.out.println("e2 = "+map.get(e2)+" hc = "+e2.hashCode());
        System.out.println(map);

//
        for (Map.Entry<emp,String> e:map.entrySet()){
            System.out.println(e);
            System.out.println(e.hashCode());
        }

//        Set<emp> s=map.keySet();
//        System.out.println(s);

    }
}

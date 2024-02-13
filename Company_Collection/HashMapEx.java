package Company_Collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashMapEx {
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void main(String[] args) {
        Map<Integer,String> m=new HashMap<>();
        m.put(null,"rohan");
        m.put(2,"rashmi");
        m.put(4,"rashmika");
        System.out.println(m.put(null,"roshni"));
        System.out.println(m.put(null,"rashi"));
        m.put(2,"shiv");
        System.out.println(m);

    }
}

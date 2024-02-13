package JavaStreamApi.StreamMethod;

import java.util.ArrayList;
import java.util.List;
class User{
    String name;
    public User(String name) {
        this.name=name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class PeekMethod {
    public static void main(String[] args) {
        List<User> list1=new ArrayList<>();
        list1.add(new User("ALICE"));
        list1.add(new User("CHEF"));
        list1.add(new User("BOB"));

        System.out.println("list1: "+list1);
//        list1.stream().forEach(System.out::println);
//        list1.stream().peek(u->{System.out.println(u.getName());
//            u.setName("atul");}).count();
        System.out.println(list1.stream().peek(u->u.setName("atul")).count());
        list1.stream().peek(u->u.setName("atul")).forEach((e)-> System.out.println(e));
        System.out.println(list1);


//        List<Integer> lnum= Arrays.asList(1,23,45,32,2);
//        System.out.println("listnum: "+lnum);
//        lnum.stream().peek(x->x*2);
    }
}

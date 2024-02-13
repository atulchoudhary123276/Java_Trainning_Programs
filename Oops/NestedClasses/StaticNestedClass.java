package Oops.NestedClasses;
// outer class
class OuterClass {
    // static member
    static int outer_x = 10;

    // instance(non-static) member
    int outer_y = 20;

    // private member
    private static int outer_private = 30;

    // static nested class
    static class StaticNestedClass {   //we can use final also which restrict to inherit
        int a=10;
        static int b=12;

        void display()
        {
            // can access static member of outer class
            System.out.println("outer_x = " + outer_x);

            // can access private static member of
            // outer class
            System.out.println("outer_private = "
                    + outer_private);

            // The following statement will give compilation
            // error as static nested class cannot directly
            // access non-static members
//             System.out.println("outer_y = " + outer_y);

            // Therefore create object of the outer class
            // to access the non-static member
            OuterClass out = new OuterClass();
            System.out.println("outer_y = " + out.outer_y);
            System.out.println(a+"  "+b);
        }
    }

}

// Driver class
public class StaticNestedClass {
    public static void main(String[] args)
    {
        // accessing a static nested class
        OuterClass.StaticNestedClass nestedObject
                = new OuterClass.StaticNestedClass();

        nestedObject.display();
        System.out.println(nestedObject.a+" "+ nestedObject.b);

        OuterClass outer=new OuterClass();
        System.out.println(outer.outer_x);
        System.out.println(outer.outer_y);
        System.out.println(OuterClass.outer_x);


    }
}

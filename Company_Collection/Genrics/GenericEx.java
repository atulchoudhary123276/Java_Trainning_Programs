package Company_Collection.Genrics;
// Generic classes
class Test<T> {
    // An object of type T is declared
    T obj;
    Test(T obj) { this.obj = obj; } // constructor
    public T getObject() { return this.obj; }

}

// Driver class to test above
public class GenericEx {
    public static void main(String[] args)
    {// instance of Integer type
        Test<Integer> iObj = new Test<Integer>(15);
        System.out.println(iObj.getObject());

        // instance of String type
        Test<String> sObj = new Test<String>("GeeksForGeeks");
        System.out.println(sObj.getObject());

        MathOperations<Number> m=new MathOperations<>();
        double douResult = m.add(5.0, 10.0);
        int intResult = (int)m.add(4, 10);
        System.out.println("Integer Addition: " + intResult+" "+douResult);

        double doubleResult = m.multiply(3.5, 2.0);
        System.out.println("Double Multiplication: " + doubleResult);
    }
}
class MathOperations<T extends Number> {
    // Generic method to add two numbers
    public   double add(T num1, T num2) {
        if (num1 instanceof Double && num2 instanceof Double) {
            return num1.doubleValue() + num2.doubleValue();
        }
       else if(num1 instanceof Integer && num2 instanceof Integer){
           return (double) (num1.intValue()+num2.intValue());
        }
       return -0.0;
    }

    // Generic method to multiply two numbers
    public  double multiply(T num1, T num2) {
        return num1.doubleValue() * num2.doubleValue();
    }

}


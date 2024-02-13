package Company.assignments;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class InvalidInputException extends RuntimeException{
   InvalidInputException(String str){
        super(str);
    }
}
class Complex {
    double real;
    double img;
    //initialize with default values
    public Complex() {
        this.real = 0.0;
        this.img = 0.0;
    }
    //parameterize constructor for creating a complex number object
    public Complex(double tempReal,double tempImg){
        real=tempReal;
        img=tempImg;
    }
}
class Operation {
    Complex add(Complex a, Complex b) {
        double real = a.real + b.real;
        double img = a.img + b.img;
        return new Complex(real, img);
    }

    Complex add(Complex a, Complex b, Complex c) {
        double real = a.real + b.real + c.real;
        double img = a.img + b.img + c.img;
        return new Complex(real, img);
    }

    Complex add(Complex... numbers) {
        if(numbers.length==1){
            return numbers[0];
        }
        if (numbers.length == 2) {
            return add(numbers[0], numbers[1]);
        } else if (numbers.length == 3) {
            return add(numbers[0], numbers[1], numbers[2]);
        } else {
            return add(numbers[0], numbers[1], add(Arrays.copyOfRange(numbers, 2, numbers.length)));
        }
    }

    Complex multiply(Complex num1, Complex num2) {
        double resultReal = num1.real * num2.real - num1.img * num2.img;
        double resultImg = num1.real * num2.img + num1.img * num2.real;
        return new Complex(resultReal, resultImg);
    }

    Complex multiply(Complex num1, Complex num2, Complex num3) {
        Complex tempResult = multiply(num1, num2);
        return multiply(tempResult, num3);
    }
    Complex multiply(Complex... numbers) {
        if (numbers.length == 0) {
            return new Complex(1, 0);
        } else if (numbers.length == 1) {
            return numbers[0];
        }
        else {
            return multiply(numbers[0], multiply(Arrays.copyOfRange(numbers, 1, numbers.length)));
        }
    }
    public  double absoluteValue(Complex a) {
        return Math.sqrt(a.real * a.real + a.img * a.img);
    }

    public  double[] absoluteValues(Complex[] numbers) {
        double[] absoluteValues = new double[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            absoluteValues[i] = absoluteValue(numbers[i]);
        }
        return absoluteValues;

    }
    public Complex average(Complex... numbers) {
       double sumReal = 0;
       double sumImg = 0;
       for (Complex num : numbers) {
          sumReal += num.real;
          sumImg += num.img;
        }
        double avgReal = sumReal / numbers.length;
     double avgImg = sumImg / numbers.length;
       return new Complex(avgReal, avgImg);
    }
    public  void minMax(Complex... obj){
       Complex max=obj[0];
       Complex min=obj[0];
        for(int i=0;i< obj.length;i++){
            if(absoluteValue(obj[i])>absoluteValue(max)){
                max=obj[i];
            }
            if(absoluteValue(obj[i])<absoluteValue(min)){
                min=obj[i];
            }

        }
        System.out.println("Maximum value in Complex numbers: "+max.real+" + "+max.img+"i");
        System.out.println("Minimum value in Complex numbers: "+min.real+" + "+min.img+"i");
    }
    public void isOdd(Complex... c){
        System.out.println("\nOdd Complex numbers are:");
        for (Complex x:c){
            if((x.real)%2!=0) {
                ComplexTester.print(x);
            }
        }
    }
    public void isEven(Complex... c){
        System.out.println("\nEven Complex numbers are:");
        for (Complex x:c){
            if((x.real)%2==0) {
                ComplexTester.print(x);
            }
        }
    }
    public boolean isPrime(Complex c){
        if (c.real < 1)
            return false;
        for (int i = 2; i <= c.real / 2; i++)
            if (c.real % i == 0)
                return false;
        return true;
    }
    public  Complex random() {
        Random rand = new Random();
        double realPart = rand.nextInt(10);
        double imgPart = rand.nextInt(10) ;
        return new Complex(realPart, imgPart);
    }

}

public class ComplexTester {

    static Scanner sc = new Scanner(System.in);

    static int input() throws InvalidInputException{
        System.out.println("Enter numbers which you have");
        int no = sc.nextInt();
        if(no<1){
            throw new InvalidInputException("Invalid input :'please enter right number(greater than 0)'");

        }

        return no;

    }

    static Complex readInput() {
        System.out.print("Real part:");
        double tempReal = sc.nextDouble();
        System.out.print("Imaginary part:");
        double tempImg = sc.nextDouble();
        return new Complex(tempReal, tempImg);

    }
    static void print(Complex a) {
        System.out.println(a.real + " + " + a.img + "i");
      }
    static void print(Complex... obj) {
      int t1 = 1;
      for (Complex a : obj) {
          System.out.print(t1 + " Complex number: ");
         print(a);
         t1++;
        }

    }

    public static void main(String[] args) {
        int no;
        try {
            no=input();
        }
        catch (Exception e){
            System.out.println(e);
           no=input();
        }
        int t = 0;
        Complex[] num = new Complex[no];

        while (no > 0) {
            System.out.println();
            System.out.println("enter " + (t + 1) + " number");
            num[t]=new Complex();
            num[t] = readInput();
            no--;
            t = t + 1;

        }
        print(num);
        Operation op = new Operation();
        Complex sum;
        Complex product;
        switch (num.length){
            case 1:
                sum = num[0];
                product = num[0];
                break;
            case 2:
                sum=op.add(num[0],num[1]);
               product=op.multiply(num[0],num[1]);
                break;
            case 3:
                sum=op.add(num[0],num[1],num[2]);
                product=op.multiply(num[0],num[1],num[2]);
                break;
            default:
                sum=op.add(num);
                product=op.multiply(num);
        }
//        if (num.length == 1) {
//
//        }
//        else {
//            sum = (num.length > 3) ? op.add(num) : ((num.length == 2) ? op.add(num[0], num[1]) : op.add(num[0], num[1], num[2]));
//            product = (num.length > 3) ? op.multiply(num) : ((num.length == 2) ? op.multiply(num[0], num[1]) : op.multiply(num[0], num[1], num[2]));
//
//        }
        System.out.println("\nSum is: " + sum.real + " + " + sum.img + "i");
        System.out.println("Multiplication is: " + product.real + " + " + product.img + "i");


        double[] absoluteValuesArray = op.absoluteValues(num);
        System.out.println("\nAbsolute values of complex numbers:-");
        for (int i = 0; i < num.length; i++) {
            System.out.print("Absolute value of ");
            print(num[i]);
            System.out.print(" is: " + absoluteValuesArray[i]+"\n");
        }
        Complex average=op.average(num);
        System.out.println("\nAverage is: " + average.real + " + " + average.img + "i");

      //min-max call
        op.minMax(num);
        //odd method call
        op.isOdd(num);
        //Even method call
        op.isEven(num);
        //Prime call
        System.out.println("\nPrime numbers are: ");
        for(Complex c:num){
            if(op.isPrime(c)){
                print(c);
            }
        }

        //generate random number
        Complex rn=op.random();
        System.out.println("\nRandom Complex number: ");
        print(rn);
    }

}


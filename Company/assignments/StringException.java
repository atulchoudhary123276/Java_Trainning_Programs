package Company.assignments;

import java.util.Scanner;

class NomatchException extends RuntimeException{
    public NomatchException(String str){
        super(str);
    }
}
class CheckString{
    String checkStr(String s) throws NomatchException{

        if((s.equalsIgnoreCase("india"))){
           return s;
        }
        else {
            throw new NomatchException("'please check your input'");

        }

    }
}
public class StringException {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a String:");
        String inStr=sc.nextLine();

        CheckString obj=new CheckString();

        try{
            if(!obj.checkStr(inStr).isBlank()){
                System.out.println("Successfully Validate String!");
            }


        }
        catch (Exception e){
//            System.out.println(e);
            System.out.println(e.getMessage());
            System.out.println(e.toString());
//            e.printStackTrace();
        }

    }
}

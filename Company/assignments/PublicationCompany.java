package Company.assignments;

import java.util.Scanner;

class Publication {
    private String title;
    private float price;


    public void setData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter title: ");
        title = scanner.nextLine();

        try {
            System.out.print("Enter price: ");
            price = Float.parseFloat(scanner.nextLine());
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid input for price. Setting price to 0.0");
            price = 0.0f;
        }
    }

    public void displayData() {
        System.out.println("Title: " + title);
        System.out.println("Price: " + price);
    }
}

class Book extends Publication {
    private int pageCount;

    public Book() {
//        super();
        pageCount = 0;
    }

    @Override
    public void setData() {
        super.setData();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter page count: ");
            pageCount = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for page count. Setting page count to 0.");
            pageCount = 0;
        }
    }

    @Override
    public void displayData() {
        super.displayData();
        System.out.println("Page Count: " + pageCount);
    }
}

class Tape extends Publication {
    private float playingTime;

    public Tape() {
//        super();
        playingTime = 0.0f;
    }

    @Override
    public void setData() {
        super.setData();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter playing time (minutes): ");
            playingTime = Float.parseFloat(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for playing time. Setting playing time to 0.");
            playingTime = 0.0f;
        }
    }

    @Override
    public void displayData() {
        super.displayData();
        System.out.println("Playing Time: " + playingTime + " minutes");
    }
}

public class PublicationCompany {
    public static void main(String[] args) {
        Book book = new Book();
        Tape tape = new Tape();

        System.out.println("Enter Book Details:");
        book.setData();

        System.out.println("\nEnter Tape Details:");
        tape.setData();

        System.out.println("\nBook Information:");
        book.displayData();

        System.out.println("\nTape Information:");
        tape.displayData();
    }
}


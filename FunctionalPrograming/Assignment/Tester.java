package FunctionalPrograming.Assignment;
public class Tester {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 50000);
        Product product2 = new Product("Smartphone",20000 );
        Product product3 = new Product("Watch", 3000);
        Customer customer1= new Customer("123","Sumit Basla", "Sector 58 Noida 201301");
        Customer customer2 = new Customer("124","Atul Chaudhary", "Chandpur Bijnor 246725");
        Operations op = new Operations();
       //  Perform operation
        ShoppingOperation.firstOperation(customer1,product1,product1,product2,product3);
        // Perform operations with the customer and their cart
        op.printProductDetails.perform(customer1);  //opeartion for customer1

        ShoppingOperation.firstOperation(customer2,product1,product2,product2,product3);
//        op.printProductDetails.perform(customer2);  //opeartion for customer1

    }

}

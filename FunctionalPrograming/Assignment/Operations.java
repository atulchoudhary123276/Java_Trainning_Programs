package FunctionalPrograming.Assignment;
import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;
class Operations {
    ShoppingOperation deliver=(cust)->{
        System.out.println("\nHello! Mr. "+cust.getName()+" Your products: ");
        for(Map.Entry<Product,Integer> prod:cust.getCart().getProducts().entrySet()){
            System.out.print(prod.getValue()+" "+prod.getKey().getName()+", ");
        }
        System.out.println("Delivered Successfully on "+LocalDate.now().plusDays(4));
        System.out.println("-----------------------------------------------------------------------");
    };
    DispatchOperation dispatch=(cust,disp)->{
        System.out.print("\nThanks for Payment ");
        System.out.println(" :Payment Received by credit Card");
        System.out.println(cust.getName()+" Your Products: ");
        for(Map.Entry<Product,Integer> prod:cust.getCart().getProducts().entrySet()){
            System.out.println(prod.getValue()+" ,"+prod.getKey().getName()+" ");
        }
        System.out.println("Dispatched Successfully to Your Shipping Address");
        System.out.println("           " + disp.getShippingAdd()+ "\nDispatch Date: " + disp.getDispatchDate() +
                "\nEstimated Delivery Date: " + disp.getEstDeliveryDate());
        deliver.perform(cust);
    };
    ShoppingOperation generateInvoice = (cust) -> {
        // Creating a new invoice from the cart
        System.out.println("Generating Invoice for '" + cust.getName() + "' :");
        // Print invoice

        ShoppingOperation.printInvoice(cust.getCart().getProducts());
        Dispatch d1=new Dispatch(cust.getAddress());  //shipping address of customer
        dispatch.dispatchProducts(cust,d1);

    };
    ShoppingOperation proceedToBuy = (cust) -> {
        System.out.println("\nProceed To Buy : Type Y for Proceed and N for not CheckOut");
        Scanner sc=new Scanner(System.in);
        String choise=sc.nextLine().toLowerCase();
        switch (choise){
            case "y":generateInvoice.perform(cust);
                break;
            case "n":
                System.out.println("Products Successfully added to cart");
                break;
            default:
                System.out.println("please enter right Choise!");
                System.exit(0);
        }
    };

    ShoppingOperation printProductDetails = (cust) -> {
        System.out.println("\nProduct Details in Cart for :" + cust.getName() + "");
        for (Map.Entry<Product,Integer> p : cust.getCart().getProducts().entrySet()) {
            System.out.println(p.getKey()+" quantity: "+p.getValue());
        }
        proceedToBuy.perform(cust);
    };

}

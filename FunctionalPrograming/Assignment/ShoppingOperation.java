package FunctionalPrograming.Assignment;

import java.util.Map;

interface ShoppingOperation {
    void perform(Customer customer);
    static void firstOperation(Customer c,Product... p){
        for (Product p1:p){
            c.addToCart(p1);
        }
    }
    static void printInvoice(Map<Product,Integer> p){
        System.out.println("---------------Invoice--------------");
        double total = 0.0;
        System.out.println("Sold by - Chroma Store 'G-48,NewDelhi,11005,IN'");
        System.out.println("Purchase Products-----------");
        for (Map.Entry<Product,Integer> p1:p.entrySet()) {
            System.out.println(p1.getKey()+"  Quantity-> "+p1.getValue());
            int quan=p1.getValue();
            total += quan*p1.getKey().getPrice();
        }

        System.out.println("Total Amount to Pay(payment accepted by Upi/Card/NetBanking ): " + total);
    }
}
interface DispatchOperation{
    void dispatchProducts(Customer c,Dispatch d);

}
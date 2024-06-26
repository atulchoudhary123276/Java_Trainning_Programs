package Company_Collection.Genrics;
class Node<T> {
    public T data;
    public Node(T data) { this.data = data; }
    public void setData(T data) {
        System.out.println("Node.setData");
        this.data = data;
    }
}
class MyNode extends Node<Integer> {
    public MyNode(Integer data) { super(data); }

    // Bridge method generated by the compiler
  /*  public void setData(Object data) {
        setData((Integer) data);                             Causes a ClassCastException to be thrown.
     }                                            */
    public void setData(Integer data) {
        System.out.println("MyNode.setData");
        super.setData(data);
    }
}
public class GenricBridgeMethod {
    public static void main(String[] args) {
        MyNode mn = new MyNode(5);
        Node n = mn;            // A raw type - compiler throws an unchecked warning
//        n.setData("Hello");                  // Causes a ClassCastException to be thrown.
        n.setData(6);
        Integer x = mn.data;
        System.out.println(x);
    }
}

package storemanagmentsystem;
import java.io.Serializable;
public class OrderItem implements Serializable{
    private Product product;
    private int quantity;
    public OrderItem(Product product, int quantity){
        this.product=product;
        this.quantity=quantity;
    }
    public double getTotalPrice(){
        return((product.getPrice())*quantity);
    }
    public Product getProduct(){
        return product;
    }
    public void setProduct(Product product){
        this.product=product;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
    public void displayInfo(){
        System.out.println("Product name:"+product.getName()+".");
        System.out.println("The quantity of product:"+quantity+".");
    } 
};
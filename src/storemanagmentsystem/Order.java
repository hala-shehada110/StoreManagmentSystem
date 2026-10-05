
package storemanagmentsystem;
import java.util.ArrayList;
import java.io.Serializable;
public class Order implements Serializable {
    private int orderid;
    private Customer customer;
    private ArrayList<OrderItem>items=new ArrayList<>();
    public Order(int orderid,Customer customer){
        this.orderid=orderid;
        this.customer=customer;
    }
    public double getTotalPrice(){
        double total=0;
        for(int i=0;i<items.size();i++){
            total+=items.get(i).getTotalPrice();
        }
        return total;
    }
    public int getOrderId(){
        return orderid;
    }
    public Customer getCustomer(){
        return customer;
    }
    public void setCustomer(Customer customer){
        this.customer=customer;
    }
    public ArrayList<OrderItem> getItems(){
        return items;
    }
    public void addItem(OrderItem item){
        int flag=0;
        OrderItem exist=null;
        for(int i=0;i<items.size();i++){
            if(items.get(i).getProduct().getId()==item.getProduct().getId()){
                flag=1;
                exist=items.get(i);
            }
        }
        if(flag==0)
        items.add(item);
        else{
            int total=(exist.getQuantity())+(item.getQuantity());
            exist.setQuantity(total);
            System.out.println("There is an item with this ID in the order.So the quantity of this item changed.");
        }
    }
    public void removeItem(int itemid){
        for(OrderItem i:items){
            if(i.getProduct().getId()==itemid){
                items.remove(i);
                System.out.println("The item removed successfully.");
                return;
            }
        }
        System.out.println("The item you want to remove doesn't exist.");
    }
    public void updateQuantityOfItem(int productid, int newquantity){
        for(OrderItem i:items){
            if(i.getProduct().getId()==productid){
                int old=i.getQuantity();
                int diff=newquantity-old;
                int stock=i.getProduct().getQuantity();
                i.getProduct().setQuantity(stock-diff);
                i.setQuantity(newquantity);
                System.out.println("The quantity changed successfully");
                return;
            }
        }
        System.out.println("The order doesn't contain this product");
    }
    public void displayInfo(){
        System.out.println("Order ID:"+orderid);
        customer.displayInfo();
        for(int i=0;i<items.size();i++){
            System.out.print((i+1)+":");
            items.get(i).displayInfo();
        }
        System.out.println("The total price:"+this.getTotalPrice());
    }
};
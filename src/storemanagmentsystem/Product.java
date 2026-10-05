package storemanagmentsystem;
import java.io.Serializable;
public class Product implements Serializable{
    private int id;
    private int quantity;
    private double price;
    private String name;
    Product(int id, String name, double price, int quantity){
        this.name=name;
        this.id=id;
        this.price=price;
        this.quantity=quantity;
    }
    public String getName(){
        return name;
        
    }
    public void setName(String name){
        this.name=name;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        if(quantity>=0)this.quantity=quantity;
    }
    public int getId(){
        return id;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        if(price>=0)this.price=price;
    }
    public void displayInfo(){
        System.out.println("Product name:"+name);
        System.out.println("Product ID:"+id);
        System.out.println("Product price:"+price);
        System.out.println("The quantity of product:"+quantity);
    }
    
    
            
    
    
    
};


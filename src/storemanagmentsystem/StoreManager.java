
package storemanagmentsystem;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
public class StoreManager {
    private ArrayList<Product>products=new ArrayList<>();
    private ArrayList<Customer>customers=new ArrayList<>();
    private ArrayList<Order>orders=new ArrayList<>();
    public void SaveOrdersToFile(){
        try{
            ObjectOutputStream writer=new ObjectOutputStream(new FileOutputStream("orders.dat"));
            writer.writeObject(orders);
            writer.close();
        }
        catch(IOException e){
            System.out.println("Something went wrong.");
        }
    }
    public void LoadOrdersFromFile(){
        try{
            ObjectInputStream reader=new ObjectInputStream(new FileInputStream("orders.dat"));
            orders=(ArrayList<Order>)reader.readObject();
            reader.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("No saved file found.Starting with empty list.");
        }
        catch(IOException |ClassNotFoundException e){
            System.out.println("Something went wrong.");
        }
    }
    public void SaveCustomersToFile(){
        try{
            ObjectOutputStream writer=new ObjectOutputStream(new FileOutputStream("customers.dat"));
            writer.writeObject(customers);
            writer.close();
        }
        catch(IOException e){
            System.out.println("Something went wrong.");
        }
    }
    public void LoadCustomersFromFile(){
        try{
            ObjectInputStream reader=new ObjectInputStream(new FileInputStream("customers.dat"));
            customers=(ArrayList<Customer>)reader.readObject();
            reader.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("No saved file found.Starting with empty list.");
        }
        catch(IOException |ClassNotFoundException e){
            System.out.println("Something went wrong.");
        }
    }
    public void SaveProductsToFile(){
        try{
            ObjectOutputStream writer=new ObjectOutputStream(new FileOutputStream("products.dat"));
            writer.writeObject(products);
            writer.close();
        }
        catch(IOException e){
            System.out.println("Something went wrong.");
        }
    }
    public void LoadProductsFromFile(){
        try{
            ObjectInputStream reader=new ObjectInputStream(new FileInputStream("products.dat"));
            products=(ArrayList<Product>)reader.readObject();
            reader.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("No saved file found.Starting with empty list.");
        }
        catch(IOException |ClassNotFoundException e){
            System.out.println("Something went wrong.");
        }
    }
    public void addProduct(Product product){
        boolean exist=false;
        for(int i=0;i<products.size();i++){
            if(product.getId()==products.get(i).getId()){
               exist=true;
               break;  
            }
        }
        if(exist==false)
        products.add(product);
        else
            System.out.println("There is a product with this ID in the store.");
    }
    public void addCustomer(Customer customer){
        boolean exist=false;
        for(int i=0;i<customers.size();i++){
            if(customer.getId()==customers.get(i).getId()){
               exist=true;
               break;  
            }
        }
        if(exist==false)
        customers.add(customer);
        else
            System.out.println("There is a customer with this ID.");
    }
    public void addOrder(Order order){
        boolean exist=false;
        for(int i=0;i<orders.size();i++){
            if(order.getOrderId()==orders.get(i).getOrderId()){
               exist=true;
               break;  
            }
        }
        if(exist==false)
        orders.add(order);
        else
            System.out.println("There is an order with this ID.");
    }
    public Product findProductById(int id){
        for(int i=0;i<products.size();i++){
            if(products.get(i).getId()==id)
                return products.get(i);
        }
        return null;
    }
    public Customer findCustomerById(int id){
        for(int i=0;i<customers.size();i++){
            if(customers.get(i).getId()==id)
                return customers.get(i);
        }
        return null;
    }
    public Order findOrderById(int id){
        for(int i=0;i<orders.size();i++){
            if(orders.get(i).getOrderId()==id)
                return orders.get(i);
        }
        return null;
    }
    public void removeProductById(int id){
        Product p=findProductById(id);
        if(p!=null)
            products.remove(p);
        else
            System.out.println("The product you want to remove doesn't exist.");
    }
    public void removeCustomerById(int id){
        Customer c=findCustomerById(id);
        if(c!=null)
            customers.remove(c);
        else
            System.out.println("The customer you want to remove doesn't exist.");
    }
    public void removeOrderById(int id){
        Order o=findOrderById(id);
        if(o!=null)
            orders.remove(o);
        else
            System.out.println("The order you want to remove doesn't exist.");
    }
    public void updateProductById(int id, Scanner input){
        Product p=findProductById(id);
        if(p!=null){
            System.out.println("Please enter the new name:");
            String newname=input.nextLine();
            while(!newname.matches("[a-zA-Z\\u0600-\\u06FF ]+")){
            System.out.println("Invalid name. Please enter letters only.");
            newname = input.nextLine();
            }
            p.setName(newname);
            double newprice;
                    while(true){
                        try{
                            System.out.println("Please enter the new price:");
                            newprice=Double.parseDouble(input.nextLine());
                            if(newprice>=0)break;
                            System.out.println("The price should be 0 or more than 0.");
                        }
                        catch(NumberFormatException e){
                            System.out.println("The price should be number.");
                        }
                    }
            p.setPrice(newprice);
            int newquantity;
                    while(true){
                        try{
                            System.out.println("Please enter the new quantity:");
                            newquantity=Integer.parseInt(input.nextLine());
                            if(newquantity>=0)break;
                            System.out.println("The quantity should be 0 or more than 0.");
                        }
                        catch(NumberFormatException e){
                            System.out.println("The quantity should be integer number.");
                        }
                    }
            p.setQuantity(newquantity);  
        }
        else
            System.out.println("The product you want to update doesn't exist.");
    }
    public void updateCustomerById(int id, Scanner input){
        Customer c=findCustomerById(id);
        if(c!=null){
            System.out.println("Please enter the new name:");
            String newname=input.nextLine();
            while(!newname.matches("[a-zA-Z\\u0600-\\u06FF ]+")){
            System.out.println("Invalid name. Please enter letters only.");
            newname = input.nextLine();
            }
            c.setName(newname);
            System.out.println("Please enter the new phone number:");
            String newphoneno=input.nextLine();
                    while(!newphoneno.matches("\\+?[0-9]{7,15}")){
                        System.out.println("Invalid phone number. Please enter a valid phone number:");
                        newphoneno=input.nextLine();
                    }
            c.setPhoneNo(newphoneno);
        }
        else
            System.out.println("The customer you want to update his data doesn't exist.");
    }
     public void updateOrderById(int id, Scanner input){
        Order o=findOrderById(id);
        if(o!=null){
            System.out.println("choose:");
            System.out.print("1.update customer.\n2.add item.\n3.remove item.\n4.update the quantity of specific item.\n");
            int ch;
            try{
                ch=Integer.parseInt(input.nextLine()); 
            }
            catch(NumberFormatException e){
                ch=0;
            }
            switch(ch){
                case 1:{
                    int newid;
                    while(true){
                        try{
                            System.out.println("Please enter the ID of the new customer:");
                            newid=Integer.parseInt(input.nextLine());
                            if(newid>0)
                            break;
                            else
                                System.out.println("The ID should be more than 0.");
                        }
                        catch(NumberFormatException e){
                            System.out.println("The ID should be number.");
                        }
                    }
                    Customer newcustomer1=findCustomerById(newid);
                    if(newcustomer1!=null)
                    o.setCustomer(newcustomer1);
                    else{
                        System.out.println("Please enter the name of the new customer:");
                        String newname=input.nextLine();
                        while(!newname.matches("[a-zA-Z\\u0600-\\u06FF ]+")){
                        System.out.println("Invalid name. Please enter letters only.");
                        newname = input.nextLine();
                        }
                        System.out.println("Please enter the phone number of the new customer:");
                        String newphoneno=input.nextLine();
                        while(!newphoneno.matches("\\+?[0-9]{7,15}")){
                        System.out.println("Invalid phone number. Please enter a valid phone number:");
                        newphoneno=input.nextLine();
                    }
                        Customer newcustomer2=new Customer(newid,newname,newphoneno);
                        o.setCustomer(newcustomer2); 
                        addCustomer(newcustomer2);
                    }
                    System.out.println("The order has been successfully updated.");
                    break;
                }
                case 2:{
                    int productid;
                    while(true){
                        try{
                            System.out.println("Please enter the ID of the new item you want to add:");
                            productid=Integer.parseInt(input.nextLine());
                            if(productid>0)
                            break;
                            else
                                System.out.println("The ID should be more than 0.");
                        }
                        catch(NumberFormatException e){
                            System.out.println("The ID should be number.");
                        }
                    }
                    Product p=findProductById(productid);
                    int newquantity=-1;
                    if(p!=null){
                    while(true){
                        try{
                            System.out.println("Please enter the quantity of the new item you want to add:");
                            newquantity=Integer.parseInt(input.nextLine());
                            if(newquantity>0){
                                if(newquantity<=p.getQuantity()){
                                    
                                    break; 
                                }
                                else
                                    System.out.println("The quantity of the product in the store is"+p.getQuantity());
                            }
                            else
                                System.out.println("The quantity should be more than 0.");
                        }
                        catch(NumberFormatException e){
                            System.out.println("The quantity should be number.");
                        }
                    }
                    }
                    if(p!=null){
                        OrderItem orderitem=new OrderItem(p,newquantity);
                        o.addItem(orderitem);
                        int stock=p.getQuantity();
                        int diff=stock-newquantity;
                        p.setQuantity(diff);
                        System.out.println("The order has been successfully updated.");
                    }
                    else
                        System.out.println("The product you want to add doesn't exist.");
                    break;       
                }
                case 3:{
                    if(o.getItems().size()!=0){
                    int productid;
                    while(true){
                        try{
                            System.out.println("Please enter the ID of the item you want to remove:");
                            productid=Integer.parseInt(input.nextLine());
                            if(productid>0)
                            break;
                            else
                                System.out.println("The ID should be more than 0.");
                        }
                        catch(NumberFormatException e){
                            System.out.println("The ID should be number.");
                        }
                    }
                    OrderItem orderitem=null;
                    for(int i=0;i<o.getItems().size();i++){
                    if(((o.getItems()).get(i)).getProduct().getId()==productid)
                    orderitem= o.getItems().get(i);
                }
                    int total=0;
                    if(orderitem!=null){
                    int oq=orderitem.getQuantity();
                    int stock=orderitem.getProduct().getQuantity();
                    total=stock+oq;
                    }
                    o.removeItem(productid);
                    if(orderitem!=null)
                    orderitem.getProduct().setQuantity(total);
                    }
                    else
                        System.out.println("The order doesn't contain any item");
                    break;
                }
                case 4:{
                    if(o.getItems().size()!=0){
                    int productid;
                    OrderItem orderitem=null;
                    while(true){
                        try{
                            System.out.println("Please enter the ID of the item:");
                            productid=Integer.parseInt(input.nextLine());
                            if(productid>0){
                                int flag=0;
                                for(int i=0;i<o.getItems().size();i++){
                                    if(o.getItems().get(i).getProduct().getId()==productid){
                                        flag=1;
                                        orderitem=o.getItems().get(i);
                                    }
                                }
                                if(flag==1)
                                    break;
                                else System.out.println("The order doesn't have an item with this ID.");
                            }
                            
                            else
                                System.out.println("The ID should be more than 0.");
                        }
                        catch(NumberFormatException e){
                            System.out.println("The ID should be number.");
                        }
                    }
                    int newquantity;
                    while(true){
                        try{
                            System.out.println("Please enter the new quantity:");
                            newquantity=Integer.parseInt(input.nextLine());
                            if(newquantity>0){
                                if(newquantity<=(orderitem.getProduct().getQuantity()+orderitem.getQuantity()))
                                    break;
                                else
                                    System.out.println("The quantity of the product in the store is"+(orderitem.getProduct().getQuantity()+orderitem.getQuantity()));
                            }
                            else
                                System.out.println("The quantity should be more than 0.");
                        }
                        catch(NumberFormatException e){
                            System.out.println("The quantity should be number.");
                        }
                    }
                    o.updateQuantityOfItem(productid, newquantity);
                    }
                    else
                        System.out.println("The order doesn't have any item.");
                    break;
                }
                default:
                    System.out.println("Invalid choice");
            }
            
        }
        else
            System.out.println("The order you want to update his data doesn't exist.");
     }
     public void displayProducts(){
         if(products.size()!=0){
             for(int i=0;i<products.size();i++){
             System.out.println((i+1)+":");
             products.get(i).displayInfo();
         }
         }
         else
             System.out.println("There is no any product in the store.");
     }
     public void displayCustomers(){
         if(customers.size()!=0){
             for(int i=0;i<customers.size();i++){
             System.out.println((i+1)+":");
             customers.get(i).displayInfo();
         }
         }
         else
             System.out.println("There is no any customer.");
     }
     public void displayOrders(){
         if(orders.size()!=0){
             for(int i=0;i<orders.size();i++){
             System.out.println((i+1)+":");
             orders.get(i).displayInfo();
         }
         }
         else
             System.out.println("There is no any order.");
     }
};


package storemanagmentsystem;
import java.util.Scanner;
import java.util.Locale;
import java.lang.NumberFormatException;
public class StoreManagmentSystem {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        input.useLocale(Locale.US);
        StoreManager manager=new StoreManager();
        manager.LoadProductsFromFile();
        manager.LoadCustomersFromFile();
        manager.LoadOrdersFromFile();
        int ch;
        do{
            System.out.println("=====Store Managment System=====");
            System.out.println("1. Add Product");
            System.out.println("2. Display Products");
            System.out.println("3. Search Product");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Add Customer");
            System.out.println("7. Create Order");
            System.out.println("8. Display Orders");
            System.out.println("9. Update order");
            System.out.println("10. Exit");
            System.out.println("Choose:");
            try{
                ch=Integer.parseInt(input.nextLine()); 
            }
            catch(NumberFormatException e){
                ch=0;
            }
            switch(ch){
                case 1:{
                    System.out.println("Please enter the name:");
                    String name=input.nextLine();
                    while(!name.matches("[a-zA-Z\\u0600-\\u06FF ]+")){
                        System.out.println("Invalid name. Please enter letters only.");
                        name = input.nextLine();
                    }
                    double price;
                    while(true){
                        try{
                            System.out.println("Please enter the price:");
                            price=Double.parseDouble(input.nextLine());
                            if(price>=0)break;
                            System.out.println("The price should be 0 or more than 0.");
                        }
                        catch(NumberFormatException e){
                            System.out.println("The price should be number.");
                        }
                    }
                    int id;
                    while(true){
                        try{
                            System.out.println("Please enter the ID:");
                            id=Integer.parseInt(input.nextLine());
                            if(id>0){
                                if(manager.findProductById(id)==null)
                                    break;
                                else
                                    System.out.println("There is a product with this ID");
                            }
                            else
                                System.out.println("The ID should be more than 0.");
                        }
                        catch(NumberFormatException e){
                            System.out.println("The ID should be number.");
                        }
                    }
                    int quantity;
                    while(true){
                        try{
                            System.out.println("Please enter the quantity:");
                            quantity=Integer.parseInt(input.nextLine());
                            if(quantity>=0)break;
                            System.out.println("The quantity should be 0 or more than 0.");
                        }
                        catch(NumberFormatException e){
                            System.out.println("The quantity should be integer number.");
                        }
                    }
                    Product p=new Product(id,name,price,quantity);
                    manager.addProduct(p);
                    manager.SaveProductsToFile();
                    break; 
                }
                case 2:{
                    manager.displayProducts();
                    break;
                }
                case 3:{
                    int id;
                    while(true){
                        try{
                            System.out.println("Please enter the ID:");
                            id=Integer.parseInt(input.nextLine());
                            if(id>0)
                            break;
                            else
                                System.out.println("The ID should be more than 0.");
                        }
                        catch(NumberFormatException e){
                            System.out.println("The ID should be number.");
                        }
                    }
                    Product p=manager.findProductById(id);
                    if(p!=null){
                        p.displayInfo();
                    }
                    else
                        System.out.println("There is no product with this ID.");
                    break;
                }
                case 4:{
                    int id;
                    while(true){
                        try{
                            System.out.println("Please enter the ID:");
                            id=Integer.parseInt(input.nextLine());
                            if(id>0)
                            break;
                            else
                                System.out.println("The ID should be more than 0.");
                        }
                        catch(NumberFormatException e){
                            System.out.println("The ID should be number.");
                        }
                    }
                    manager.updateProductById(id, input);
                    manager.SaveProductsToFile();
                    break;
                }
                case 5:{
                    int id;
                    while(true){
                        try{
                            System.out.println("Please enter the ID:");
                            id=Integer.parseInt(input.nextLine());
                            if(id>0)
                            break;
                            else
                                System.out.println("The ID should be more than 0.");
                        }
                        catch(NumberFormatException e){
                            System.out.println("The ID should be number.");
                        }
                    }
                    manager.removeProductById(id);
                    manager.SaveProductsToFile();
                    break;
                }
                case 6:{
                    System.out.println("Please enter the name:");
                    String name=input.nextLine();
                    while(!name.matches("[a-zA-Z\\u0600-\\u06FF ]+")){
                        System.out.println("Invalid name. Please enter letters only.");
                        name = input.nextLine();
                    }
                    System.out.println("Please enter the phone number:");
                    String phoneno=input.nextLine();
                    while(!phoneno.matches("\\+?[0-9]{7,15}")){
                        System.out.println("Invalid phone number. Please enter a valid phone number:");
                        phoneno=input.nextLine();
                    }
                    
                   int id;
                    while(true){
                        try{
                            System.out.println("Please enter the ID:");
                            id=Integer.parseInt(input.nextLine());
                            if(id>0)
                            break;
                            else
                                System.out.println("The ID should be more than 0.");
                        }
                        catch(NumberFormatException e){
                            System.out.println("The ID should be number.");
                        }
                    }
                    Customer c=new Customer(id,name,phoneno);
                    manager.addCustomer(c);
                    manager.SaveCustomersToFile();
                    break;
                }
                case 7:{
                    int id;
                    while(true){
                        try{
                            System.out.println("Please enter the ID of the customer:");
                            id=Integer.parseInt(input.nextLine());
                            if(id>0)
                            break;
                            else
                                System.out.println("The ID should be more than 0.");
                        }
                        catch(NumberFormatException e){
                            System.out.println("The ID should be number.");
                        }
                    }
                    Customer c=manager.findCustomerById(id);
                    if(c!=null){
                        int orderid;
                    while(true){
                        try{
                            System.out.println("Please enter the ID of the new order:");
                            orderid=Integer.parseInt(input.nextLine());
                            if(orderid>0){
                                if(manager.findOrderById(orderid)==null)
                                    break;
                                else
                                    System.out.println("There is an order with this ID");
                            }
                            else
                                System.out.println("The ID should be more than 0.");
                        }
                        catch(NumberFormatException e){
                            System.out.println("The ID should be number.");
                        }
                    }
                        Order o=new Order(orderid,c);
                        int n;
                    while(true){
                        try{
                            System.out.println("How many items do you want to be in the order?");
                            n=Integer.parseInt(input.nextLine());
                            if(n>0)
                            break;
                            else
                                System.out.println("The number of items should be more than 0.");
                        }
                        catch(NumberFormatException e){
                            System.out.println("The number of items should be number.");
                        }
                    }
                        for(int i=1;i<=n;i++){
                            int productid;
                           while(true){
                        try{
                            System.out.println("Please enter the ID of the Product:");
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
                           Product p=manager.findProductById(productid);
                           if(p!=null){
                          int quantity;
                    while(true){
                        try{
                            System.out.println("Please enter the quantity of the item:");
                            quantity=Integer.parseInt(input.nextLine());
                            if(quantity>0){
                                if(quantity<=p.getQuantity())
                                    break;
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
                               OrderItem item=new OrderItem(p,quantity);
                               o.addItem(item);
                               System.out.println("The product "+p.getName()+"("+p.getId()+") has been successfully added");
                           }
                           else{
                               System.out.println("There is no product with this ID"+"("+productid+")"+" to add.");
                           }
                        }//for loop
                        if(o.getItems().size()>0){
                            manager.addOrder(o);
                        for(int i=0;i<(o.getItems().size());i++){
                            int stock=(o.getItems().get(i).getProduct().getQuantity());
                            int qorder=(o.getItems().get(i).getQuantity());
                            int diff=stock-qorder;
                            Product p=o.getItems().get(i).getProduct();
                            p.setQuantity(diff);
                        }
                            System.out.println("The order has been created successfully.");
                        }
                        else{
                            System.out.println("The order should contain one item at least.");
                        }
                        
                        
                    }
                    else
                        System.out.println("You can not create an order.You should add the customer.");
                    manager.SaveOrdersToFile();
                    break; 
                }
                case 8:{
                    manager.displayOrders();
                    break;
                }
                case 9:{
                    int id;
                    while(true){
                        try{
                            System.out.println("Please enter the ID of the order:");
                            id=Integer.parseInt(input.nextLine());
                            if(id>0)
                            break;
                            else
                                System.out.println("The ID should be more than 0.");
                        }
                        catch(NumberFormatException e){
                            System.out.println("The ID should be number.");
                        }
                    }
                    manager.updateOrderById(id, input);
                    manager.SaveOrdersToFile();
                    break;
                }
                case 10:
                    manager.SaveProductsToFile();
                    manager.SaveCustomersToFile();
                    manager.SaveOrdersToFile();
                    System.out.println("Goodbye.");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            
        }while(ch!=10);
    } 
};
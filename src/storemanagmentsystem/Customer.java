
package storemanagmentsystem;
import java.io.Serializable;
public class Customer implements Serializable {
    private String name;
    private String phoneno;
    private int id;
    public Customer(int id, String name, String phoneno){
        this.id=id;
        this.name=name;
        this.phoneno=phoneno;
    }
    public String getName(){
        return name;
        
    }
    public void setName(String name){
        this.name=name;
    }
    public String getPhoneNo(){
        return phoneno;
        
    }
    public void setPhoneNo(String phoneno){
        this.phoneno=phoneno;
    }
    public int getId(){
        return id;
    }
    public void displayInfo(){
        System.out.println("Customer name:"+name);
        System.out.println("Customer phone number:"+phoneno);
        System.out.println("Customer ID:"+id);
    }
};

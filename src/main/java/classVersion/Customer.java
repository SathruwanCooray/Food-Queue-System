package classVersion;


public class Customer  {
     private final String customerFirstName;
     private final String customerLastName;
     private int burger;


     Customer(String customerFirstName, String customerLastName, int burger){
          this.customerFirstName = customerFirstName;
          this.customerLastName = customerLastName;
          this.burger = burger;
     }

     public String getCustomerFirstName(){
          return customerFirstName;
     }

     public String getCustomerLastName(){
          return customerLastName;
     }

     public int getBurger(){
          return burger;
     }

     public void setBurger(int burger) {
          this.burger = burger;
     }
}





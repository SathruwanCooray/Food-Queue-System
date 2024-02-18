package classVersion;
import java.util.ArrayList;


public class FoodQueue {
    ArrayList<Customer> customers;

    FoodQueue() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer1) {
        customers.add(customer1);
    }
    public void removeCustomer(int rowNum){
        int newIndexPosition = rowNum-1;
        customers.remove(newIndexPosition);
    }

    public void removeServedCustomer(){
        customers.remove(0);
    }

    public void sort() {
        int index = customers.size();
        for (int i = 0; i < index - 1; i++) {
            if (customers.get(i).getCustomerFirstName().compareTo(customers.get(i + 1).getCustomerFirstName()) > 0) {
                Customer temp = customers.get(i);
                customers.set(i, customers.get(i + 1));
                customers.set(i + 1, temp);
            }
        }
    }

    public ArrayList<Customer> getCustomers(){
        return customers;
    }

    public int getQueueSize(){
        return customers.size();
    }
}
import java.util.ArrayList;

public class Store
{
    private ArrayList<Customer> customers;
    
    public Store()
    {
        customers = new ArrayList<Customer>();
    }
    
    public void addSale(String customerName, double amount)
    {
        Customer customer = new Customer(customerName, amount);
        this.customers.add(customer);
    }
    
    public String nameOfBestCustomer()
    {
        Customer best = customers.get(0);
        
        for (Customer customer : customers)
        {
            if (customer.getAmount() > best.getAmount())
            {
                best = customer;
            }
        }
        
        return best.getName();
    }
}
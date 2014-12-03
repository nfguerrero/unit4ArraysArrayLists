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
    
    public ArrayList<String> nameOfBestCustomers(int topN)
    {
        ArrayList<String> best = new ArrayList<String>();
        ArrayList.set(0, customers.get(0))
        ArrayList.set(1, customers.get(1))
        ArrayList.set(2, customers.get(2))
        
        for (int i = 0; i < customers.size()-1; i++)
        {
            if (customer.getAmount() >
        }
    }
}
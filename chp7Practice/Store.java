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
        ArrayList<Customer> best = new ArrayList<Customer>(topN);
        best.add(customers.get(0));
        best.add(customers.get(1));
        best.add(customers.get(2));
        
        for (int i = 4; i < customers.size(); i++)
        {
            for (int j = 0; j < best.size(); j++)
            {
                if (customers.get(i).getAmount() > best.get(j).getAmount())
                {
                    best.set(j, customers.get(i));
                }
            }
        }
        
        ArrayList<String> names = new ArrayList<String>(topN);
        for (int i = 0; i < best.size(); i++)
        {
            names.add(best.get(i).getName());
        }
        
        return names;
    }
}
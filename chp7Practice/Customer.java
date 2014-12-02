import java.util.ArrayList;

public class Customer
{
    private String name;
    private double amount;
    
    public Customer(String customerName, double amount)
    {
        this.name = customerName;
        this.amount = amount;
    }
    
    public double getAmount()
    {
        return this.amount;
    }
    
    public String getName()
    {
        return this.name;
    }
}

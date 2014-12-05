import java.util.Scanner;

public class Cashier
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Store store = new Store();
        
        System.out.print("Amount of customers: ");
        int customers = scan.nextInt();

        System.out.println("");
        for (int i = 0; i < customers; i++)
        {
            System.out.print("Name" + (i+1) + ": ");
            String name = scan.next();
            System.out.print("Amount: ");
            double amount = scan.nextDouble();
            
            store.addSale(name, amount);
        }
        
        System.out.println("\nName of best Customer: " + store.nameOfBestCustomer());
        
        System.out.print("\nName of best Customers: ");
        for (int i = 0; i < 3; i++)
        {
            System.out.print(store.nameOfBestCustomers(3).get(i) + " ");
        }
    }
}

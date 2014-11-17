public class ArrayOperations
{
    public static void main(String[] args)
    {
        double[] x = {8, 4, 5, 21, 7, 9, 18, 2, 100};
        
        System.out.println("Length elements: " + x.length);
        System.out.println("First element: " + x[0]);
        System.out.println("Last element: " + x[x.length-1]);
        
        for(double i: x)
        {
            System.out.println(i);
        }
    }
}

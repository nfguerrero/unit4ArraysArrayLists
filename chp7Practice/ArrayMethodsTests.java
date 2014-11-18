public class ArrayMethodsTests
{
    public static void main(String[] args)
    {
        int[] values = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayMethods array = new ArrayMethods(values);
        
        //Original
        System.out.print("Original:");
        for(int i : values)
        {
            System.out.print(" " + i);
        }
        System.out.println("\n");
        
        //swapFirstAndLast
        array.swapFirstAndLast();
        System.out.print("swapFirstAndLast:");
        for(int i : values)
        {
            System.out.print(" " + i);
        }
        System.out.println("\n");
    }
}

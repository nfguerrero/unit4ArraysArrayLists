public class Testing
{
    public static void main(String[] args)
    {
        int[] a = new int[] {1, 2, 3};
        int[] b = new int[] {4, 5, 6};
      
        b = a;
        
        a[0] = 9;
        
        System.out.println(a[0]);
        System.out.print(b[0]);
    }
}

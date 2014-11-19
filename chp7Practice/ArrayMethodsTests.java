public class ArrayMethodsTests
{
    public static void main(String[] args)
    {
        int[] values = {9, 8, 9, 8, 9, 8, 9, 8, 9, 8};
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
        
        //shiftRight
        array.shiftRight();
        System.out.print("shiftRight:");
        for(int i : values)
        {
            System.out.print(" " + i);
        }
        System.out.println("\n");
        
        //evensToZero
        array.evensToZero();
        System.out.print("evensToZero:");
        for(int i : values)
        {
            System.out.print(" " + i);
        }
        System.out.println("\n");
        
        //replaceWithLargerNeighbor
        array.replaceWithLargerNeighbor();
        System.out.print("replaceWithLargerNeighbor:");
        for(int i : values)
        {
            System.out.print(" " + i);
        }
        System.out.println("\n");
        
        //removeMiddle();
        array.removeMiddle();
        System.out.print("removeMiddle:");
        array.printArray();
        System.out.println("\n");
        
    }
}

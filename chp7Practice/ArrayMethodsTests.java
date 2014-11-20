public class ArrayMethodsTests
{
    public static void main(String[] args)
    {
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayMethods array = new ArrayMethods(values);
        
        //Original
        System.out.print("Original:");
        array.printArray();
        System.out.println("\n");
        
        //increasingOrder
        boolean inc1 = array.increasingOrder();
        System.out.println("increasingOrder: " + inc1 + "\n");
        
        //adjacentDuplicates
        boolean adj1 = array.adjacentDuplicates();
        System.out.println("adjacentDuplicates: " + adj1 + "\n");
        
        //duplicates
        boolean dup1 = array.duplicates();
        System.out.println("duplicates: " + dup1 + "\n");
        
        //swapFirstAndLast
        array.swapFirstAndLast();
        System.out.print("swapFirstAndLast:");
        array.printArray();
        System.out.println("\n");
        
        //shiftRight
        array.shiftRight();
        System.out.print("shiftRight:");
        array.printArray();
        System.out.println("\n");
        
        //evensToFront
        array.evensToFront();
        System.out.print("evensToFront:");
        array.printArray();
        System.out.println("\n");
        
        //evensToZero
        array.evensToZero();
        System.out.print("evensToZero:");
        array.printArray();
        System.out.println("\n");
        
        //replaceWithLargerNeighbor
        array.replaceWithLargerNeighbor();
        System.out.print("replaceWithLargerNeighbor:");
        array.printArray();
        System.out.println("\n");
        
        //duplicates
        boolean dup2 = array.duplicates();
        System.out.println("duplicates: " + dup2 + "\n");
        
        //removeMiddle
        array.removeMiddle();
        System.out.print("removeMiddle:");
        array.printArray();
        System.out.println("\n");
        
        //secondLargest
        int second = array.secondLargest();
        System.out.println("secondLargest: " + second + "\n");
        
        //increasingOrder
        boolean inc2 = array.increasingOrder();
        System.out.println("increasingOrder: " + inc2 + "\n");
        
        //adjacentDuplicates
        boolean adj2 = array.adjacentDuplicates();
        System.out.println("adjacentDuplicates: " + adj2 + "\n");
    }
}

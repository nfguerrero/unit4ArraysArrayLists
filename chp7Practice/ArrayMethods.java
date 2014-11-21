public class ArrayMethods
{
    private int[] values;
    
    public ArrayMethods(int[] initialValues)
    {
        this.values = initialValues;
    }
    
    public void printArray()
    {
        for(int i = 0; i < values.length; i ++)
        {
            System.out.print(" " + values[i]);
        }
    }
    
    public void swapFirstAndLast()
    {
        int temp = values[0];
        values[0] = values[values.length-1];
        values[values.length-1] = temp;
    }
    
    public void shiftRight()
    {
        int temp = values[values.length-1];
        for (int i = values.length-1; i > 0; i--)
        {
            values[i] = values[i-1];
        }
        values[0] = temp;
    }
    
    public void evensToZero()
    {
        for (int i = 0; i < values.length; i++)
        {
            if (values[i]%2 == 0)
            {
                values[i] = 0;
            }
        }
    }
    
    public void replaceWithLargerNeighbor()
    {
        int[] tempArray = new int[values.length];
        tempArray[0] = values[0];
        tempArray[values.length-1] = values[values.length-1];
        for (int i = 1; i < values.length - 1; i++)
        {
            if (values[i-1] > values[i+1])
            {
                tempArray[i] = values[i-1];
            }
            else
            {
                tempArray[i] = values[i+1];
            }
        }
        
        values = tempArray;
    }
    
    public void removeMiddle()
    {
        int type = 0;
        double mid = 0;
        if (values.length%2 != 0)
        {
            type = 1;
            mid = -.5;
        }
        else
        {
            type = 2;
            mid = 1;
        }
        
        int[] tempArray = new int[values.length - type];
        int i = 0;
        while (i != (int) ((values.length/2) - mid))
        {
            tempArray[i] = values[i];
            i++;
        }
        i += type;
        while (i < values.length)
        {
            tempArray[i-type] = values[i];
            i++;
        }
        
        values = tempArray;
    }
    
    public void evensToFront()
    {
        int[] tempArray = new int[values.length];
        int top = 0;
        int bottom = values.length - 1;
        
        for (int i = 0; i < values.length; i++)
        {
            if (values[i]%2 == 0)
            {
                tempArray[top] = values[i];
                top++;
            }
            else
            {
                tempArray[bottom] = values[i];
                bottom--;
            }
        }
        
        values = tempArray;
    }
    
    public int secondLargest()
    {
        int large = 0;
        int second = 0;
        
        for (int i = 0; i < values.length; i++)
        {
            if (values[i] >= large)
            {
                second = large;
                large = values[i];
            }
        }
        
        return second;
    }
    
    public boolean increasingOrder()
    {
        int previous = values[0];
        int i = 1;
        boolean increasing = true;
        boolean inc = true;
        
        while ((i < values.length) && (inc))
        {
            if (values[i] >= previous)
            {
                previous = values[i];
                if (i == values.length - 1)
                {
                    inc = false;
                }
            }
            else
            {
                increasing = false;
                inc = false;
            }
            i++;
        }
        
        return increasing;
    }
    
    public boolean adjacentDuplicates()
    {
        int previous = values[0];
        boolean adjacent = false;
        
        for (int i = 1; i < values.length; i++)
        {
            if (values[i] == previous)
            {
                adjacent = true;
            }
        }
        
        return adjacent;
    }
    
    public boolean duplicates()
    {
        int[] tempArray = values;
        boolean duplicate = false;
        
        for (int i = 0; i < values.length; i++)
        {
            for (int j = 0; j < tempArray.length; j++)
            {
                if ((values[i] == tempArray[j]) && (i != j))
                {
                    duplicate = true;
                }
            }
        }
        
        return duplicate;
    }
    
    
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

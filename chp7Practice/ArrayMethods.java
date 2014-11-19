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
        
        for (int i = 0; i < values.length; i++)
        {
            values[i] = tempArray[i];
        }
    }
    
    public void removeMiddle()
    {
        int type = 0;
        double mid = 0;
        if (values.length%2 != 0)
        {
            type = 1;
            mid = .5;
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
}

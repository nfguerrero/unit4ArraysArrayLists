public class ArrayMethods
{
    private int[] values;
    
    public ArrayMethods(int[] initialValues)
    {
        this.values = initialValues;
    }
    
    public void swapFirstAndLast()
    {
        int temp = values[0];
        values[0] = values[values.length-1];
        values[values.length-1] = temp;
    }
    
    public void shitRight()
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
        if (values.length%2 != 0)
        {
            int[] tempArray = new int[values.length - 1];
            int i = 0;
            while (i != (int) ((values.length%2) + .5))
            {
                tempArray[i] = values[i];
                i++;
            }
            i++;
            while (i < values.length)
            {
                tempArray[i-1] = values[i];
            }
        }
    }
}

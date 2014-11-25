import java.util.Scanner;

public class MagicSquares
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int[][] array = new int[4][4];
        
        for (int row = 0; row < 4; row++)
        {
            for (int col = 0; col < 4; col++)
            {
                System.out.print("Number: ");
                int num = scan.nextInt();
                array[row][col] = num;
            }
        }
        
        System.out.println("");
        
        for (int row = 0; row < 4; row++)
        {
            for (int col = 0; col < 4; col++)
            {
                String str = array[row][col] + "";
                if (str.length() == 2)
                {
                    System.out.print(array[row][col] + " ");
                }
                else
                {
                    System.out.print(array[row][col] + "  ");
                }
            }
            System.out.println("");
        }
        
        System.out.println("");
        
        int lastCol = 0;
        int nextCol = 0;
        int lastRow = 0;
        int nextRow = 0;
        boolean square = true;
        //Chekcs Columns
        for (int row = 0; row < 4; row++)
        {
            for (int col = 0; col < 4; col++)
            {
                nextCol += array[row][col];
                nextRow += array[col][row];
            }
            if (lastCol == 0)
            {
                lastCol = nextCol;
                lastRow = nextRow;
            }
            if ((nextCol != lastCol) || (nextRow != lastRow))
            {
                square = false;
            }
            
            lastCol = nextCol;
            lastRow = nextRow;
            nextCol = 0;
            nextRow = 0;
        }

        System.out.print("Magic Square: " + square);
    }
}

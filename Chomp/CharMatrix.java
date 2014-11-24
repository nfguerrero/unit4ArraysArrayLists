// Implements a 2-D array of characters

public class CharMatrix
{
  // Fields:
  private char[][] field;
  private int rows;
  private int cols;
  

  // Constructor: creates a grid with dimensions rows, cols,
  // and fills it with spaces
  public CharMatrix(int rows, int cols)
  {
    this.rows = rows;
    this.cols = cols;
    this.field = new char[rows][cols];
    
    for (int row = 0; row < rows; row++)
    {
        for (int col = 0; col < cols; col++)
        {
            field[row][col] = ' ';
        }
    }
  }

  // Constructor: creates a grid with dimensions rows , cols ,
  // and fills it with the fill  character
  public CharMatrix(int rows, int cols, char fill)
  {
    this.field = new char[rows][cols];
    this.rows = rows;
    this.cols = cols;
    
    for (int row = 0; row < rows; row++)
    {
        for (int col = 0; col < cols; col++)
        {
            field[row][col] = fill;
        }
    }
  }

  // Returns the number of rows in grid
  public int numRows()
  {
    return this.rows;
  }

  // Returns the number of columns in grid
  public int numCols()
  {
    return this.cols;
  }

  // Returns the character at row, col location
  public char charAt(int row, int col)
  {
    return field[row][col];
  }

  // Sets the character at row, col location to ch
  public void setCharAt(int row, int col, char ch)
  {
    field[row][col] = ch;
  }

  // Returns true if the character at row, col is a space,
  // false otherwise
  public boolean isEmpty(int row, int col)
  {
    if (field[row][col] == ' ')
    {
        return true;
    }
    else
    {
        return false;
    }
  }

  // Fills the given rectangle with fill  characters.
  // row0, col0 is the upper left corner and row1, col1 is the
  // lower right corner of the rectangle.
  public void fillRect(int row0, int col0, int row1, int col1, char fill)
  {
    for (int row = row0; row <= row1; row++)
    {
        for (int col = col0; col <= col1; col++)
        {
            field[row][col] = fill;
        }
    }
  }

  // Fills the given rectangle with SPACE characters.
  // row0, col0 is the upper left corner and row1, col1 is the
  // lower right corner of the rectangle.
  public void clearRect(int row0, int col0, int row1, int col1)
  {
    for (int row = row0; row <= row1; row++)
    {
        for (int col = col0; col <= col1; col++)
        {
            field[row][col] = ' ';
        }
    }
  }

  // Returns the count of all non-space characters in row 
  public int countInRow(int row)
  {
    int count = 0;
    for (char i : field[row])
    {
        if (i != ' ')
        {
            count++;
        }
    }
    return count;
  }

  // Returns the count of all non-space characters in col 
  public int countInCol(int col)
  {
    int count = 0;
    for (char[] row : field)
    {
        if (row[col] != ' ')
        {
            count++;
        }
    }
    return count;
  }
}

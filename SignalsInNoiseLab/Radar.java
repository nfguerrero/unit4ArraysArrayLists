
/**
 * The model for radar scan and accumulator
 * 
 * @author @gcschmit
 * @version 19 July 2014
 */
public class Radar
{
    // stores whether each cell triggered detection for the old scan of the radar
    private boolean[][] oldScan;
    
    // stores whether each cell triggered detection for the current scan of the radar
    private boolean[][] currentScan;
    
    // value of each cell is incremented for each scan in which that cell triggers detection 
    private int[][] accumulator;
    
    //all possible vector changes
    private int[][] vectors;
    
    //accumulator of all possible vectors;
    private int[][] vectorAccumulator;
    
    // location of the monster
    private int monsterLocationRow;
    private int monsterLocationCol;
    
    //previous monsterLocation
    private int oldRow;
    private int oldCol;

    // probability that a cell will trigger a false detection (must be >= 0 and < 1)
    private double noiseFraction;
    
    // number of scans of the radar since construction
    private int numScans;

    /**
     * Constructor for objects of class Radar
     * 
     * @param   rows    the number of rows in the radar grid
     * @param   cols    the number of columns in the radar grid
     */
    public Radar(int rows, int cols)
    {
        // initialize instance variables
        oldScan = new boolean[rows][cols]; // elements will be set to flase
        currentScan = new boolean[rows][cols]; // elements will be set to false
        accumulator = new int[rows][cols]; // elements will be set to 0
        vectorAccumulator = new int[11][11]; // elements will be set to 0, 0-5 for possible row/col of vector
        
        // randomly set the location of the monster (can be explicity set through the
        //  setMonsterLocation method
        monsterLocationRow = (int)(Math.random() * rows);
        monsterLocationCol = (int)(Math.random() * cols);
         
        noiseFraction = .05;
        numScans= 0;
    }
    
    /**
     * Performs a scan of the radar. Noise is injected into the grid and the accumulator is updated.
     * 
     */
    public void scan()
    {
        // zero the current scan grid
        for(int row = 0; row < currentScan.length; row++)
        {
            for(int col = 0; col < currentScan[0].length; col++)
            {
                currentScan[row][col] = false;
            }
        }
        
        // detect the monster
        currentScan[monsterLocationRow][monsterLocationCol] = true;
        
        // inject noise into the grid
        injectNoise();
        
        // udpate the accumulator
        for(int row = 0; row < currentScan.length; row++)
        {
            for(int col = 0; col < currentScan[0].length; col++)
            {
                if(currentScan[row][col] == true)
                {
                   accumulator[row][col]++;
                }
            }
        }
        
        // does stuff i told it too... (hopefully i change this later)
        for (int oldRow = 0; oldRow < currentScan.length; oldRow++)
        {
            for (int oldCol = 0; oldCol < currentScan[0].length; oldCol++)
            {
                for (int newRow = 0; newRow < currentScan.length; newRow++)
                {
                    for (int newCol = 0; newCol < currentScan[0].length; newCol++)
                    {
                        if ((oldScan[oldRow][oldCol] && currentScan[newRow][newCol]) 
                            && (newRow-oldRow <= 5) && (newRow-oldRow >= -5)
                            && (newCol-oldCol <= 5) && (newCol-oldCol >= -5))
                        {
                            vectorAccumulator[newRow-oldRow+5][newCol-oldCol+5]++;
                        }
                    }
                }
            }
        }
        
        // makes oldScan = currentScan
        for (int row = 0; row < currentScan.length; row++)
        {
            for (int col = 0; col < currentScan.length; col++)
            {
                oldScan[row][col] = currentScan[row][col];
            }
        }
        
        // keep track of the total number of scans
        numScans++;
    }
    
    /**Updates the visual to show the monster's location
     * 
     */
    public void updateVisualizer(int dx, int dy, int scans)
    {
        accumulator[oldRow][oldCol] = (int) (Math.random()*scans/5);
        accumulator[monsterLocationRow][monsterLocationCol] = numScans; 
        
        oldRow = monsterLocationRow;
        oldCol = monsterLocationCol;
    }
    
    /**
     * Gets the vector of the monster
     * 
     * @returns the vector of the monster as an array[dx, dy]
     */
    public int[] getMonsterVector()
    {
        int[] vector = new int[2];
        int topVector = 0;
        
        for (int row = 0; row < vectorAccumulator.length; row++)
        {
            for (int col = 0; col < vectorAccumulator.length; col++)
            {
                if (vectorAccumulator[row][col] > topVector)
                {
                    topVector = vectorAccumulator[row][col];
                    vector[0] = col-5;
                    vector[1] = row-5;
                }
            }
        }
        
        return vector;
    }

    /**
     * Sets the location of the monster
     * 
     * @param   row     the row in which the monster is located
     * @param   col     the column in which the monster is located
     * @pre row and col must be within the bounds of the radar grid
     */
    public void setMonsterLocation(int row, int col)
    {
        // remember the row and col of the monster's location
        monsterLocationRow = row;
        monsterLocationCol = col;
        
        // update the radar grid to show that something was detected at the specified location
        currentScan[row][col] = true;
    }
    
     /**
     * Sets the probability that a given cell will generate a false detection
     * 
     * @param   fraction    the probability that a given cell will generate a flase detection expressed
     *                      as a fraction (must be >= 0 and < 1)
     */
    public void setNoiseFraction(double fraction)
    {
        noiseFraction = fraction;
    }
    
    /**
     * Returns true if the specified location in the radar grid triggered a detection.
     * 
     * @param   row     the row of the location to query for detection
     * @param   col     the column of the location to query for detection
     * @return true if the specified location in the radar grid triggered a detection
     */
    public boolean isDetected(int row, int col)
    {
        return currentScan[row][col];
    }
    
    /**
     * Returns the number of times that the specified location in the radar grid has triggered a
     *  detection since the constructor of the radar object.
     * 
     * @param   row     the row of the location to query for accumulated detections
     * @param   col     the column of the location to query for accumulated detections
     * @return the number of times that the specified location in the radar grid has
     *          triggered a detection since the constructor of the radar object
     */
    public int getAccumulatedDetection(int row, int col)
    {
        return accumulator[row][col];
    }
    
    /**
     * Returns the number of rows in the radar grid
     * 
     * @return the number of rows in the radar grid
     */
    public int getNumRows()
    {
        return currentScan.length;
    }
    
    /**
     * Returns the number of columns in the radar grid
     * 
     * @return the number of columns in the radar grid
     */
    public int getNumCols()
    {
        return currentScan[0].length;
    }
    
    /**
     * Returns the number of scans that have been performed since the radar object was constructed
     * 
     * @return the number of scans that have been performed since the radar object was constructed
     */
    public int getNumScans()
    {
        return numScans;
    }
    
    /**
     * Sets cells as falsely triggering detection based on the specified probability
     * 
     */
    private void injectNoise()
    {
        for(int row = 0; row < currentScan.length; row++)
        {
            for(int col = 0; col < currentScan[0].length; col++)
            {
                // each cell has the specified probablily of being a false positive
                if(Math.random() < noiseFraction)
                {
                    currentScan[row][col] = true;
                }
            }
        }
    }
    
}

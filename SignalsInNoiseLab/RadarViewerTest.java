import javax.swing.JFrame;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Write a description of test class RadarViewerTest here.
 * 
 * @author nfguerrero
 * @version 12/15/2014
 */
public class RadarViewerTest
{
    /**
     * Default constructor for objects of class RadarViewerTest
     */
    public RadarViewerTest()
    {
    }
    
    @Test
    public void testMonsterVector() throws InterruptedException
    {
         // create the radar, set the monster location, and perform the initial scan
        final int ROWS = 100;
        final int COLS = 100;
        Radar radar = new Radar(ROWS, COLS);
        radar.scan();
        
        // sets variables
        int row = 49;
        int col = 49;
        int dx = -1;
        int dy = 1;
        radar.setNoiseFraction(.01);
        
        radar.setMonsterLocation(col, row);
        
        // little waiting icon thing...
        System.out.println("\nCalculating...\n");
        
        // perform 100 scans of the radar wiht a slight pause between each
        // after each scan, instruct the Java Run-Time to redraw the window
        for(int i = 0; i < 30; i++)
        {
            Thread.sleep(10); // sleep 100 milliseconds (1/10 second)

            radar.setMonsterLocation(col, row);
            
            radar.scan();
            
            row += dx;
            if (row >= ROWS)
            {
                row = row-ROWS;
            }
            else if (row < 0)
            {
                row = ROWS+row;
            }
            col += dy;
            if (col >= COLS)
            {
                col = col-COLS;
            }
            else if (col < 0)
            {
                col = COLS+col;;
            }
        }
        
        assertEquals(dx, radar.getMonsterVector()[0]);
        assertEquals(dy, radar.getMonsterVector()[1]);
    }
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

}

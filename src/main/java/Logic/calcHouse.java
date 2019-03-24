package Logic;

import Logic.DTO.Bricks;

/**
 * handling all brick-amount calculations
 * 
 * @author martin
 */
public class calcHouse
{

    /**
     * first very rudimentary calculation try
     * no pattern, no window, no door
     * 
     * @param length
     * @param bricks
     * @return 
     */
    private static Bricks calcSide(int length, Bricks bricks)
    {

        bricks.addFourBricks(length / 4);
        int rem = length % 4;

        bricks.addTwoBricks(rem / 2);
        rem = rem % 2;

        bricks.addTwoBricks(rem);
        return bricks;
    }

    /**
     * 
     * @param length
     * @param width
     * @param height
     * @return 
     */
    public static Bricks calc(int length, int width, int height)
    {
        Bricks bricks = new Bricks();
        // minus two because next wallside start at end of this side
        int longSide = length - 2;
        int shortSide = width - 2;

        for (int i = 1; i <= height; i++)
        {
            bricks = calcSide(longSide, bricks);
            bricks = calcSide(longSide, bricks);
            bricks = calcSide(shortSide, bricks);
            bricks = calcSide(shortSide, bricks);
        }
        return bricks;
    }
}

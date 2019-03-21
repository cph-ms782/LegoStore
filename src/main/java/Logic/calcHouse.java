package Logic;

import Logic.DTO.Bricks;

/**
 *
 * @author martin
 */
public class calcHouse
{

    public static Bricks calcSide(int length)
    {
        Bricks bricks = new Bricks();
        
        bricks.addFourBricks(length / 4);
        int rem = length % 4;

        bricks.addTwoBricks(rem / 2);
        rem = rem % 2;

        bricks.addTwoBricks(rem);
        return bricks;
    }

    public static void calc(int length, int width, int height)
    {
        // minus two because next wallside start at end of this side
        int longSide = length - 2;
        int shortSide = width - 2;

        for (int i = 1; i <= height; i++)
        {
            calcSide(longSide);
            calcSide(longSide);
            calcSide(shortSide);
            calcSide(shortSide);
        }

    }

    public static void main(String[] args)
    {
        new calcHouse().calc(21, 10, 5);
    }
}

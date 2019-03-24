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
     * first very rudimentary calculation try no pattern, no window, no door
     *
     * @param length
     * @param bricks
     * @return Bricks object containing the updated values
     */
    private static Bricks calcSide(int distance, Bricks bricks)
    {

        bricks.addFourBricks(distance / 4);
        int rem = distance % 4;

        bricks.addTwoBricks(rem / 2);
        rem = rem % 2;

        bricks.addOneBricks(rem);
        return bricks;
    }

    /**
     * second try calculating items
     * 
     * @param emptyspaceWidth (door or window space)
     * @param offset          (distance from start that the placement of the next layer bricks is placed at)
     * @param distance        (distance that needs calculating)
     * @param bricks          (Bricks object. Contains the lineitem values)
     * @return Bricks object containing the updated values
     */
    private static Bricks calcSide(int emptyspaceWidth, int offset, int distance, Bricks bricks)
    {

//      Handle offset. The distance a brick is placed from the starting position. This area also need to be filled with a brick
        switch (offset)
        {
            case 4:
                bricks.addFourBricks(1);
                break;

            case 3:
                bricks.addTwoBricks(1);
                bricks.addOneBricks(1);
                break;

            case 2:
                bricks.addFourBricks(1);
                break;

            case 1:
                bricks.addOneBricks(1);
                break;

            default:
                break;
        }

//      it assumed the door/window starts right next to adjacent wall
        distance = distance - offset - emptyspaceWidth;

//      calculate how many 4-bricks can fit into distance
        bricks.addFourBricks(distance / 4);
        int rem = distance % 4;

//      calculate how many 2-bricks can fit into leftover distance
        bricks.addTwoBricks(rem / 2);
        rem = rem % 2;

//      leftover 1-brick
        bricks.addOneBricks(rem);
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
        // intermingling of the two sides bricks is not being considered
        int longSide = length - 2;
        int shortSide = width - 2;
        int windowWidth = 4;
        int doorWidth = 4;
        int doorHeight = 6;

        for (int i = 1; i <= height; i++)
        {
            int offset = 2;
            if (i == 1) //first layer of bricks.. only the door area do not need bricks
            {
                bricks = calcSide(doorWidth, 0, longSide, bricks); //door side
                bricks = calcSide(0, 0, shortSide, bricks);
                bricks = calcSide(0, 0, longSide, bricks);//window side
                bricks = calcSide(0, 0, shortSide, bricks);
                
            } else if (i > 1 && i <= doorHeight) // from second to height of door layer. Here the window also doesnt need bricks
            {
                
                if (i % 2 == 0) // even layers has an offset dictated by the type of brick pattern
                {
                    bricks = calcSide(doorWidth, offset, longSide, bricks); //door side
                    bricks = calcSide(0, offset, shortSide, bricks);
                    bricks = calcSide(windowWidth, offset, longSide, bricks);//window side
                    bricks = calcSide(0, offset, shortSide, bricks);
                    
                } else //uneven layer
                {
                    bricks = calcSide(doorWidth, 0, longSide, bricks); //door side
                    bricks = calcSide(0, 0, shortSide, bricks);
                    bricks = calcSide(windowWidth, 0, longSide, bricks);//window side
                    bricks = calcSide(0, 0, shortSide, bricks);
                }
                
            } else //layers above door and window
            {
                bricks = calcSide(0, 0, longSide, bricks); //door side
                bricks = calcSide(0, 0, shortSide, bricks);
                bricks = calcSide(0, 0, longSide, bricks);//window side
                bricks = calcSide(0, 0, shortSide, bricks);
            }
        }
        return bricks;
    }
}

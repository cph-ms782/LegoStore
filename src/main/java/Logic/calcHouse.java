package Logic;

/**
 *
 * @author martin
 */
public class calcHouse
{

    int fourBrick = 0;
    int twoBrick = 0;
    int oneBrick = 0;

    public void calcSide(int length)
    {
        fourBrick += length / 4;
        int rem = length % 4;
        System.out.println("4-Brick, remainder: " + fourBrick + ", " + rem);

        twoBrick += rem / 2;
        rem = rem % 2;
        System.out.println("2-Brick, remainder: " + twoBrick + ", " + rem);

        oneBrick += rem;
        System.out.println("1-Brick, remainder: " + oneBrick + ", " + 0);
    }

    public void calc(int length, int width, int height)
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

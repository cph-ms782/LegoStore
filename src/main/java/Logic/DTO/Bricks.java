package Logic.DTO;

/**
 *
 * @author martin
 */
public class Bricks
{
    private int fourBrick = 0;
    private int twoBrick = 0;
    private int oneBrick = 0;
//    private int 

    public Bricks()
    {
    }

    public int getFourBrick()
    {
        return fourBrick;
    }

    public int getTwoBrick()
    {
        return twoBrick;
    }

    public int getOneBrick()
    {
        return oneBrick;
    }

    public void addFourBricks(int fourBrick)
    {
        this.fourBrick += fourBrick;
    }

    public void addTwoBricks(int twoBrick)
    {
        this.twoBrick += twoBrick;
    }

    public void addOneBricks(int oneBrick)
    {
        this.oneBrick += oneBrick;
    }
    
}

public class FrogSimulation
{
    private int goalDistance;
    private int maxHops;

    public FrogSimulation(int dist, int numHops)
    {
        goalDistance = dist;
        maxHops = numHops;
    }

    private int hopDistance()
    {
        if (Math.random() < 0.75)
        {
            return (int) (Math.random() * 10) + 1;
        }
        return ((int) (Math.random() * 5) + 1) * -1;
    }

    public boolean simulate()
    {
        int position = 0;
        for (int i = 0; i < maxHops; i++)
        {
            position += hopDistance();
            if (position < 0)
            {
                return false;
            }
            if (position >= goalDistance)
            {
                return true;
            }
        }
        return false;
    }

    public double runSimulations(int num)
    {
        int success = 0;
        for (int i = 0; i < num; i++)
        {
           if (simulate() == true)
           {
               success++;
           }
        }
        return (double) success / num;
    }
}

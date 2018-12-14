/**
 * This class creates a Guitar String with the given frequency.
 * 
 * I pledge my honor that I have abided by the Stevens Honor System.
 * 
 * @author Sam Pelton
 */ 

public class GuitarString
{
    private RingBuffer buffer;
    private static final int samplingRate = 44100;
    private int n;
    private static final double energyDecayFactor = 0.996;
    private int ticCount;

    public GuitarString(double frequency)
    {
    n = (int) Math.round(samplingRate / frequency);
    buffer= new RingBuffer(n);
    ticCount = 0;
    
    for ( int i = 0; i < n; i++ )
    {
        buffer.enqueue(0);
    }
    }

    public GuitarString(double[] init)
    {
    buffer = new RingBuffer(init.length);

    for ( int i = 0; i < init.length; i++ )
        {
        buffer.enqueue(init[i]);
        }
    ticCount = 0;
    }

    public void pluck()
    {
        for ( int i = 0; i < n; i++ )
        {
            buffer.dequeue();
        }
        
        for ( int i = 0; i < n; i++ )
        {
        buffer.enqueue(Math.random() - 0.5);
        }
    }

    public void tic()
    {
    double tic = ( buffer.dequeue() + buffer.peek() ) / 2 * energyDecayFactor;

    buffer.enqueue(tic);
    
    tic++;
    }

    public double sample()
    {
    return buffer.peek();
    }

    public int time()
    {
    return ticCount;
    }
}

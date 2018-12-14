/**
 * This class is used to run the Guitar Hero program.
 * 
 * I pledge my honor that I have abided by the Stevens Honor System.
 * 
 * @author Sam Pelton
 */

public class GuitarHero
{
    public static void main(String args[])
    {
    GuitarString[] strings = new GuitarString[37];
    String keyboard = "1234567890qwertyuiopasdfghjklzxcvbnm,";

    for ( int i = 0; i < strings.length; i++ )
        {
        strings[i] = new GuitarString(440.0 * Math.pow(2,(i-24)/12.0));
        }

    while(true)
        {
        if(StdDraw.hasNextKeyTyped())
            {
            char key = StdDraw.nextKeyTyped();
            if ( keyboard.indexOf(key) != -1 )
            {
                int index = keyboard.indexOf(key);
                strings[index].pluck();
             }


            }

        double sample = 0;

        for ( int i = 0; i < strings.length; i++ )
            {
            sample += strings[i].sample();
            }

        StdAudio.play(sample);

        for( int i = 0; i < strings.length; i++ )
            {
            strings[i].tic();
            }
        }
    }
}

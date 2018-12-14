
/**
 * BinaryPeriodicFractions.java
 * 
 * "I pledge my honor that I have abided by the Stevens Honor System."
 * 
 * This class takes as input a String representing a binary number
 * that can be fractional and even periodic. The portion of the 
 * String preceding the decimal point represents the integral
 * component, the portion between the decimal point and the
 * underscore represents the antiperiod or non-repeating
 * fractional value, and the part following the underscore
 * represents the periodic or repeating portion of the number. The
 * program prints the value of this binary number in "x.y + a/b"
 * format, in decimal form.
 * 
 * @author Sam Pelton
 */
public class BinaryPeriodicFractions
{
    public static void main(String args[])
    {
        //separate components
        String integral = "";
        String antiperiod = "";
        String period = "";
        
        boolean dot = false;
        boolean underscore = false;
        
        for ( int i = 0; i < args[0].length(); i++ )
        {
            if ( !underscore )
            {
                if ( !dot )
                {
                    if ( !args[0].substring( i, i + 1 ).equals(".") )
                    {
                        integral += args[0].substring( i, i + 1 );
                    }
                    else
                    {
                        dot = true;
                    }
                }
                else
                {
                    if ( !args[0].substring( i, i + 1 ).equals("_") )
                    {
                        antiperiod += args[0].substring( i, i + 1 );
                    }
                    else
                    {
                        underscore = true;
                    }
                }
            }
            else
            {
                period += args[0].substring( i, i + 1 );
            }
        }
        
        int integer = 0;
        
        for ( int i = 0; i < integral.length(); i++ )   //sets correct value of integer
        {
            integer += Integer.parseInt(integral.substring(i, i+1)) * Math.pow(2, integral.length() - 1 - i);
        }
        
        double fractionWithoutPeriod = 0;
        
        for ( int i = 0; i < antiperiod.length(); i++ ) //calculates value of fraction component without considering periodic portion
        {
            fractionWithoutPeriod += Integer.parseInt(antiperiod.substring(i,i+1)) * Math.pow(2, -1 * i - 1);
        }
        
        int sumOfPeriodicBits = period.length();
        int denominator = (int) Math.pow( 2, sumOfPeriodicBits + antiperiod.length()) - (int) Math.pow(2, antiperiod.length()); //calculates denominator of fraction
        
        //calculates numerator of fraction
        int numerator = 0;
        for ( int i = 0; i < sumOfPeriodicBits; i++ )
        {
            numerator += Integer.parseInt(period.substring(i,i+1)) * Math.pow( 2, period.length() - 1 - i);
        }
        //prints final number
        System.out.println( ( integer + fractionWithoutPeriod ) + " + " + numerator + "/" + denominator);
    }
}

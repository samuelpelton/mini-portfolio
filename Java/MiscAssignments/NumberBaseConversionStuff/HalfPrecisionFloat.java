
/**
 * HalfPrecisionFloat.java
 * 
 * "I pledge my honor that I have abided by the Stevens Honor System."
 * 
 * This program takes a String representing a 16-bit floating point
 * binary number as input and prints its value in decimal form.
 * 
 * @author Sam Pelton
 */
public class HalfPrecisionFloat
{
    public static void main(String args[])
    {
        final int BIAS = 15; //(2^(k-1)) - 1, k = 5
        if ( args[0].length() != 16 ) //if input is not 16 bits
        {
            System.out.println("Invalid Input");
        }
        else
        {
            //separating components
            String signBit = args[0].substring(0,1);
            String exponent = args[0].substring(1,6);
            String mantissa = args[0].substring(6);
            
            //restore mantissa decimal point
            mantissa = "1." + mantissa;
            double restoredMantissa = Double.parseDouble(mantissa);
            
            //calculate exponent
            int exponentInDecimal = 0;
            for ( int i = 0; i < 5; i++ )
            {
                exponentInDecimal += Integer.parseInt(exponent.substring(i,i+1)) * Math.pow(2, 4 - i);
            }
            //calculate exponent considering bias
            int exponentMinusBias = exponentInDecimal - BIAS;
            
            //completely restore mantissa
            restoredMantissa = restoredMantissa * Math.pow(10, exponentMinusBias);
            
            String binaryWithDecimalPoint = restoredMantissa + "";
            String binaryWholeDigits = "";
            String binaryFractionalDigits = "";
            
            //add all of the digits before the decimal point to binaryWholeDigits
            int count = 0;
            while ( count < binaryWithDecimalPoint.length() && !binaryWithDecimalPoint.substring(count, count + 1).equals(".") )
            {
                binaryWholeDigits += binaryWithDecimalPoint.substring(count, count + 1);
                
                count++;
            }
            count++;
            //add all of the digits after the decimal point to binaryFractionalDigits
            while ( count < binaryWithDecimalPoint.length() )
            {
                binaryFractionalDigits += binaryWithDecimalPoint.substring(count, count + 1);
                
                count++;
            }
            
            int wholeDecimalTotal = 0;
            double fractionalDecimalTotal = 0;
            
            //calculate whole component of number
            for ( int i = 0; i < binaryWholeDigits.length(); i++ )
            {
                wholeDecimalTotal += Integer.parseInt(binaryWholeDigits.substring(i,i+1)) * Math.pow(2, binaryWholeDigits.length() - 1 - i);
            }
            //calculate fractional component of number
            for ( int i = 0; i < binaryFractionalDigits.length(); i++ )
            {
                fractionalDecimalTotal += Double.parseDouble(binaryFractionalDigits.substring(i,i+1)) * Math.pow(2, -1 * i - 1);
            }
            //add whole component with fractional component
            double converted = wholeDecimalTotal + fractionalDecimalTotal;
            //account for sign bit
            if ( signBit.equals("1") )
            {
                converted *= -1;
            }
            //print final number
            System.out.println(converted);
        }
    }
}

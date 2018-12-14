
/**
 * 
 */
public class NegabinaryToDecimal
{
    public static void main(String args[])
    {
        String input = args[0];
        String baseNeg2 = args[0];
        int base10 = 0;
        
        for ( int i = 0; i < baseNeg2.length(); i++ )
        {
            if ( baseNeg2.charAt(baseNeg2.length()-1-i ) == '1' )
            {
                base10 += Math.pow(-2, i);
            }
        }
        
        System.out.println(base10);
    }
}

/**
 * Cryptography.java
 * 
 * "I pledge my honor that I have abided by the Stevens Honor System."
 * 
 * This program takes a String literal as a parameter, encrypts it
 * based on an XOR cipher, prints the encrypted String, restores 
 * it to its orignial form using the cipher, and then prints the 
 * original message again.
 * 
 * @author Sam Pelton
 */
import java.util.Random;
public class Cryptography
{
    public static void main(String args[])
    {
        String message = args[0];
        int[] messageInASCIIDecimal = new int[message.length()];
    
        for ( int i = 0; i < messageInASCIIDecimal.length; i++ )
        {
            messageInASCIIDecimal[i] = (int) message.charAt(i);
        }
        
        String [] messageInASCIIBinary = new String[messageInASCIIDecimal.length];
        for ( int i = 0; i < messageInASCIIBinary.length; i++ )
        {
            messageInASCIIBinary[i] = "";
        }
        
         for ( int i = 0; i < messageInASCIIBinary.length; i++ )
         {
             for ( int j = 7; j >= 0; j-- )
             {
                 if ( messageInASCIIDecimal[i] >= Math.pow(2, j) )
                 {
                     messageInASCIIBinary[i] += 1;
                     messageInASCIIDecimal[i] -= Math.pow(2,j);
                 }
                 else
                 {
                     messageInASCIIBinary[i] += 0;
                 }
             }
         }
        
        byte[] randomByte = new byte[1];
        
        Random rand = new Random();
        
        rand.nextBytes(randomByte);
        randomByte[0] = (byte) Math.abs(randomByte[0]);
        System.out.println();
        String random = "";
        
        for ( int i = 7; i >= 0; i-- )
        {
            if ( randomByte[0] >= Math.pow(2, i) )
            {
                random += 1;
                randomByte[0] -= Math.pow(2, i);
            }
            else
            {
                random += 0;
            }
        }
        
        System.out.println("XOR Cipher: " + random);
        
        String[] encrypted = new String[messageInASCIIBinary.length];
        
        for ( int i = 0; i < messageInASCIIBinary.length; i++ )
        {
            encrypted[i] = "";
            for ( int j = 0; j < 8; j++ )
            {
                if ( ( Integer.parseInt(messageInASCIIBinary[i].substring(j,j+1)) != Integer.parseInt(random.substring(j,j+1)) ) ) 
                {
                    encrypted[i] += 1;
                }
                else
                {
                    encrypted[i] += 0;
                }
            }
        }
        
        for ( int i = 0; i < encrypted.length; i++ )
        {
            encrypted[i] = "" + binaryToDecimal(encrypted[i]);
        }
        
        System.out.println("Encrypted Message:");
        for ( int i = 0; i < encrypted.length; i++ )
        {
            System.out.print((char) Integer.parseInt(encrypted[i]));
        }
        System.out.println();
        
        for ( int i = 0; i < encrypted.length; i++ )
        {
            encrypted[i] = decimalToBinary(encrypted[i]);
        }
        
        String[] original = new String[encrypted.length];
        
        for ( int i = 0; i < original.length; i++ )
        {
            original[i] = "";
            for ( int j = 0; j < 8; j++ )
            {
                if ( ( Integer.parseInt(encrypted[i].substring(j,j+1)) != Integer.parseInt(random.substring(j,j+1)) ) ) 
                {
                    original[i] += 1;
                }
                else
                {
                    original[i] += 0;
                }
            }
        }
        System.out.println("Original Message: ");
        for ( int i = 0; i < original.length; i++ )
        {
            System.out.print((char) binaryToDecimal(original[i]));
        }
    }
    
    public static int binaryToDecimal(String binary)
    {
        int decimal = 0;
        for ( int i = binary.length() - 1; i >= 0; i-- )
        {
            if ( binary.substring(i, i+1).equals("1") )
            {
                decimal += Math.pow(2, binary.length() - 1 - i);
            }
        }
        
        return decimal;
    }
    
    public static String decimalToBinary(String decimal)
    {
        int x = Integer.parseInt(decimal);
        String binary = "";
        for ( int i = 0; i < 8; i++ )
        {
            if ( x >= Math.pow(2, 7 - i ))
            {
                binary += 1;
                x -=  Math.pow(2, 7-i);
            }
            else
            {
                binary+= 0;
            }
        }
        
        return binary;
    }
}

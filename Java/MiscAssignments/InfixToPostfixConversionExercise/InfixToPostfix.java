package week8;

public class InfixToPostfix
{
    public static void main(String args[])
    {
	String infix = args[0];
	Stack stack = new Stack(infix.length());
	String postfix = "";

	infix = infix.replaceAll("\\s","");

	for ( int i = 0; i < infix.length(); i++ )
	    {
		if ( !isOperator(infix.charAt(i)) )
		    {
			postfix += infix.charAt(i);

			if ( i == infix.length() - 1 ||  isOperator( infix.charAt(i+1) ) )
			    {
				postfix += " ";
			    }
		    }
		else
		    {
			if ( stack.empty() )
			    {
				stack.push(infix.charAt(i));
			    }
			else
			    {
				if ( infix.charAt(i) == ')' )
				    {
					while ( stack.peek() != '(' )
					    {
						postfix += stack.pop();
						postfix += " ";
					    }
					stack.pop();
				    }
				else
				    {
					if ( precedence(infix.charAt(i)) < 
					     precedence(stack.peek()) ||
					     stack.peek() == '(' )
					    {
						stack.push(infix.charAt(i));
					    }
					else
					    {
						while ( ! stack.empty() &&
						        precedence(infix.charAt(i)) >=
							precedence(stack.peek()) &&
							stack.peek() != '(' )
						    {
							postfix += stack.pop();
							postfix += " ";
						    }
						stack.push(infix.charAt(i));
					    }
				    }
			    }
		    }
	    }
	while ( !stack.empty() )
	    {
		postfix += stack.pop();
		postfix += " ";
	    }

	System.out.println(postfix);
    }

    public static int  precedence( char operator )
    {
        if ( operator == '(' || operator == ')' )
	    {
		return 1;
	    }
	if ( operator == '*' || operator == '/' )
	    {
		return 2;
	    }
	if ( operator == '+' || operator == '-' )
	    {
		return 3;
	    }
	else
	    {
		System.out.println("invalid operator");
		return -1;
	    }
    }

    public static boolean isOperator(char input)
    {
       	if ( input != '(' &&
	     input != ')' &&
	     input != '+' &&
	     input != '-' &&
	     input != '*' &&
	     input != '/' )
	    {
		return false;
	    }
	else
	    {
		return true;
	    }
    }
}

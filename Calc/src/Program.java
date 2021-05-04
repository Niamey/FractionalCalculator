import java.io.*;

public class Program
{
	
	private static InputStreamReader converter = new InputStreamReader(System.in);
	private static BufferedReader in = new BufferedReader(converter);

	public static void main(String [] args)
	{
		
		Fraction a = GetFraction("Enter first fraction: ");
		Fraction b = GetFraction("Enter second fraction: ");
		
		DoOperation(a, b);
	}
	
	private static Fraction GetFraction(String message)
	{
		String[] parts;
		
		System.out.println(message);
		String str = "";

		try
		{
			str = in.readLine();
		}
		catch (Exception e)
		{
			System.out.println("Error! Exception: " + e);
			return null;
		}
		
		if (str.contains("/"))
		{
			parts = str.split("/");
		}
		else
		{
		    throw new IllegalArgumentException("String " + str + " does not contain /");
		}

		return new Fraction(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
	}
	
	private static void DoOperation(Fraction a, Fraction b)
	{
		if(a == null || b == null)
			throw new IllegalArgumentException("argument is null");
		
		System.out.println("Enter operation: ");
		
		String str = "";

		try
		{
			str = in.readLine().trim();
		}
		catch (Exception e)
		{
			System.out.println("Error! Exception: " + e);
			return;
		}
		
		if(str.equals("+"))
			System.out.println(a.toString() + " + " + b.toString() + " = " + Fraction.Reduction(Fraction.add(a, b)).toString());
		else if(str.equals("-"))
			System.out.println(a.toString() + " - " + b.toString() + " = " + Fraction.Reduction(Fraction.sub(a, b)).toString());
		else if(str.equals("*"))
			System.out.println(a.toString() + " * " + b.toString() + " = " + Fraction.Reduction(Fraction.mul(a, b)).toString());
		else if(str.equals("/"))
			System.out.println(a.toString() + " / " + b.toString() + " = " + Fraction.Reduction(Fraction.div(a, b)).toString());
		else
			throw new IllegalArgumentException("Illegal operator");
	}
}

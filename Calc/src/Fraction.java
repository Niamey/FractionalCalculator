
public class Fraction
{
	public int numerator = 0;
	public int denominator = 0;
	
	public Fraction(int numerator, int denominator)
	{
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	@Override public String toString()
	{
		return Integer.toString(numerator) + "/" + Integer.toString(denominator);
	}
	
	public static Fraction add(Fraction a, Fraction b)
	{
		Fraction t = new Fraction(1, 1);
		t.numerator = (a.numerator * b.denominator + a.denominator * b.numerator);
		t.denominator = a.denominator * b.denominator;
		Fraction.Reduction(t);
		return t;
	}
	
	public static Fraction sub(Fraction a, Fraction b)
	{
		Fraction t = new Fraction(1, 1);
		t.numerator = (a.numerator * b.denominator - a.denominator * b.numerator);
		t.denominator = a.denominator * b.denominator;
		Fraction.Reduction(t);
		return t;	
	}
    
	public static Fraction mul(Fraction a, Fraction b)
	{
		Fraction t = new Fraction(1, 1);
		t.numerator = a.numerator * b.numerator;
		t.denominator = a.denominator * b.denominator;
		Fraction.Reduction(t);
		return t;
	}
	
    public static Fraction div(Fraction a, Fraction b)
    {
    	Fraction t = new Fraction(1, 1);
    	t.numerator = a.numerator * b.denominator;
    	t.denominator = a.denominator * b.numerator;
    	Fraction.Reduction(t);
    	return t;
    }
	
	public static Fraction Reduction(Fraction f)
	{
		int max = Math.max(f.numerator, f.denominator);
		
		for (int i = max; i >= 2; i--)
			{
				if ((f.numerator % i == 0) & (f.denominator % i == 0))
				{
					f.numerator = f.numerator / i;
					f.denominator = f.denominator / i;
				}
			}

		if ((f.denominator < 0))
			{
				f.numerator = -1 * (f.numerator);
				f.denominator = Math.abs(f.denominator);
			}
		return (f);
	}
}

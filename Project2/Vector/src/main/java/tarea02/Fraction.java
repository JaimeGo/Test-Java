package tarea02;


/**
 * A representation of a rational number
 * */
public class Fraction {
	
	private int numerator;
	private int denominator;

	/**
	 * A' = A.normalized() is such that 
	 * gcd(A'.numerator, A'.denominator) = 1
	 * */
	public Fraction normalized() {
		int gcd=Utils.greatestCommonDenominator(this.numerator, this.denominator);
		if (gcd==1) {return new Fraction(this.numerator, this.denominator);}
		return new Fraction(this.numerator/gcd, this.denominator/gcd);
	}

	public Fraction(int numerator, int denominator) {
		this.numerator=numerator;
		
		if (denominator!=0) {
			this.denominator=denominator;}
		else {
			throw new IllegalArgumentException("Argument 'denominator' is 0");
		}
	}
	
	////////////~~~ARITHMETIC OPERATORS~~~////////////
	
	//// Binary operators ////
	
	/**
	 * a + b
	 * */
	public static Fraction add(Fraction a, Fraction b) {
		int new_num=a.numerator*b.denominator+b.numerator*a.denominator;
		int new_den=a.denominator*b.denominator;
		Fraction new_frac=new Fraction(new_num,new_den);
		return new_frac.normalized();
	}
	
	/**
	 * a - b
	 * */
	public static Fraction sub(Fraction a, Fraction b) {
		int new_num=a.numerator*b.denominator-b.numerator*a.denominator;
		int new_den=a.denominator*b.denominator;
		Fraction new_frac=new Fraction(new_num,new_den);
		return new_frac.normalized();
	}
	
	/**
	 * a x b
	 * */
	public static Fraction mul(Fraction a, Fraction b) {
		int new_num=a.numerator*b.numerator;
		int new_den=a.denominator*b.denominator;
		Fraction new_frac=new Fraction(new_num,new_den);
		return new_frac.normalized();
	}
	
	/**
	 * a / b
	 * */
	public static Fraction div(Fraction a, Fraction b) {
		int new_num=a.numerator*b.denominator;
		int new_den=a.denominator*b.numerator;
		Fraction new_frac=new Fraction(new_num,new_den);
		return new_frac.normalized();
	}
	

	//// Unary operators ////
	
	/**
	 * -a
	 * */
	public static Fraction neg(Fraction a) {
		a.numerator=-a.numerator;
		return a;
	}
	
	/**
	 * 1 / a
	 * */
	public static Fraction invMultiplicative(Fraction a) {
		//TODO stub
		if (a.numerator==0) {throw new IllegalArgumentException("Argument 'denominator' is 0");}
		return new Fraction(a.denominator,a.numerator);
	}
	

	//// 0-ary operators (constants) ////
	
	/**
	 * 1
	 * */
	public static Fraction one() {
		
		return new Fraction(1,1);
	}
	
	/**
	 * 0
	 * */
	public static Fraction zero() {
		return new Fraction(0,1);
	}
	
	////////////~~~BOOLEAN OPERATORS~~~////////////
		
	/**
	 * a == b
	 * */
	public static boolean equals(Fraction a, Fraction b) {
		a=a.normalized();
		b=b.normalized();
		
		if (a.numerator==b.numerator && a.denominator==b.denominator){return true;}
		return false;
	}
	
	/**
	 * a > b
	 * */
	public static boolean gThan(Fraction a, Fraction b) {
		a=a.normalized();
		b=b.normalized();
		
		if (a.numerator*b.denominator-a.denominator*b.numerator>0){return true;}
		return false;
	}
	
	/**
	 * a < b
	 * */
	public static boolean lThan(Fraction a, Fraction b) {
		a=a.normalized();
		b=b.normalized();
		
		if (a.numerator*b.denominator-a.denominator*b.numerator<0){return true;}
		return false;	
	}
}

package tarea02;

/**
 * A 3D Vector.
 * Since it uses Fractions, calculations are 
 * guaranteed to be exact
 * */
public class Vector {
	
	private Fraction x;
	private Fraction y;
	private Fraction z;

	public Vector(Fraction x, Fraction y, Fraction z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}

	/**
	 * a + b
	 * */
	public static Vector add(Vector a, Vector b) {
		
		return new Vector(Fraction.add(a.x,b.x),Fraction.add(a.y,b.y),Fraction.add(a.z,b.z));
	}
	
	/**
	 * a - b
	 * */
	public static Vector sub(Vector a, Vector b) {
		
		return new Vector(Fraction.sub(a.x,b.x),Fraction.sub(a.y,b.y),Fraction.sub(a.z,b.z));
	}

	/**
	 * (a.X * bX, a.Y * b.Y, a.Z * b.Z)
	 * */
	public static Vector mul(Vector a, Vector b) {
		
		return new Vector(Fraction.mul(a.x,b.x),Fraction.mul(a.y,b.y),Fraction.mul(a.z,b.z));
	}
	
	/**
	 * (a.X / bX, a.Y / b.Y, a.Z / b.Z)
	 * */
	public static Vector div(Vector a, Vector b) {
		
		return new Vector(Fraction.div(a.x,b.x),Fraction.div(a.y,b.y),Fraction.div(a.z,b.z));
	}
	
	/**
	 * Multiplication of a vector by a scalar
	 * */
	public static Vector mulScalar(Vector a, Fraction s) {
		Vector vec_frac=new Vector(s,s,s);
		return mul(a,vec_frac);
	}
	
	/**
	 * Division of a vector by a scalar
	 * */
	public static Vector divScalar(Vector a, Fraction s) {
		Vector vec_frac=new Vector(s,s,s);
		return div(a,vec_frac);
	}
	
	/**
	 * Dot product
	 * */
	public static Fraction dot(Vector a, Vector b) {
		Vector vec_mul=mul(a,b);
		return Fraction.add(Fraction.add(vec_mul.x,vec_mul.y),vec_mul.z);
	}
	
	/**
	 * Cross product
	 * */
	public static Vector cross(Vector a, Vector b) {
		Fraction s1=Fraction.sub(Fraction.mul(a.y, b.z), Fraction.mul(a.z,b.y));
		Fraction s2=Fraction.sub(Fraction.mul(a.z, b.x), Fraction.mul(a.x,b.z));
		Fraction s3=Fraction.sub(Fraction.mul(a.x, b.y), Fraction.mul(a.y,b.x));
		
		return new Vector(s1,s2,s3);
	}
	
	/**
	 * Zero vector
	 * */
	public static Vector zero() {
		Fraction zero=Fraction.zero();
		return new Vector(zero,zero,zero);
	}
	
	/**
	 * (1, 0, 0)
	 * */
	public static Vector eX() {
		Fraction one=Fraction.one();
		Fraction zero=Fraction.zero();
		return new Vector(one,zero,zero);
	}
	
	/**
	 * (0, 1, 0)
	 * */
	public static Vector eY() {
		Fraction one=Fraction.one();
		Fraction zero=Fraction.zero();
		return new Vector(zero,one,zero);
	}
	
	/**
	 * (0, 0, 1)
	 * */
	public static Vector eZ() {
		Fraction one=Fraction.one();
		Fraction zero=Fraction.zero();
		return new Vector(zero,zero,one);
	}
	
	public static boolean equals(Vector a, Vector b) {
		if (Fraction.equals(a.x, b.x)&&Fraction.equals(a.y, b.y)&&Fraction.equals(a.z, b.z)) {return true;}
		return false;
	}

}

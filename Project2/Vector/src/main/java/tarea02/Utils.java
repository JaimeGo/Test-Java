package tarea02;

public class Utils {
	
	public static int greatestCommonDenominator(int a, int b) {
		if (b==0) return a;
		return greatestCommonDenominator(b,a%b);
	}
}

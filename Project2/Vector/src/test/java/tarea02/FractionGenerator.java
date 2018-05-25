package tarea02;

import com.pholser.junit.quickcheck.generator.*;
import com.pholser.junit.quickcheck.random.*;

public class FractionGenerator extends Generator<Fraction> {
	
	public FractionGenerator() {
		super(Fraction.class);
	}
	
	
	public Fraction generate(SourceOfRandomness source, GenerationStatus gStatus) {
		int a=0;
		int b=0;
		while (a==0||b==0) {
			if (a==0) {
				a=source.nextInt(-100000000, 100000000);
			}
			if (b==0) {
				b=source.nextInt(-100000000, 100000000);
			}
			
		}
		return new Fraction(
					a,b
				);
	}

}

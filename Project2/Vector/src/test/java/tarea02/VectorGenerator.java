package tarea02;

import com.pholser.junit.quickcheck.generator.*;
import com.pholser.junit.quickcheck.random.*;

public class VectorGenerator extends Generator<Vector> {
	
	public VectorGenerator() {
		super(Vector.class);
	}
	
	
	public Vector generate(SourceOfRandomness source, GenerationStatus gStatus) {
		
		
		
		FractionGenerator gen_frac=new FractionGenerator();
		
		Fraction x=gen_frac.generate(source, gStatus);
		Fraction y=gen_frac.generate(source, gStatus);
		Fraction z=gen_frac.generate(source, gStatus);
		
		
		return new Vector(x,y,z);
	}

}

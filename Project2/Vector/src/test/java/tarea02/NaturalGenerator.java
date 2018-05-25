package tarea02;

import com.pholser.junit.quickcheck.generator.*;
import com.pholser.junit.quickcheck.random.*;

public class NaturalGenerator extends Generator<Natural> {
	
	public NaturalGenerator() {
		super(Natural.class);
	}
	
	/**
	 * At least for integers, this is straightforward
	 * */
	public Natural generate(SourceOfRandomness source, GenerationStatus gStatus) {
		return new Natural(
					source.nextInt(0, 100000000)
				);
	}

}

package tarea02;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;
import org.junit.Assume;
//import org.junit.Assert;

import static org.junit.Assert.*;

@RunWith(JUnitQuickcheck.class)
public class NaturalProperties {
	
	/**
	 * Testing that succ and antec are inverse functions
	 * of each other
	 * */
	@Property(trials = 10000) public void inverses(
			// We mention the Generator here,
			// otherwise the Property doesn't know where 
			// to get instances from
			@From(NaturalGenerator.class) Natural n) {

		// We can assert equality of elements.
		Natural antecOfSucc = Natural.antec(Natural.succ(n));
		
		assertEquals(antecOfSucc, n);
	}
	
	/**
	 * Testing that succ always grows
	 * */
	@Property(trials = 10000) public void succGrows(
			@From(NaturalGenerator.class) Natural n) {
		
		// We can also assert truth or falseness of boolean statements.
		boolean isSuccGreater = Natural.gThan(Natural.succ(n), n);
		
		assertTrue(isSuccGreater);
	}
	
	/*
	 * Cool sidenote:
	 * - Since we know that succ always grows (test 2)
	 * - And we know that succ and antec are inverses,
	 * 
	 * Don't we then know that antec always shrinks?
	 * 
	 * Think about it. If it were false, could Test 1 and Test 2 pass?
	 * 
	 * */
	
	/**
	 * Testing that succ maintains order:
	 * 
	 * a > b <--> succ(a) > succ(b)
	 * */
	@Property(trials = 10000, shrink = true) public void succKeepsOrder(
			@From(NaturalGenerator.class) Natural n,
			@From(NaturalGenerator.class) Natural m) {
		
		// We can assert boolean equivalence, e.g. p <--> q
		
		// Left side of the logical equivalence (p)
		boolean gThanBeforeSucc = Natural.gThan(n, m);
		
		// Right side of the logical equivalence (q)
		boolean gThanAfterSucc = Natural.gThan(Natural.succ(n), Natural.succ(m));
		
		// And now we assert that they are equal
		assertEquals(gThanBeforeSucc, gThanAfterSucc);
	}
	
	/**
	 * Testing that every natural different from Zero
	 * is greater than Zero:
	 * 
	 * forAll[n] n != 0 --> n > 0
	 * 
	 * */
	@Property(trials = 100000) public void zeroIsLowest(
			@From(NaturalGenerator.class) Natural n) {
		
		// And lastly we can assert implication, e.g. p --> q
		
		// AssumeTrue is the left side of the implication (p)
		Assume.assumeTrue(n != Natural.zero());
		
		// AssertTrue is the implicated statement (q)
		assertTrue(Natural.gThan(n, Natural.zero()));
	}
	
	/*
	 * Cool sidenote #2:
	 * - Given gEq,
	 * - Could we define zero from this property?
	 * 
	 * Something like this: 
	 * zero := "The Natural such that forAll Natural n, 
	 * 			zero is lower or equal than n."
	 * */
}

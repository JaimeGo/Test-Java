package tarea02;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;
import org.junit.Assume;
//import org.junit.Assert;

import static org.junit.Assert.*;

@RunWith(JUnitQuickcheck.class)
public class FractionProperties {
	
	/**
	 * Propiedad asociativa
	 * */
	@Property(trials = 10000) public void asoc(
			// We mention the Generator here,
			// otherwise the Property doesn't know where 
			// to get instances from
			@From(FractionGenerator.class) Fraction a,@From(FractionGenerator.class) Fraction b,@From(FractionGenerator.class) Fraction c) {

		// We can assert equality of elements.
		Fraction leftSide = Fraction.add(Fraction.add(a,b), c);
		Fraction rightSide = Fraction.add(Fraction.add(b,c), a);
		
		assertEquals(leftSide,rightSide);
	}
	
	
	
	
	/**
	 * Propiedad conmutativa
	 * */
	@Property(trials = 10000) public void conm(
			// We mention the Generator here,
			// otherwise the Property doesn't know where 
			// to get instances from
			@From(FractionGenerator.class) Fraction a,@From(FractionGenerator.class) Fraction b) {

		// We can assert equality of elements.
		Fraction leftSide = Fraction.add(a,b);
		Fraction rightSide = Fraction.add(b,a);
		
		assertEquals(leftSide,rightSide);
	}
	
	
	
	
	/**
	 * Elemento neutro
	 * */
	@Property(trials = 10000) public void neutro(
			// We mention the Generator here,
			// otherwise the Property doesn't know where 
			// to get instances from
			@From(FractionGenerator.class) Fraction a) {

		// We can assert equality of elements.
		Fraction b = Fraction.zero();
		Fraction leftSide = Fraction.add(a,b);
		Fraction rightSide = a;
		
		assertEquals(leftSide,rightSide);
	}
	
	
	
	
	/**
	 * Inv. aditivo
	 * */
	@Property(trials = 10000) public void invAditivo(
			// We mention the Generator here,
			// otherwise the Property doesn't know where 
			// to get instances from
			@From(FractionGenerator.class) Fraction a) {

		// We can assert equality of elements.
		Fraction b = Fraction.zero();
		Fraction leftSide = Fraction.sub(a,a);
		Fraction rightSide = b;
		
		assertEquals(leftSide,rightSide);
	}
	
	
	
	
	/**
	 * Propiedad asociativa mult
	 * */
	@Property(trials = 10000) public void asocMult(
			// We mention the Generator here,
			// otherwise the Property doesn't know where 
			// to get instances from
			@From(FractionGenerator.class) Fraction a,@From(FractionGenerator.class) Fraction b,@From(FractionGenerator.class) Fraction c) {

		// We can assert equality of elements.
		Fraction leftSide = Fraction.mul(Fraction.mul(a,b), c);
		Fraction rightSide = Fraction.mul(Fraction.mul(b,c), a);
		
		assertEquals(leftSide,rightSide);
	}
	
	
	
	
	/**
	 * Propiedad conmutativa mult
	 * */
	@Property(trials = 10000) public void conmMult(
			// We mention the Generator here,
			// otherwise the Property doesn't know where 
			// to get instances from
			@From(FractionGenerator.class) Fraction a, @From(FractionGenerator.class) Fraction b) {

		// We can assert equality of elements.
		Fraction leftSide = Fraction.mul(a,b);
		Fraction rightSide = Fraction.mul(b,a);
		
		assertEquals(leftSide,rightSide);
	}
	
	
	
	
	/**
	 * Elemento neutro mul
	 * */
	@Property(trials = 10000) public void neutroMult(
			// We mention the Generator here,
			// otherwise the Property doesn't know where 
			// to get instances from
			@From(FractionGenerator.class) Fraction a) {

		// We can assert equality of elements.
		Fraction b = Fraction.one();
		Fraction leftSide = Fraction.mul(a,b);
		Fraction rightSide = a;
		
		assertEquals(leftSide,rightSide);
	}
	
	
	
	
	/**
	 * Distributiva
	 * */
	@Property(trials = 10000) public void distributiva(
			// We mention the Generator here,
			// otherwise the Property doesn't know where 
			// to get instances from
			@From(FractionGenerator.class) Fraction a, @From(FractionGenerator.class) Fraction b, @From(FractionGenerator.class) Fraction c) {

		// We can assert equality of elements.
	
		Fraction leftSide = Fraction.mul(a,Fraction.add(b,c));
		Fraction rightSide = Fraction.add(Fraction.mul(a,b), Fraction.mul(a,c));
		
		assertEquals(leftSide,rightSide);
	}
	
}
package tarea02;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;
import org.junit.Assume;
//import org.junit.Assert;

import static org.junit.Assert.*;

@RunWith(JUnitQuickcheck.class)
public class VectorProperties {
	
	/**
	 * Propiedad asociativa
	 * */
	@Property(trials = 10000) public void asoc(
			// We mention the Generator here,
			// otherwise the Property doesn't know where 
			// to get instances from
			@From(VectorGenerator.class) Vector a,@From(VectorGenerator.class) Vector b,@From(VectorGenerator.class) Vector c) {

		// We can assert equality of elements.
		Vector leftSide = Vector.add(Vector.add(a,b), c);
		Vector rightSide = Vector.add(Vector.add(b,c), a);
		
		assertEquals(leftSide,rightSide);
	}
	
	

	
	/**
	 * Propiedad conmutativa
	 * */
	@Property(trials = 10000) public void conm(
			// We mention the Generator here,
			// otherwise the Property doesn't know where 
			// to get instances from
			@From(VectorGenerator.class) Vector a,@From(VectorGenerator.class) Vector b) {

		// We can assert equality of elements.
		Vector leftSide = Vector.add(a,b);
		Vector rightSide = Vector.add(b,a);
		
		assertEquals(leftSide,rightSide);
	}
	
	
	
	
	/**
	 * Elemento neutro
	 * */
	@Property(trials = 10000) public void neutro(
			// We mention the Generator here,
			// otherwise the Property doesn't know where 
			// to get instances from
			@From(VectorGenerator.class) Vector a) {

		// We can assert equality of elements.
		Vector b = Vector.zero();
		Vector leftSide = Vector.add(a,b);
		Vector rightSide = a;
		
		assertEquals(leftSide,rightSide);
	}
	
	
	
	
	/**
	 * Inv. aditivo
	 * */
	@Property(trials = 10000) public void invAditivo(
			// We mention the Generator here,
			// otherwise the Property doesn't know where 
			// to get instances from
			@From(VectorGenerator.class) Vector a) {

		// We can assert equality of elements.
		Vector b = Vector.zero();
		Vector leftSide = Vector.sub(a,a);
		Vector rightSide = b;
		
		assertEquals(leftSide,rightSide);
	}
	
	
	
	/**
	 * Distributiva escalar 
	 * */
	@Property(trials = 10000) public void distEscalar(
			// We mention the Generator here,
			// otherwise the Property doesn't know where 
			// to get instances from
			@From(VectorGenerator.class) Vector a,@From(FractionGenerator.class) Fraction b,@From(FractionGenerator.class) Fraction c) {

		// We can assert equality of elements.
		
		Vector leftSide = Vector.mulScalar(a,Fraction.add(b,c));
		Vector rightSide = Vector.add(Vector.mulScalar(a,b),Vector.mulScalar(a,c));
		
		assertEquals(leftSide,rightSide);
	}
	
	
	
	/**
	 * Distributiva vectorial
	 * */
	@Property(trials = 10000) public void distVect(
			// We mention the Generator here,
			// otherwise the Property doesn't know where 
			// to get instances from
			@From(VectorGenerator.class) Vector a,@From(VectorGenerator.class) Vector b,@From(FractionGenerator.class) Fraction c) {

		// We can assert equality of elements.
		
		Vector leftSide = Vector.mulScalar(Vector.add(a, b),c);
		Vector rightSide = Vector.add(Vector.mulScalar(a,c),Vector.mulScalar(b,c));
		
		assertEquals(leftSide,rightSide);
	}
	
	/**
	 * Distributiva mult
	 * */
	@Property(trials = 10000) public void distMult(
			// We mention the Generator here,
			// otherwise the Property doesn't know where 
			// to get instances from
			@From(FractionGenerator.class) Fraction a,@From(FractionGenerator.class) Fraction b,@From(VectorGenerator.class) Vector c) {

		// We can assert equality of elements.
		
		Vector leftSide = Vector.mulScalar(c,Fraction.mul(a, b));
		Vector rightSide = Vector.mulScalar(Vector.mulScalar(c,b),a);
		
		assertEquals(leftSide,rightSide);
	}
	
	
	/**
	 * Neutro
	 * */
	@Property(trials = 10000) public void distMult(
			// We mention the Generator here,
			// otherwise the Property doesn't know where 
			// to get instances from
			@From(VectorGenerator.class) Vector a) {

		// We can assert equality of elements.
		
		Vector leftSide = Vector.mulScalar(a,Fraction.zero());
		Vector rightSide = Vector.zero();
		
		assertEquals(leftSide,rightSide);
	}
	
	/**
	 * Sub
	 * */
	@Property(trials = 10000) public void sub(
			// We mention the Generator here,
			// otherwise the Property doesn't know where 
			// to get instances from
			@From(VectorGenerator.class) Vector a,@From(VectorGenerator.class) Vector b) {

		// We can assert equality of elements.
		
		Fraction minus= new Fraction(-1,1);
		Vector leftSide = Vector.add(a,Vector.mulScalar(b, minus));
		Vector rightSide = Vector.sub(a,b);
		
		assertEquals(leftSide,rightSide);
	}
	
	
	
	/**
	 * Dot product conmutative
	 * */
	@Property(trials = 10000) public void dotProdConm(
			// We mention the Generator here,
			// otherwise the Property doesn't know where 
			// to get instances from
			@From(VectorGenerator.class) Vector a, @From(VectorGenerator.class) Vector b) {

		// We can assert equality of elements.
		
	
		Fraction leftSide = Vector.dot(a,b);
		Fraction rightSide = Vector.dot(b,a);
		
		assertEquals(leftSide,rightSide);
	}
	
	
	/**
	 * Cross product conmutative (with -1)
	 * */
	@Property(trials = 10000) public void crossProdConm(
			// We mention the Generator here,
			// otherwise the Property doesn't know where 
			// to get instances from
			@From(VectorGenerator.class) Vector a,@From(VectorGenerator.class) Vector b) {

		// We can assert equality of elements.
		
		Fraction minus= new Fraction(-1,1);
		Vector leftSide = Vector.cross(a,b);
		Vector rightSide = Vector.mulScalar(Vector.cross(b,a),minus);
		
		assertEquals(leftSide,rightSide);
	}
	
	
}
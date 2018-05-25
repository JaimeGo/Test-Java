package tarea02;

/**
 * Example class that defines a Natural number and its properties
 * */
public class Natural {
	
	private int value;
	
	public int Value() {
		return value;
	}

	public Natural(int value) {
		if(value >= 0)
			this.value = value;
		else
			this.value = 0;
	}

	/**
	 * n + 1
	 * */
	public static Natural succ(Natural n) {
		return new Natural(n.value + 1);
	}
	
	/**
	 * If n > 0, antec(n) is such that succ(antec(n)) = n
	 * */
	public static Natural antec(Natural n) {
		return new Natural(n.value - 1);
	}
	
	/**
	 * True iff a > b
	 * */
	public static boolean gThan(Natural a, Natural b) {
		return a.value > b.value;
	}
	
	/**
	 * Constant. Lowest number in the Naturals Set
	 * */
	public static Natural zero() {
		return new Natural(0);
	}
	
	public String toString() {
		return value + "";
	}
	
	/**
	 * Horrible, hacky way in which Java accepts
	 * override of equals.
	 * Adaptable for basically every class.
	 * */
	@Override 
	public boolean equals(Object obj) {
		if (obj == null) {
	        return false;
	    }
	    if (!Natural.class.isAssignableFrom(obj.getClass())) {
	        return false;
	    }
	    
	    final Natural other = (Natural) obj;
	    
		return this.value == other.value;
	}
}

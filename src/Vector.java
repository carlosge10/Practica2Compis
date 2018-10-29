public class Vector {
	public double d1;
	public double d2;
	
	public Vector() {
		this.d1 = 0.0;
		this.d2 = 0.0;
	}
	
	public Vector(Object son) {
		this.d1 = ((Vector)son).d1;
		this.d2 = ((Vector)son).d2;
	}
	
	public Vector(double d1, double d2) {
		this.d1 = d1;
		this.d2 = d2;
	}
	
	public double magnitude() {
		return Math.sqrt((Math.pow(this.d1, 2)) + (Math.pow(this.d2, 2)));
	}
	
	public Object sum(Object v) {
		return (Object) new Vector(this.d1 + ((Vector)v).d1, this.d2 + ((Vector)v).d2);
	}
	
	public Object substract(Object v) {
		return (Object) new Vector(this.d1 - ((Vector)v).d1, this.d2 - ((Vector)v).d2);
	}
	
	public Object multiplyByScalar(double scalar) {
		return (Object) new Vector(this.d1 * scalar, this.d2 * scalar);
	}
	
	public Object divideByScalar(double scalar) {
		return (Object) new Vector (this.d1 / scalar, this.d2 / scalar);
	}
	
	public double dot(Object v) {
		return this.d1 * ((Vector)v).d1 + this.d2 * ((Vector)v).d2;
	}
	
	public Object normalize() {
		double magnitude = this.magnitude();
		return (Object) new Vector(this.d1 / magnitude, this.d2 / magnitude);
	}
}
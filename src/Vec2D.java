
public class Vec2D {
	
	public double v1, v2;
	
	public Vec2D() 
	{
		v1 = 0.0;
		v2 = 0.0;
	}
	
	public Vec2D(double v1, double v2) 
	{
		this.v1 = v1;
		this.v2 = v2;
	}
	
	public static double mag(Vec2D v) 
	{
		return Math.sqrt(v.v1 * v.v1 + v.v2 * v.v2);
	}
	
	public static Vec2D norm(Vec2D v) 
	{
		double mag = mag(v);
		v.v1 /= mag;
		v.v2 /= mag;
		return v;
	}
	
	public static double dot(Vec2D v, Vec2D v1) 
	{
		return (v.v1 * v1.v1 + v.v2 * v1.v2);
	}
}

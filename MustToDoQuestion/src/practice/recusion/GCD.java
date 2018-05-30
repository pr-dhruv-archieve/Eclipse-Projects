package practice.recusion;

public class GCD {

	public static int gcd(int x, int y) {
		System.out.println("x="+x+" y="+y);
		if(y == 0)
			return x;
		else
			return gcd(y,x % y);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(gcd(15,20));
	}

}
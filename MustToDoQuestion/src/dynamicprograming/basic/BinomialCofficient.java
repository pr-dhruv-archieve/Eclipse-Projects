package dynamicprograming.basic;

public class BinomialCofficient {
	
	//Recursive Method
	public static long method1(int n, int r) {
		if (r == 0 || r == n)
			return 1;
		else
			return method1(n - 1, r - 1) + method1(n-1, r);
	}
	
	//Top Down DP
	private static long auxMethod2(int n, int r, long[][] mem) {
		if (mem[n][r] != 0)
			return mem[n][r];
		else if (r == 0 || n == r)
			return mem[n][r] = 1;
		else {
			return mem[n][r] = auxMethod2(n - 1, r - 1, mem) + auxMethod2(n - 1, r, mem);
		}
	}
	public static long method2(int n, int r) {
		long[][] mem = new long[n + 1][r + 1];
		auxMethod2(n, r, mem);
		return mem[n][r];
	}
	
	//Optimized Space and time TC : O(min(n,r)) SC : O(1)
	public static long ncr(int n, int r) {
		
		int result = 1;
		
		if (r > n-r)
			r = n - r;
	
		for (int i = 0 ; i < r; i++){
			result *= (n - i);
			result /= (i +1 );
		}
		
		return result;
	
	}
	
	public static void main(String[] args) {
		System.out.println(method1(8, 2));
		System.out.println(method2(8, 2));
		System.out.println(ncr(8, 2));
	}
}

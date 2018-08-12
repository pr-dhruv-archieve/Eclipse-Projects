
public class GoldManSample {

	static int numCPUCycles(int n, int d, int c1, int c2) {

        int cost = 0;
        while (n >= d) {
            if(n % d == 0) {
                cost += c2;
                n /= d;
            }
            else {
            	int r = n%d;
                cost += (r*c1);
                n -= r;
            }
        }
        return cost;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numCPUCycles(9, 2, 3, 1));
	}

}

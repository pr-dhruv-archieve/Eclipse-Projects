import java.util.Arrays;

class GFG {
	static int getMinSteps(int n) {
		int table[] = new int[n + 1];
		for (int i = 0; i <= n; i++)
			table[i] = n - i;
		System.out.println(Arrays.toString(table));
		for (int i = n; i >= 1; i--) {
			if (!(i % 2 > 0))
				table[i / 2] = Math.min(table[i] + 1, table[i / 2]);
			System.out.println(Arrays.toString(table));
			if (!(i % 3 > 0))
				table[i / 3] = Math.min(table[i] + 1, table[i / 3]);
			System.out.println(Arrays.toString(table));
		}
		return table[1];
	}

	// Driver Code
	public static void main(String[] args) {
		int n = 9;
		System.out.print(getMinSteps(n));
	}
}
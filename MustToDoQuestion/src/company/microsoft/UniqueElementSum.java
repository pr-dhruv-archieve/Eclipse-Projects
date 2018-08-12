package company.microsoft;

import java.util.HashSet;

public class UniqueElementSum {

	public static int uniqueSum(int[] arr1, int[] arr2){
		
		HashSet<Integer> hs = new HashSet<Integer>();
		int sum = 0;
		
		for(int i=0; i<arr1.length; i++){
			hs.add(new Integer(arr1[i]));
		}
		for(int i=0;i<arr2.length;i++){
			if(!hs.contains(arr2[i]))
				sum += arr2[i];
		}
		
		hs.clear();
		
		for(int i=0; i<arr2.length; i++){
			hs.add(new Integer(arr2[i]));
		}
		for(int i=0;i<arr1.length;i++){
			if(!hs.contains(arr1[i]))
				sum += arr1[i];
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr1 = new int[]{1,2,3,4,5,8};
		int[] arr2 = new int[]{1,3,5,7,9};
		
		System.out.println(uniqueSum(arr1,arr2));
	}

}

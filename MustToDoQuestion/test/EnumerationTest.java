import java.util.Enumeration;
import java.util.Vector;

public class EnumerationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<Integer> v = new Vector<Integer>();
		
		for (int i =0 ; i < 11; i++)
			v.add(i);
		System.out.println(v);
		
		Enumeration e = v.elements();
		
		while(e.hasMoreElements()) {
			Integer i = (Integer) e.nextElement();
			if(i%2==0)
				System.out.println(i);
			else {
				System.out.println(i+" is removed.");
				v.remove(i);
			}
		}
		System.out.println(v);
	}

}

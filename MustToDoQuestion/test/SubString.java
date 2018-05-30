
public class SubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "amazon";
		System.out.println(s);
		System.out.println(s.substring(2)+s.substring(0,2));
		System.out.println(s.substring(s.length() - 2)+s.substring(0,s.length() - 2));
		s = "d";
		String temp = s.substring(0,1);
		System.out.println(s.indexOf(temp));
		
	}

}

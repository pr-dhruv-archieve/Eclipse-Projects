package Assignment1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

public class FrequencyCount {

	public static int letterCount(String s) {
		char[] charData = s.toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character,Integer>();
		int count = 0;
		
		for (Character temp : charData) {
			if (map.containsKey(temp))
				map.put(temp,(map.get(temp)+1));
			else
				map.put(temp, 1);
		}
		
		SortedSet<Character> keySet= new TreeSet<Character>(map.keySet());
		System.out.println("Letter Count");
		for (char temp : keySet) {
			if (temp == ' ')
				System.out.println("\' \' -> " + map.get(temp));
			else
				System.out.println(temp + " -> " + map.get(temp));
		}
		return charData.length;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String data = "";
		try (BufferedReader br = new BufferedReader(new FileReader("data.txt"));){
			String str = br.readLine();
			
			while (str != null) {
				data += str;
				str = br.readLine();
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Total count : " + letterCount(data));
		
	}

}

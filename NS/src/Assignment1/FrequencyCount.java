package Assignment1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

public class FrequencyCount {

	public static void letterCount(String s) {
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(s));){
			int ch = br.read();
			
			while (ch >= 0 && ch <= 255) {
				char d = (char)ch;
				
				if (ch == '\r' || ch == '\n') {
					ch = (char)br.read();
					continue;
				}
				
				if (map.containsKey(ch))
					map.put(ch, map.get(ch)+1);
				else
					map.put(ch, 1);
				
				ch = br.read();
			}
		}
		catch(IOException e) {
			System.out.println("File Not Found.");
			return;
		}
		if (map.isEmpty()) {
			System.out.println("empty file");
			return ;
		}
		SortedSet<Integer> keys = new TreeSet<Integer>(map.keySet());
		for (Integer ch : keys) {
			int c = ch;
			if (c == ' ')
				System.out.println("\' \'\t" + map.get(ch));
			else
				System.out.println((char)c + "\t" + map.get(ch));
		}
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < 3; i++) {
			System.out.println("Test Case " + (i+1));
			String file = "file"+i+".txt";
			letterCount(file);
			System.out.println("\n\n");
		}
		
	}

}

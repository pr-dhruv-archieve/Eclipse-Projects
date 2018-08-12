import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedWriterTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, FileNotFoundException  {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new FileReader("file2.txt"));
		
		int i = br.read();
		while (i != -1) {
			System.out.print((char)(i));
			i = br.read();
		}
		
		br.close();
	}

}

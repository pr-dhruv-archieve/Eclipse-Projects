package Assignment1;

import java.util.Scanner;


public class MonoAlphabatic {

	private static String key = "eotraihxlnjvcufzqdwgykmpbs";
	private static String ch  = "abcdefghijklmnopqrstuvwxyz"; 

	public static String decrypt(String cipherText, String key) {
		String decrypt = "";
		cipherText = cipherText.toLowerCase();
		for (int i = 0; i < cipherText.length(); i++) {
			char c = cipherText.charAt(i);
			decrypt += ch.charAt(key.indexOf(c));
		}
		return decrypt;
	}
	
	public static String encrypt(String plainText, String key) {
		String encrypt = "";
		plainText = plainText.toLowerCase();
		for (int i = 0; i < plainText.length(); i++) {
			char c = plainText.charAt(i);
			encrypt += key.charAt(ch.indexOf(c));
		}
		return encrypt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String plainText = sc.next();
		String encrypted = encrypt(plainText, key);
		System.out.println(encrypted);
		
		String decrypted = decrypt(encrypted, key);
		System.out.println(decrypted);
	}

}

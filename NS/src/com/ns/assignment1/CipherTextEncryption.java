package com.ns.assignment1;

import java.util.Scanner;

public class CipherTextEncryption {

	private static int shift = 4;
	
	public static String encryption(String plainText) {
		String encrypt = "";
		plainText = plainText.toUpperCase();
		for (int i = 0; i < plainText.length(); i++) {
			char c = plainText.charAt(i);
			encrypt += (char)((c -65 + shift) % 26 + 65);
		}
		return encrypt;
	}
	
	public static String decryption(String cipherText) {
		String decrypt = "";
		cipherText = cipherText.toUpperCase();
		for (int i = 0; i < cipherText.length(); i++) {
			char c = cipherText.charAt(i);
			decrypt += (char)((c -65 - shift) % 26 + 65);
		}
		return decrypt;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String encrypt = encryption(sc.next());
		System.out.println(encrypt);
		
		String decrypt = decryption(encrypt);
		System.out.println(decrypt);
		
	}

}

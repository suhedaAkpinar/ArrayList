package Ornekler;

import java.util.Scanner;

public class String�slemleri {
	
	
	
	static public void main(String[] args) {
		String kelime,kelime2;
		Scanner scan=new Scanner(System.in);
		
		System.out.println("Bir kelime giriniz:");
		kelime=scan.nextLine();
		
		System.out.println("Al�nan kelime: " +kelime+" ve uzunlugu:"+kelime.length());
		for(int i=0;i<kelime.length();i++)
		{
			System.out.println(kelime.charAt(i));
		}
		System.out.println("Bir kelime daha giriniz:");
		kelime2=scan.nextLine();
		System.out.println("�ki kelimenin birbirine g�re durumu:"+kelime.equals(kelime2));
	}

}

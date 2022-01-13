package Ornekler;

import java.util.Scanner;

public class StringÝslemleri {
	
	
	
	static public void main(String[] args) {
		String kelime,kelime2;
		Scanner scan=new Scanner(System.in);
		
		System.out.println("Bir kelime giriniz:");
		kelime=scan.nextLine();
		
		System.out.println("Alýnan kelime: " +kelime+" ve uzunlugu:"+kelime.length());
		for(int i=0;i<kelime.length();i++)
		{
			System.out.println(kelime.charAt(i));
		}
		System.out.println("Bir kelime daha giriniz:");
		kelime2=scan.nextLine();
		System.out.println("Ýki kelimenin birbirine göre durumu:"+kelime.equals(kelime2));
	}

}

package Ornekler;

import java.util.Scanner;

public class BasamaklarToplami {
	
	
	static public void main(String[] args)
	{
		int sayi,kalan,bs=0,toplam=0;
		Scanner scan=new Scanner(System.in);
		System.out.println("Bir sayi giriniz:");
		sayi=scan.nextInt();
		
		while(sayi>0){
			kalan=sayi%10;
			toplam+=kalan;
			sayi=sayi-kalan;
			sayi=sayi/10;
			bs++;
			}
		
		System.out.println("Girilen sayýnýn basamaklari toplami: "+toplam+" Basamak sayisi:"+bs);
		
		
	}

}

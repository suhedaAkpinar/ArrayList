package Ornekler;

import java.util.Scanner;

public class PozitifBolenler {

	static public void main(String[] args) {
		int sayi;
		Scanner scan=new Scanner(System.in);
		System.out.println("Bir sayi giriniz:");
		sayi=scan.nextInt();
		
		for(int i=1;i<=sayi;i++)
		{
			if(sayi%i==0)
			{
				System.out.println("Pozitif bölen:"+i);
			}
		}
	}
}

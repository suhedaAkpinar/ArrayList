
import java.util.Scanner;

public class Anasayfa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int ogrSayisi,dersSayisi,sinavSayisi,i,j,k,deger,temp,sec;
		String dersID;

		System.out.println("Kac adet ogrenci girilecek?");
		ogrSayisi = sc.nextInt();

		Ogrenci[] ogrenci = new Ogrenci[ogrSayisi];

		for( i=0 ; i<ogrSayisi ; i++)
		{
			ogrenci[i] = new Ogrenci(); 

			System.out.println((i+1) + ".Ogrencinin numarasi:");
			ogrenci[i].setOgrenciNo(sc.nextLong());
			System.out.println((i+1) + ".Ogrencinin adi:");
			ogrenci[i].setAd(sc.next());
			System.out.println((i+1) + ".Ogrencinin soyadi:");
			ogrenci[i].setSoyad(sc.next());
			System.out.println((i+1) + ".Ogrencinin bolumu:");
			ogrenci[i].setBolum(sc.next());

			System.out.println((i+1) + ".Ogrencinin kac adet dersi var?");
			dersSayisi = sc.nextInt();

			Ders[] dersler = new Ders[dersSayisi];
			for ( j = 0; j < dersSayisi; j++) {
				dersler[j] = new Ders();

				System.out.println((j+1) + ".DersID gir:");
				dersler[j].setDersID(sc.next());
				System.out.println((j+1) + ".Ders adini gir:");
				dersler[j].setDersAd(sc.next());
				System.out.println((j+1) + ".Ders kredisini gir:");
				dersler[j].setDersKredi(sc.nextInt());
				System.out.println((j+1) + ".Ders donemini gir:");
				dersler[j].setDersDonem(sc.nextInt());

			}
			ogrenci[i].setDersler(dersler);

			System.out.println((i+1) + ".Ogrenci kac adet sinava girecek?");
			sinavSayisi = sc.nextInt();

			deger = sayiKontrol(dersSayisi,sinavSayisi);
			while(deger != 0) {
				System.out.println((i+1) + ".Ogrenci kac adet sinava girecek?");
				sinavSayisi = sc.nextInt();
				deger = sayiKontrol(dersSayisi,sinavSayisi);
			}

			Sinav[] sinavlar = new Sinav[sinavSayisi];
			for ( k = 0; k < sinavSayisi; k++) {
				sinavlar[k] =new Sinav();

				System.out.println((k+1) + ".Sinav ID gir:");
				sinavlar[k].setSinavID(sc.nextInt());
				System.out.println((k+1) + ".Sinav icin ders ID gir:");
				dersID = sc.next();
				
				temp = idKontrol(dersler,dersID);
				while(temp == 0) {
					System.out.println("Ogrenci bu dersi almadigi icin sinavina giremez.");
					System.out.println((k+1) + ".Sinav icin ders ID gir:");
					dersID = sc.next();
					temp = idKontrol(dersler,dersID);
				}
				sinavlar[k].setDersID(dersID);								

				System.out.println((k+1) + ".Sinav tarihini gir:");	
				sinavlar[k].setSinavTarih(sc.next());						
			}
			ogrenci[i].setSinavlar(sinavlar);

		}
		while(true) {
			sec = Menu(ogrenci);
			if(sec == 4) {
				break;
			}	
		}

	}

	public static int Menu(Ogrenci[] ogrenci) {
		Scanner sc = new Scanner(System.in);
		int secim;
		System.out.println("\n-----------------------MENU------------------------\n");
		System.out.println(" [1]: Tüm Bilgileri Listele \n "
				          + "[2]: Ogrenci Adina Göre Arama Yap \n "
				          + "[3]: Ders Adina Göre Arama Yap \n "
				          + "[4]: Cikis Yap");
		System.out.println("Secim yapiniz:");
		secim = sc.nextInt();

		switch(secim) {
		case 1 :
			Listele(ogrenci);
			break;
		case 2:{
			String aranacakAd;
			System.out.println("Aranacak adi gir:");
			aranacakAd = sc.next();
			AdaGoreArama(ogrenci,aranacakAd);
			break;
		}
		case 3:
			String aranacakDers;
			System.out.println("Aranacak ders adini gir:");
			aranacakDers = sc.next();
			DerseGoreArama(ogrenci,aranacakDers);
			break;
		case 4:
			System.out.println(" https://www.youtube.com/watch?v=hluVrTixQwI :)");
			break;
		}
		return secim;
	}

	public static void Listele(Ogrenci[] ogrenci) {
		System.out.println("\n--------------------------------------------------\n");

		for(int i=0 ; i<ogrenci.length ; i++)
		{
			System.out.println((i+1)+".Ogrencinin Bilgileri:");

			System.out.print(" Ogrenci No:"+ogrenci[i].getOgrenciNo());
			System.out.print(" Ogrenci Ad:"+ogrenci[i].getAd());
			System.out.print(" Ogrenci Soyad:"+ogrenci[i].getSoyad());
			System.out.print(" Ogrenci Bolum:"+ogrenci[i].getBolum());
			System.out.println("\n");

			System.out.println("Dersleri: ");
			Ders[] dersler = ogrenci[i].getDersler();

			for(int j=0 ; j<dersler.length ; j++)
			{
				System.out.println(" "+(j+1)+".Ders ID:"+dersler[j].getDersID()+" "+"Ders adi:"+dersler[j].getDersAd()+" "+"Ders kredi:"+
						dersler[j].getDersKredi()+" "+"Ders donem:"+dersler[j].getDersDonem());
			}
			System.out.println("\n");

			System.out.println("Sinavlari: ");
			Sinav[] sinavlar = ogrenci[i].getSinavlar();

			for (int k = 0; k < sinavlar.length; k++) {
				System.out.println(" "+(k+1)+".Sinav ID:"+sinavlar[k].getSinavID()+" "+"Ders ID:"+sinavlar[k].getDersID()+" "+"Sinav Tarihi:"+
						sinavlar[k].getSinavTarih());
			}
			System.out.println("\n--------------------------------------------------\n");
		}
	}

	public static void AdaGoreArama(Ogrenci[] ogrenci,String ad) {
		int sayac=0;
		for(int i=0 ; i<ogrenci.length ; i++)
		{
			if(ogrenci[i].getAd().contains(ad)) {
				System.out.println((i+1)+".Ogrencinin Bilgileri:");

				System.out.print(" Ogrenci No:"+ogrenci[i].getOgrenciNo());
				System.out.print(" Ogrenci Ad:"+ogrenci[i].getAd());
				System.out.print(" Ogrenci Soyad:"+ogrenci[i].getSoyad());
				System.out.print(" Ogrenci Bolum:"+ogrenci[i].getBolum());
				System.out.println("\n");

				System.out.println("Dersleri: ");
				Ders[] dersler = ogrenci[i].getDersler();

				for(int j=0 ; j<dersler.length ; j++)
				{
					System.out.println(" "+(j+1)+".Ders ID:"+dersler[j].getDersID()+" "+"Ders adi:"+dersler[j].getDersAd()+" "+"Ders kredi:"+
							dersler[j].getDersKredi()+" "+"Ders donem:"+dersler[j].getDersDonem());
				}
				System.out.println("\n");

				System.out.println("Sinavlari: ");
				Sinav[] sinavlar = ogrenci[i].getSinavlar();

				for (int k = 0; k < sinavlar.length; k++) {
					System.out.println(" "+(k+1)+".Sinav ID:"+sinavlar[k].getSinavID()+" "+"Ders ID:"+sinavlar[k].getDersID()+" "+"Sinav Tarihi:"+
							sinavlar[k].getSinavTarih());
				}
				System.out.println("\n--------------------------------------------------\n");
				sayac++;
			}
		}
		if(sayac == 0) {
			System.out.println("Bu isimde bir ogrenci bulunamadi.");
		}

	}

	public static void DerseGoreArama(Ogrenci[] ogrenci,String dersAd) {
		int sayac = 0;
		for(int i=0 ; i<ogrenci.length ; i++)
		{
			Ders[] dersler = ogrenci[i].getDersler();

			for(int j=0 ; j<dersler.length ; j++)
			{
				if(dersler[j].getDersAd().contains(dersAd)) {
					System.out.println((i+1)+".Ogrencinin Bilgileri:");

					System.out.print(" Ogrenci No:"+ogrenci[i].getOgrenciNo());
					System.out.print(" Ogrenci Ad:"+ogrenci[i].getAd());
					System.out.print(" Ogrenci Soyad:"+ogrenci[i].getSoyad());
					System.out.print(" Ogrenci Bolum:"+ogrenci[i].getBolum());
					System.out.println("\n");

					sayac++;
				}
			}
		}
		if(sayac == 0) {
			System.out.println("Bu dersi alan ogrenci yok.");
		}
	}

	public static int sayiKontrol(int dSayisi,int sSayisi) {
		if(sSayisi > dSayisi) {
			System.out.println("Sinav sayisi ders sayisindan buyuk olamaz!");
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public static int idKontrol(Ders[] dersler,String dersID) {
		int sayac =0;
		for(int j=0 ; j<dersler.length ; j++)
		{
			if(dersler[j].getDersID().contains(dersID)) {
				sayac++;
			}
		}
		return sayac;
	}

}


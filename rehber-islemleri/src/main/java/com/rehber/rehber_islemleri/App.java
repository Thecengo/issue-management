package com.rehber.rehber_islemleri;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class App 
{
	
	List<Person> personsList;
	
	static boolean devamEdilsinMi = true;
	
	static RehberIslemleri rehberIslemleri = new RehberIslemleri();
	
	static Desen desenlerim = new Desen();
	

	
	public App() {
		
		this.personsList = new ArrayList<Person>();
	}
	
    public static void main( String[] args )
    {

    	
    	Scanner scanner = new Scanner(System.in);
    	
    	Secim islemSecimi = new Secim();
    	
    	Input inputs = new Input();
    	
  
    	
    	
		while(devamEdilsinMi) {
			
			System.out.println(desenlerim.cizgiDeseni);
			
			int secim = secimIste(scanner);
			
			scanner.nextLine();
			
			String ad = inputs.adIste(scanner);
			String soyAd = inputs.soyadIste(scanner);
			String telNo = inputs.telNoIste(scanner);
			
			String cizgiDeseni = desenlerim.cizgiDeseni;
			System.out.println(cizgiDeseni);
			
			islemSecimi.secimYap(secim,new Person(ad, soyAd, telNo) );
		}
      
       
    }

	
	public static int secimIste(Scanner scanner) {
		
		metinGetir();
		
		System.out.println("secim");

		return scanner.nextInt();
		
	}
	
	public static void metinGetir() {
		String tab = desenlerim.tab;
		String altSatir = desenlerim.altSatir;
		String ikiNoktaUstUste = desenlerim.ikiNoktaUstUste;
		
		
		String metin = "Lütfen seciminizi yapınız."+tab+altSatir+
	                   "Kisi ekle için "+ tab + tab +ikiNoktaUstUste + tab +  " 0 " +altSatir+
				       "Ad soyada göre "+tab+tab+ikiNoktaUstUste + tab + " 1 " + altSatir+
	                   "Kişi silmek için"+ tab + ikiNoktaUstUste + tab + " 2 " + altSatir+
				       "Ad'a göre silmek için "+tab+ikiNoktaUstUste + tab + " 3 " + altSatir+
	                   "Listelemek için "+tab+ikiNoktaUstUste + tab + " 4 " + altSatir+
	                   "Durdurmak için lütfen"+tab+ikiNoktaUstUste + tab  +" 5' e basınız";
		
		System.out.println(metin);
		
	}

	public static boolean devamEtsinMi(boolean devamEdilsinMi) {
		if(devamEdilsinMi == true)
			return true;
		else
			return false;
	}
    
  
    
    
}

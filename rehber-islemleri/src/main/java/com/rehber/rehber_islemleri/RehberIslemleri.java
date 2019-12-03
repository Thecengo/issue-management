package com.rehber.rehber_islemleri;

import java.util.List;
import java.util.Scanner;

public class RehberIslemleri {
	
	App app = new App();

	public void ekle(Person person) {
		
		app.personsList.add(person);
		
		System.out.println(person.getAd() + "basarı ile olustrulmustur. \n");

	}

	public void ekle(String ad, String soyad, String tel) {
		
		app.personsList.add(new Person(ad,soyad,tel));

		System.out.print(ad+"basarı ile olustrulmustur.");

	}

	public void sil(int id, Person person) {
		app.personsList.remove(id);
		
		System.out.println(person.getAd() + "basarı ile silinmiştir. \n");

	}

	public void sil(String ad) {
		int length = app.personsList.size();
		
		for(int i = 0 ; i < length; i++) {
			if(app.personsList.get(i).equals(ad)) {
				app.personsList.remove(i);
				System.out.print(app.personsList.get(i) + "basarı ile kaldırılmıştır");
			}
			
		}

	}

	public void listele(String ad) {
		int length = app.personsList.size();
	
		for(int i = 0 ; i < length; i++) {
			if(app.personsList.get(i).getAd().equals(ad)) {
				System.out.println("liste = " + app.personsList.get(i).getAd());
			}
				
		}

	}
	
	public void rehberdeBaslayanHarfAramasiYap(List<Person> personList, Scanner scanner) {
		
		String aranacakHarfler = scanner.nextLine();
		
		for(int i = 0; i < personList.size(); i++) {
			String ad = personList.get(i).getAd();
			if(ad.startsWith(aranacakHarfler)) {
				System.out.print(ad);
			}
		}
		
		
	}

}

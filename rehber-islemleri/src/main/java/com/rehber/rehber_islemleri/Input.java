package com.rehber.rehber_islemleri;

import java.util.Scanner;

public class Input {
	
	
	public String adIste(Scanner scanner) {
		System.out.println("Lütfen ad giriniz: ");
		
		return scanner.nextLine();
	}
	
	public String soyadIste(Scanner scanner) {
		System.out.println("Lütfen soyad giriniz: ");
		return scanner.nextLine();
	}
	
	public String telNoIste(Scanner scanner) {
		System.out.println("Lütfen tel no giriniz: ");
		return scanner.nextLine();
	}
	

}

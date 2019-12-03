package com.rehber.rehber_islemleri;

public class Person {
	
	static int idCounter;
	private int id;
	private String ad;
	private String soyad;
	private String tel;
	
	
	
	public Person(String ad, String soyad, String tel) {
	    idCounter++;
	    this.id = idCounter;
		this.ad = ad;
		this.soyad = soyad;
		this.tel = tel;
	}
	
	
	
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}
	
	

}

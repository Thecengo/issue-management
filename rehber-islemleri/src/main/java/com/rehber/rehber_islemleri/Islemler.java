package com.rehber.rehber_islemleri;

public enum Islemler {

	KISI_EKLE(0), AD_SOYAD_EKLE(1), KISI_SIL(2), KISI_AD_SOYAD_SIL(3), KISI_LISTELE(4);

	public int islemCode;

	Islemler(int secim) {

		this.islemCode = secim;

	}

}

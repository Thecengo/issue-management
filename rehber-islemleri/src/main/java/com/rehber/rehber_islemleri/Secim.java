package com.rehber.rehber_islemleri;

public class Secim {
	
	public void secimYap(int secim, Person person) {
    	
    	switch(secim) {
    	
    	case 0:
    		App.rehberIslemleri.ekle(person);
    		break;
    		
    	case 1:
    		App.rehberIslemleri.ekle(person.getAd(), person.getSoyad(),person.getTel());
    		break;
    		
    	case 2:
    		App.rehberIslemleri.sil(person.getId(),person);
    		break;
    		
    	case 3:
    		App.rehberIslemleri.sil(person.getAd());
    		break;
    		
    	case 4:
    		App.rehberIslemleri.listele(person.getAd());
    		break;
    		
    	case 5:
    		App.devamEdilsinMi = App.devamEtsinMi(false);
    		break;
  
    	}
    	
    }

}

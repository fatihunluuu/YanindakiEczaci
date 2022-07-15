package com.example.laprospekts;

public class Ilaclar {
    long barkod;
    String ilacAdi;
    String fiyat;

    public Ilaclar(long gelenBarkod, String gelenAd, String gelenFiyat){
        this.barkod = gelenBarkod;
        this.ilacAdi = gelenAd;
        this.fiyat = gelenFiyat;
    }
    public long getBarkod() {
        return barkod;
    }
    public void setBarkod(long barkod) { this.barkod = barkod; }
    public String getIlacAdi() {
        return ilacAdi;
    }
    public void setIlacAdi(String ilacAdi) {
        this.ilacAdi = ilacAdi;
    }
    public String getFiyat() {
        return fiyat;
    }
    public void setFiyat(String fiyat) {
        this.fiyat = fiyat;
    }
}

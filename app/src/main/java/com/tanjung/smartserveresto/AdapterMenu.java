package com.tanjung.smartserveresto;

public class AdapterMenu {
    private String NamaMakanan, Harga;
    private int Gambar;

    public AdapterMenu(String NamaMakanan, String Harga, int Gambar) {
        this.NamaMakanan = NamaMakanan;
        this.Harga = Harga;
        this.Gambar = Gambar;
    }
    public  String getNamaMakanan() {
        return this.NamaMakanan;
    }
    public  String getHarga() {
        return this.Harga;
    }
    public  int getGambar() {
        return this.Gambar;
    }
}

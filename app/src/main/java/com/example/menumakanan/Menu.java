package com.example.menumakanan;

public class Menu {
    private String nama;
    private String harga;
    private String gambar;
    private String detail;

    public Menu(String dataNama, String dataHarga, String dataGambar, String dataDetail) {
        nama = dataNama;
        harga = dataHarga;
        gambar = dataGambar;
        detail = dataDetail;
    }

    public String getNama() {
        return nama;
    }

    public String getHarga() {
        return harga;
    }

    public String getGambar() {
        return gambar;
    }

    public String getDetail() {
        return detail;
    }
}

package sipetor.models;

/**
 *
 * @author Rizki Ramadhan
 */

public class Sparepart {
    
    private int id_sparepart;
    private String nama_sparepart;
    private int harga_sparepart;
    private int stock_sparepart;
    
    public Sparepart(int id_sparepart, String nama_sparepart, int harga_sparepart, int stock_sparepart) {
        this.id_sparepart = id_sparepart;
        this.nama_sparepart = nama_sparepart;
        this.harga_sparepart = harga_sparepart;
        this.stock_sparepart = stock_sparepart;
    }

    public int getId_sparepart() {
        return id_sparepart;
    }
    
    public void setId_sparepart(int id_sparepart) {
        this.id_sparepart = id_sparepart;
    }
    
    public String getNama_sparepart() {
        return nama_sparepart;
    }
    
    public void setNama_sparepart(String nama_sparepart) {
        this.nama_sparepart = nama_sparepart;
    }
    
    public int getHarga_sparepart() {
        return harga_sparepart;
    }
    
    public void setHarga_sparepart(int harga_sparepart) {
        this.harga_sparepart = harga_sparepart;
    }
    
    public int getStock_sparepart() {
        return stock_sparepart;
    }
    
    public void setStock_sparepart(int stock_sparepart) {
        this.stock_sparepart = stock_sparepart;
    } 
}

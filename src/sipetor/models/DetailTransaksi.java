package sipetor.models;

/**
 *
 * @author Rizki Ramadhan
 */
public class DetailTransaksi {
    private int id_reg;
    private String id_transaksi;
    private String id_sparepart;
    private int jumlah_beli;
    private int total_beli;
    
    public DetailTransaksi(int id_reg, String id_transaksi, String id_sparepart, 
            int jumlah_beli, int total_beli){
        this.id_reg = id_reg;
        this.id_transaksi = id_transaksi;
        this.id_sparepart = id_sparepart;
        this.jumlah_beli = jumlah_beli;
        this.total_beli = total_beli;
    }
    
    public int getId_reg() {
        return id_reg;
    }

    public void setId_reg(int id_reg) {
        this.id_reg = id_reg;
    }
    
    public String getId_transaksi() {
        return id_transaksi;
    }
    
    public void setId_transaksi(String id_transaksi) {
        this.id_transaksi = id_transaksi;
    }
    
    public String getId_sparepart() {
        return id_sparepart;
    }
    
    public void setId_sparepart(String id_sparepart) {
        this.id_sparepart = id_sparepart;
    }
    
    public int getJumlah_beli() {
        return jumlah_beli;
    }
    
    public void setJumlah_beli(int jumlah_beli) {
        this.jumlah_beli = jumlah_beli;
    }
    
    public int getTotal_beli() {
        return total_beli;
    }
    
    public void setTotal_beli(int total_beli) {
        this.total_beli = total_beli;
    }
}

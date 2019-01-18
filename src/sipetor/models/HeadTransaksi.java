package sipetor.models;

/**
 *
 * @author Rizki Ramadhan
 */
public class HeadTransaksi {
    
    private String id_transaksi;
    private String id_karyawan;
    private String tnkb_pelanggan;
    private String tanggal_transaksi;
    private int pembayaran;
    private int sub_total;
    
    public HeadTransaksi(String id_transaksi, String id_karyawan, 
            String tnkb_pelanggan, String tanggal_transaksi, 
            int pembayaran, int sub_total){
        this.id_transaksi = id_transaksi;
        this.id_karyawan = id_karyawan;
        this.tnkb_pelanggan = tnkb_pelanggan;
        this.tanggal_transaksi = tanggal_transaksi;
        this.pembayaran = pembayaran;
        this.sub_total = sub_total;
    }
    
    public String getId_transaksi() {
        return id_transaksi;
    }
    
    public void setId_transaksi(String id_transaksi) {
        this.id_transaksi = id_transaksi;
    }
    
    public String getId_karyawan() {
        return id_karyawan;
    }
    
    public void setId_karyawan(String id_karyawan) {
        this.id_karyawan = id_karyawan;
    }
    
    public String getTnkb_pelanggan() {
        return tnkb_pelanggan;
    }
    
    public void setTnkb_pelanggan(String tnkb_pelanggan) {
        this.tnkb_pelanggan = tnkb_pelanggan;
    }
    
    public String getTanggal_transaksi() {
        return tanggal_transaksi;
    }
    
    public void setTanggal_transaksi(String tanggal_transaksi) {
        this.tanggal_transaksi = tanggal_transaksi;
    }
    
    public int getPembayaran() {
        return pembayaran;
    }
    
    public void setPembayaran(int pembayaran) {
        this.pembayaran = pembayaran;
    }

    public int getSub_total() {
        return sub_total;
    }

    public void setSub_total(int sub_total) {
        this.sub_total = sub_total;
    }
}

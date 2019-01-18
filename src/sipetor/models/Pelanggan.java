package sipetor.models;

/**
 *
 * @author Rizki Ramadhan
 */
public class Pelanggan {
    
    private String tnkb_pelanggan;
    private String nama_pelanggan;
    private String alamat_pelanggan;
    
    public Pelanggan(String tnkb_pelanggan, String nama_pelanggan, String alamat_pelanggan){
        this.tnkb_pelanggan = tnkb_pelanggan;
        this.nama_pelanggan = nama_pelanggan;
        this.alamat_pelanggan = alamat_pelanggan;
    }
    
    public String getTnkb_pelanggan() {
        return tnkb_pelanggan;
    }

    public void setTnkb_pelanggan(String tnkb_pelanggan) {
        this.tnkb_pelanggan = tnkb_pelanggan;
    }

    public String getNama_pelanggan() {
        return nama_pelanggan;
    }
    
    public void setNama_pelanggan(String nama_pelanggan) {
        this.nama_pelanggan = nama_pelanggan;
    }
    
    public String getAlamat_pelanggan() {
        return alamat_pelanggan;
    }
    
    public void setAlamat_pelanggan(String alamat_pelanggan) {
        this.alamat_pelanggan = alamat_pelanggan;
    }
}

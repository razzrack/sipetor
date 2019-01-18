package sipetor.models;

public class Karyawan {
    private String nik;
    private String nama_karyawan;
    private String alamat_karyawan;
    private String email_karyawan;
    private byte id_golongan;
    
    public Karyawan(String nik,String nama_karyawan,
            String alamat_karyawan,String email_karyawan,
            byte id_golongan){
        
        this.nik = nik;
        this.nama_karyawan = nama_karyawan;
        this.alamat_karyawan = alamat_karyawan;
        this.email_karyawan = email_karyawan;
        this.id_golongan = id_golongan;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama_karyawan() {
        return nama_karyawan;
    }

    public void setNama_karyawan(String nama_karyawan) {
        this.nama_karyawan = nama_karyawan;
    }

    public String getAlamat_karyawan() {
        return alamat_karyawan;
    }

    public void setAlamat_karyawan(String alamat_karyawan) {
        this.alamat_karyawan = alamat_karyawan;
    }

    public String getEmail_karyawan() {
        return email_karyawan;
    }

    public void setEmail_karyawan(String email_karyawan) {
        this.email_karyawan = email_karyawan;
    }

    public byte getId_golongan() {
        return id_golongan;
    }

    public void setId_golongan(byte id_golongan) {
        this.id_golongan = id_golongan;
    }
}

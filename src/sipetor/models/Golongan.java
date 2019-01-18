package sipetor.models;

public class Golongan {
    private byte id_golongan;
    private String nama_golongan;
    
    public Golongan(byte id_golongan, String nama_golongan){
        this.id_golongan = id_golongan;
        this.nama_golongan = nama_golongan;
    }

    public byte getId_golongan() {
        return id_golongan;
    }

    public void setId_golongan(byte id_golongan) {
        this.id_golongan = id_golongan;
    }

    public String getNama_golongan() {
        return nama_golongan;
    }

    public void setNama_golongan(String nama_golongan) {
        this.nama_golongan = nama_golongan;
    }
}
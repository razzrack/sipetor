package sipetor.controller;

import java.util.List;
import sipetor.model.query.QueryKaryawan;
import sipetor.models.Karyawan;

public class ControllerKaryawan {
    private QueryKaryawan queryKaryawan = new QueryKaryawan();
    
    public List<Karyawan> getAllData() {
        return queryKaryawan.getAllKaryawan();
    }
    
    public List<Karyawan> getAllKaryawanByName(String nama_karyawan){
        return queryKaryawan.getAllKaryawanByName(nama_karyawan);   
    }
    
    public boolean insertKaryawan(Karyawan data){
        return queryKaryawan.insert(data);   
    }
    
    public boolean updateKaryawan(Karyawan data){
        return queryKaryawan.update(data);   
    }
    
    public boolean deleteKaryawan(String nik){
        return queryKaryawan.delete(nik);   
    }
}

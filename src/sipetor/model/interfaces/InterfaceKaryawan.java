package sipetor.model.interfaces;

import java.util.List;
import sipetor.models.Karyawan;

public interface InterfaceKaryawan {
    public boolean insert(Karyawan data);
    public boolean update(Karyawan data);
    public boolean delete(String nik);
    
    public List<Karyawan> getAllKaryawan();
    
    public Karyawan getOneKaryawanByID(String nik);
    
    public List<Karyawan> getAllKaryawanByName(String nama_karyawan);
}

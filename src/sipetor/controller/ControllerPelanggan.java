package sipetor.controller;

import java.util.List;
import sipetor.model.query.QueryPelanggan;
import sipetor.models.Pelanggan;

/**
 *
 * @author Rizki Ramadhan
 */
public class ControllerPelanggan {
    private QueryPelanggan queryPelanggan = new QueryPelanggan();
    
    public List<Pelanggan> getAllData(){
        return queryPelanggan.getAllPelanggan();
    }
    
    public List<Pelanggan> getAllPelangganByName(String nama_pelanggan){
        return queryPelanggan.getAllPelangganByName(nama_pelanggan);
    }
    
    public boolean insertPelanggan(Pelanggan data){
        return queryPelanggan.insert(data);
    }
    
    public boolean updatePelanggan(Pelanggan data){
        return queryPelanggan.update(data);
    }
    
    public boolean deletePelanggan(String tnkb_pelanggan){
        return queryPelanggan.delete(tnkb_pelanggan);
    }
}

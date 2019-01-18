package sipetor.controller;

import java.util.List;
import sipetor.model.query.QuerySparepart;
import sipetor.models.Sparepart;

/**
 *
 * @author Rizki Ramadhan
 */
public class ControllerSparepart {
    private QuerySparepart querySparepart = new QuerySparepart();
    
    public List<Sparepart> getAllData(){
        return querySparepart.getAllSparepart();
    }
    
    public List<Sparepart> getAllSparepartByName(String nama_sparepart){
        return querySparepart.getAllSparepartByName(nama_sparepart);
    }
    
    public boolean insertSparepart(Sparepart data){
        return querySparepart.insert(data);
    }
    
    public boolean updateSparepart(Sparepart data){
        return querySparepart.update(data);
    }
    
    public boolean deleteSparepart(int id_sparepart){
        return querySparepart.delete(id_sparepart);
    }
    
    public int generateID(){
        return querySparepart.generateID();
    }
}

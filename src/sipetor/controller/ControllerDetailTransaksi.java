package sipetor.controller;

import java.util.List;
import sipetor.model.query.QueryDetailTransaksi;
import sipetor.models.DetailTransaksi;

/**
 *
 * @author Rizki Ramadhan
 */
public class ControllerDetailTransaksi {
    private QueryDetailTransaksi queryDetailTransaksi = new QueryDetailTransaksi();
    
    public List<DetailTransaksi> getAllData(){
        return queryDetailTransaksi.getAllDetailTransaksi();
    }
    
    public boolean insertDetailTransaksi(DetailTransaksi data){
        return queryDetailTransaksi.insert(data);
    }
    
    public boolean updateDetailTransaksi(DetailTransaksi data){
        return queryDetailTransaksi.update(data);
    }
    
    public boolean deleteDetailTransaksi(String id_transaksi, String id_sparepart){
        return queryDetailTransaksi.delete(id_transaksi,id_sparepart);
    }
    
    public int generateID(){
        return queryDetailTransaksi.generateID();
    }
    
    public int generateIDReg(){
        return queryDetailTransaksi.generateIDReg();
    }
}

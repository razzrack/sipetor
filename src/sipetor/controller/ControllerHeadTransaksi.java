package sipetor.controller;

import java.util.List;
import sipetor.model.query.QueryHeadTransaksi;
import sipetor.models.HeadTransaksi;

/**
 *
 * @author Rizki Ramadhan
 */
public class ControllerHeadTransaksi {
    private QueryHeadTransaksi queryHeadTransaksi = new QueryHeadTransaksi();
    
    public List<HeadTransaksi> getAllData(){
        return queryHeadTransaksi.getAllHeadTransaksi();
    }
    
    public boolean insertHeadTransaksi(HeadTransaksi data){
        return queryHeadTransaksi.insert(data);
    }
    
    public boolean updateHeadTransaksi(HeadTransaksi data){
        return queryHeadTransaksi.update(data);
    }
    
    public boolean deleteHeadTransaksi(String id_transaksi){
        return queryHeadTransaksi.delete(id_transaksi);
    }
    
    public String generateID(){
        return queryHeadTransaksi.generateID();
    }
}

package sipetor.model.interfaces;

import java.util.List;
import sipetor.models.DetailTransaksi;

/**
 *
 * @author Rizki Ramadhan
 */
public interface InterfaceDetailTransaksi {
    public boolean insert(DetailTransaksi data);
    public boolean update(DetailTransaksi data);
    public boolean delete(String id_transaksi, String id_sparepart);
    
    public int generateID();
    
    public int generateIDReg();
    
    public List<DetailTransaksi> getAllDetailTransaksi();
    
    public DetailTransaksi getOneDetailTransaksiByID(String id_transaksi);
    
    public List<DetailTransaksi> getAllDetailTransaksiByID(String id_transaksi);
}
